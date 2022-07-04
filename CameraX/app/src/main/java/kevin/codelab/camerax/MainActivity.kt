package kevin.codelab.camerax

import android.Manifest
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private val cameraResultLauncher: ActivityResultLauncher<String> =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()){
                isGranted ->
            if (isGranted){
                Toast.makeText(this,
                    "Permission Granted",
                    Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this,
                    "Permission Denied",
                    Toast.LENGTH_LONG).show()
            }
        }

    private val cameraAndLocation: ActivityResultLauncher<Array<String>> =
        registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()) {
            permission ->
            permission.entries.forEach {
                val permissionName = it.key
                val isGranted = it.value

                if (isGranted) {
                    when (permissionName) {
                        Manifest.permission.ACCESS_FINE_LOCATION -> {
                            Toast.makeText(this,
                                "Permission granted for location",
                                Toast.LENGTH_LONG).show()
                        }
                        Manifest.permission.ACCESS_COARSE_LOCATION -> {
                            Toast.makeText(this,
                                "Permission granted for COARSE",
                                Toast.LENGTH_LONG).show()
                        }
                        else -> {
                            Toast.makeText(this,
                                "Permission Granted for Camera",
                                Toast.LENGTH_LONG).show()
                        }
                    }
                } else {
                    when (permissionName) {
                        Manifest.permission.ACCESS_FINE_LOCATION -> {
                            Toast.makeText(this,
                                "Permission denied for fine location",
                                Toast.LENGTH_LONG).show()
                        }
                        Manifest.permission.ACCESS_COARSE_LOCATION -> {
                            Toast.makeText(this,
                                "Permission denied for COARSE",
                                Toast.LENGTH_LONG).show()
                        }
                        else -> {
                            Toast.makeText(this,
                                "Permission Denied for Camera",
                                Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cameraPermissionBtn: Button = findViewById(R.id.btn_camera_permission)

        cameraPermissionBtn.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
            showRationalDialog(
                "Permission Demo requires camera access",
                "Camera cannot be used because camera access is denied"
            )
           }  else {
               cameraAndLocation.launch(
                   arrayOf(Manifest.permission.CAMERA,
                   Manifest.permission.ACCESS_FINE_LOCATION,
                   Manifest.permission.ACCESS_COARSE_LOCATION)
               )
            }
        }
    }

    private fun showRationalDialog(
        title: String,
        message: String
    ) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle(title)
            .setMessage(message)
            .setPositiveButton("Cancel"){dialog, _->
                dialog.dismiss()
            }
        builder.create().show()
    }
}