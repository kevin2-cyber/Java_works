package kevin.codelab.sleepapi

import androidx.lifecycle.*
import kevin.codelab.sleepapi.data.SleepRepository
import kevin.codelab.sleepapi.data.db.SleepClassifyEventEntity
import kevin.codelab.sleepapi.data.db.SleepSegmentEventEntity
import kotlinx.coroutines.launch

class MainViewModel(private val repository: SleepRepository) : ViewModel() {

    val subscribedToSleepDataLiveData = repository.subscribedToSleepDataFlow.asLiveData()

    fun updateSubscribedToSleepData(subscribed: Boolean) = viewModelScope.launch {
        repository.updateSubscribedToSleepData(subscribed)
    }

    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allSleepSegments: LiveData<List<SleepSegmentEventEntity>> =
        repository.allSleepSegmentEvents.asLiveData()

    val allSleepClassifyEventEntities: LiveData<List<SleepClassifyEventEntity>> =
        repository.allSleepClassifyEvents.asLiveData()
}

class MainViewModelFactory(private val repository: SleepRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}