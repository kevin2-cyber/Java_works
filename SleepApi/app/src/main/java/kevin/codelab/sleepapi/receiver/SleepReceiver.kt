package kevin.codelab.sleepapi.receiver

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.google.android.gms.location.SleepClassifyEvent
import com.google.android.gms.location.SleepSegmentEvent
import kevin.codelab.sleepapi.MainApplication
import kevin.codelab.sleepapi.data.SleepRepository
import kevin.codelab.sleepapi.data.db.SleepClassifyEventEntity
import kevin.codelab.sleepapi.data.db.SleepSegmentEventEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class SleepReceiver : BroadcastReceiver(){

    // Used to launch coroutines (non-blocking way to insert data).
    private val scope: CoroutineScope = MainScope()

    override fun onReceive(context: Context, intent: Intent) {
        Log.d(TAG, "onReceive(): $intent")

        val repository: SleepRepository = (context.applicationContext as MainApplication).repository

        // TODO: Extract sleep information from PendingIntent.
    }

    private fun addSleepSegmentEventsToDatabase(
        repository: SleepRepository,
        sleepSegmentEvents: List<SleepSegmentEvent>
    ) {
        if (sleepSegmentEvents.isNotEmpty()) {
            scope.launch {
                val convertedToEntityVersion: List<SleepSegmentEventEntity> =
                    sleepSegmentEvents.map {
                        SleepSegmentEventEntity.from(it)
                    }
                repository.insertSleepSegments(convertedToEntityVersion)
            }
        }
    }

    private fun addSleepClassifyEventsToDatabase(
        repository: SleepRepository,
        sleepClassifyEvents: List<SleepClassifyEvent>
    ) {
        if (sleepClassifyEvents.isNotEmpty()) {
            scope.launch {
                val convertedToEntityVersion: List<SleepClassifyEventEntity> =
                    sleepClassifyEvents.map {
                        SleepClassifyEventEntity.from(it)
                    }
                repository.insertSleepClassifyEvents(convertedToEntityVersion)
            }
        }
    }

    companion object {
        const val TAG = "SleepReceiver"
        @SuppressLint("UnspecifiedImmutableFlag")
        fun createSleepReceiverPendingIntent(context: Context): PendingIntent {
            val sleepIntent = Intent(context, SleepReceiver::class.java)
            return PendingIntent.getBroadcast(
                context,
                0,
                sleepIntent,
                PendingIntent.FLAG_CANCEL_CURRENT
            )
        }
    }
}