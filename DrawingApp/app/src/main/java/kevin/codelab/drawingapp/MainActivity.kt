package kevin.codelab.drawingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kevin.codelab.drawingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // enabled viewBinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}