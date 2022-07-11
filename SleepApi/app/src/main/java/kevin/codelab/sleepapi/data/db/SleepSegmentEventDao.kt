package kevin.codelab.sleepapi.data.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface SleepSegmentEventDao {
    @Query("SELECT * FROM sleep_classify_events_table ORDER BY start_time_millis DESC")
    fun getAll(): Flow<List<SleepSegmentEventEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(sleepSegmentEventEntity: SleepSegmentEventEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(sleepSegmentEventEntities: List<SleepSegmentEventEntity>)

    @Delete
    suspend fun delete(sleepSegmentEventEntity: SleepSegmentEventEntity)

    @Query("DELETE FROM sleep_segment_events_table")
    suspend fun deleteAll()
}