package kevin.codelab.drawingapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import kevin.codelab.drawingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // enabled viewBinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // binding.drawingView.setSizeForBrush(20.toFloat())

        binding.ibBrush.setOnClickListener{
            showBrushSizeChooserDialog()
        }
    }

    private fun showBrushSizeChooserDialog() {
        val brushDialog = Dialog(this)
        brushDialog.setContentView(R.layout.dialog_brush_size)
        brushDialog.setTitle("Brush Size: ")
        val smallBtn: ImageButton = brushDialog.findViewById(R.id.ib_small_brush)
        val mediumBtn: ImageButton = brushDialog.findViewById(R.id.ib_medium_brush)
        val largeBtn: ImageButton = brushDialog.findViewById(R.id.ib_large_brush)
        smallBtn.setOnClickListener {
            binding.drawingView.setSizeForBrush(10.toFloat())
            brushDialog.dismiss()
        }

        mediumBtn.setOnClickListener {
            binding.drawingView.setSizeForBrush(20.toFloat())
            brushDialog.dismiss()
        }

        largeBtn.setOnClickListener {
            binding.drawingView.setSizeForBrush(30.toFloat())
            brushDialog.dismiss()
        }

        brushDialog.show()
    }
}