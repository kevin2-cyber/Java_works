package kevin.codelab.sleepapi.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

const val SLEEP_PREFERENCES_NAME = "sleep_preferences"

class SleepSubscriptionStatus(private val dataStore: DataStore<Preferences>){

    private object PreferencesKeys {
        val SUBSCRIBED_TO_SLEEP_DATA = booleanPreferencesKey("subscribed_to_sleep_data")
    }

    // Observed Flow will notify the observer when the sleep subscription status has changed.
    val subscribedToSleepDataFlow: Flow<Boolean> = dataStore.data.map { preferences ->
        // Get the subscription value, defaults to false if not set:
        preferences[PreferencesKeys.SUBSCRIBED_TO_SLEEP_DATA] ?: false
    }

    // Updates subscription status
    suspend fun updateSubscribedToSleepData(subscribedToSleepData: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.SUBSCRIBED_TO_SLEEP_DATA] = subscribedToSleepData
        }
    }
}