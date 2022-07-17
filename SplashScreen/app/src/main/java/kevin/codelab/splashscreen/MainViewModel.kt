package kevin.codelab.splashscreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {

    private val _isLoading = MutableStateFlow(true)

    val isLoading = _isLoading.asStateFlow()

    init {
        viewModelScope.launch {
            delay1(3000)
            _isLoading.value = false
        }
    }
}