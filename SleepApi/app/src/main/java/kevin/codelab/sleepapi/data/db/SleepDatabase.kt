package kevin.codelab.sleepapi.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


private const val DATABASE_NAME = "sleep_segments_database"

@Database(
    entities = [SleepSegmentEventEntity::class, SleepClassifyEventEntity::class],
    version = 3,
    exportSchema = false
)
abstract class SleepDatabase : RoomDatabase(){

    abstract fun sleepSegmentEventDao(): SleepSegmentEventDao
    abstract fun sleepClassifyEventDao(): SleepClassifyEventDao

    companion object {
        // For Singleton instantiation
        @Volatile
        private var INSTANCE: SleepDatabase? = null

        fun getDatabase(context: Context): SleepDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    SleepDatabase::class.java,
                    DATABASE_NAME
                )
                // Wipes and rebuilds instead of migrating if no Migration object.
                // Migration is not part of this sample.
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}