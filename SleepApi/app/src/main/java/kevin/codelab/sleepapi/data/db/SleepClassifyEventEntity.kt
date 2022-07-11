package kevin.codelab.sleepapi.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.gms.location.SleepClassifyEvent


@Entity(tableName = "sleep_classify_events_table")
data class SleepClassifyEventEntity(
    @PrimaryKey
    @ColumnInfo(name = "time_stamp_seconds")
    val timestampSeconds: Int,

    @ColumnInfo(name = "confidence")
    val confidence: Int,

    @ColumnInfo(name = "motion")
    val motion: Int,

    @ColumnInfo(name = "light")
    val light: Int
) {
    companion object {
        fun from(sleepClassifyEvent: SleepClassifyEvent): SleepClassifyEventEntity {
            return SleepClassifyEventEntity(
                timestampSeconds = (sleepClassifyEvent.timestampMillis / 1000).toInt(),
                confidence = sleepClassifyEvent.confidence,
                motion = sleepClassifyEvent.motion,
                light = sleepClassifyEvent.light
            )
        }
    }
}