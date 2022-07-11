package kevin.codelab.sleepapi

import android.Manifest
import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.viewbinding.BuildConfig
import com.google.android.gms.location.ActivityRecognition
import com.google.android.gms.location.SleepSegmentRequest
import com.google.android.material.snackbar.Snackbar
import kevin.codelab.sleepapi.databinding.ActivityMainBinding
import kevin.codelab.sleepapi.receiver.SleepReceiver
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by lazy {
        MainViewModel((application as MainApplication).repository)
    }

    // Used to construct the output from multiple tables (very basic implementation just to show
    // the live data coming in).
    private var sleepSegmentOutput: String = ""
    private var sleepClassifyOutput: String = ""

    // Status of subscription to sleep data. This is stored in [SleepSubscriptionStatus] which saves
    // the data in a [DataStore] in case the user navigates away from the app.
    private var subscribedToSleepData = false
    set(newSubscribedToSleepData) {
        field = newSubscribedToSleepData
        if (newSubscribedToSleepData) {
            binding.button.text = getString(R.string.sleep_button_unsubscribe_text)
        } else {
            binding.button.text = getString(R.string.sleep_button_subscribe_text)
        }

        updateOutput()
    }

    private lateinit var sleepPendingIntent: PendingIntent


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.subscribedToSleepDataLiveData.observe(this) { newSubscribedToSleepData ->
            if (subscribedToSleepData != newSubscribedToSleepData) {
                subscribedToSleepData = newSubscribedToSleepData
            }
        }

        // Adds observers on LiveData from [SleepRepository]. Data is saved to the database via
        // [SleepReceiver] and when that data changes, we get notified of changes.
        // Note: The data returned is Entity versions of the sleep classes, so they don't contain
        // all the data, as I just saved the minimum to show it's being saved.
        mainViewModel.allSleepSegments.observe(this) { sleepSegmentEventEntities ->
            Log.d(TAG, "sleepSegmentEventEntities: $sleepSegmentEventEntities")

            if (sleepSegmentEventEntities.isNotEmpty()) {
                // Constructor isn't accessible for [SleepSegmentEvent], so we just output the
                // database table version.
                sleepSegmentOutput = sleepSegmentEventEntities.joinToString {
                    "\t$it\n"
                }
                updateOutput()
            }
        }

        mainViewModel.allSleepClassifyEventEntities.observe(this) {
                sleepClassifyEventEntities ->
            Log.d(TAG, "sleepClassifyEventEntities: $sleepClassifyEventEntities")

            if (sleepClassifyEventEntities.isNotEmpty()) {
                // Constructor isn't accessible for [SleepClassifyEvent], so we just output the
                // database table version.
                sleepClassifyOutput = sleepClassifyEventEntities.joinToString {
                    "\t$it\n"
                }
                updateOutput()
            }

        }

        sleepPendingIntent = SleepReceiver.createSleepReceiverPendingIntent(context = applicationContext)
    }


    fun onClickRequestSleepData(view: View) {
        if (activityRecognitionPermissionApproved()) {
            if (subscribedToSleepData) {
                unsubscribeToSleepSegmentUpdates(applicationContext, sleepPendingIntent)
            } else {
                subscribeToSleepSegmentUpdates(applicationContext, sleepPendingIntent)
            }
        } else {
            requestPermissionLauncher.launch(Manifest.permission.ACTIVITY_RECOGNITION)
        }
    }

    // Permission is checked before this method is called.
    @SuppressLint("MissingPermission")
    private fun subscribeToSleepSegmentUpdates(context: Context, pendingIntent: PendingIntent) {
        Log.d(TAG, "requestSleepSegmentUpdates()")
        val task = ActivityRecognition.getClient(context).requestSleepSegmentUpdates(
            pendingIntent,
            // Registers for both SleepSegmentEvent and SleepClassifyEvent data.
            SleepSegmentRequest.getDefaultSleepSegmentRequest()
        )

        task.addOnSuccessListener {
            mainViewModel.updateSubscribedToSleepData(true)
            Log.d(TAG, "Successfully subscribed to sleep data.")
        }
        task.addOnFailureListener { exception ->
            Log.d(TAG, "Exception when subscribing to sleep data: $exception")
        }
    }

    private fun unsubscribeToSleepSegmentUpdates(context: Context, pendingIntent: PendingIntent) {
        Log.d(TAG, "unsubscribeToSleepSegmentUpdates()")
        val task = ActivityRecognition.getClient(context).removeSleepSegmentUpdates(pendingIntent)

        task.addOnSuccessListener {
            mainViewModel.updateSubscribedToSleepData(false)
            Log.d(TAG, "Successfully unsubscribed to sleep data.")
        }
        task.addOnFailureListener { exception ->
            Log.d(TAG, "Exception when unsubscribing to sleep data: $exception")
        }
    }

    // TODO: Review Activity Recognition permission checking.
    private fun activityRecognitionPermissionApproved(): Boolean {
        // Because this app targets 29 and above (recommendation for using the Sleep APIs), we
        // don't need to check if this is on a device before runtime permissions, that is, a device
        // prior to 29 / Q.
        return PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACTIVITY_RECOGNITION
        )
    }

    private val requestPermissionLauncher: ActivityResultLauncher<String> =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (!isGranted) {
                // Permission denied on Android platform that supports runtime permissions.
                displayPermissionSettingsSnackBar()
            } else {
                // Permission was granted (either by approval or Android version below Q).
                binding.outputTv.text = getString(R.string.permission_approved)
            }
        }

    private fun displayPermissionSettingsSnackBar() {
        Snackbar.make(
            binding.mainActivity,
            R.string.permission_rational,
            Snackbar.LENGTH_LONG
        )
            .setAction(R.string.action_settings) {
                // Build intent that displays the App settings screen.
                val intent = Intent()
                intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                val uri = Uri.fromParts(
                    "package",
                    BuildConfig.APPLICATION_ID,
                    null
                )
                intent.data = uri
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }
            .show()
    }

    private fun updateOutput() {
        Log.d(TAG, "updateOutput()")

        val header = if (subscribedToSleepData) {
            val timestamp = Calendar.getInstance().time.toString()
            getString(R.string.main_output_header1_subscribed_sleep_data, timestamp)
        } else {
            getString(R.string.main_output_header1_unsubscribed_sleep_data)
        }

        val sleepData = getString(
            R.string.main_output_header2_and_sleep_data,
            sleepSegmentOutput,
            sleepClassifyOutput
        )

        val newOutput = header + sleepData
        binding.outputTv.text = newOutput
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}