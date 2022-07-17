package kevin.codelab.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import kevin.codelab.splashscreen.databinding.ActivityMainBinding
import kotlin.properties.ReadOnlyProperty

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    private fun viewModels(): ReadOnlyProperty<MainActivity, MainViewModel> {
        TODO("Not yet implemented")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition(
                viewModel.isLoading.value
            )
        }
        setContentView(binding.root)
    }

    private fun setKeepOnScreenCondition(condition: Boolean) {
        TODO("Not yet implemented")
    }
}