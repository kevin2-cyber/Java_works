package kevin.codelab.sleepapi

import android.app.Application
import androidx.datastore.preferences.createDataStore
import kevin.codelab.sleepapi.data.SleepRepository
import kevin.codelab.sleepapi.data.datastore.SLEEP_PREFERENCES_NAME
import kevin.codelab.sleepapi.data.datastore.SleepSubscriptionStatus
import kevin.codelab.sleepapi.data.db.SleepDatabase

class MainApplication : Application(){
    // Both database and repository use lazy so they aren't created when the app starts, but only
    // when repository is first needed.
    private val database  by lazy {
        SleepDatabase.getDatabase(applicationContext)
    }

   val repository by lazy {
       SleepRepository(
           sleepSubscriptionStatus = SleepSubscriptionStatus(
               applicationContext.createDataStore(name = SLEEP_PREFERENCES_NAME)
           ),
           sleepSegmentEventDao = database.sleepSegmentEventDao(),
           sleepClassifyEventDao = database.sleepClassifyEventDao()
       )
   }
}