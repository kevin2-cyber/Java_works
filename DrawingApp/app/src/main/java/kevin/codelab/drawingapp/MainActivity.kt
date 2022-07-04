package kevin.codelab.drawingapp

import android.Manifest
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.get
import kevin.codelab.drawingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // enabled viewBinding
    private lateinit var binding: ActivityMainBinding
    private var mImageButtonCurrentPaint: ImageButton? = null

    val requestPermission: ActivityResultLauncher<Array<String>> =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){

            permissions ->
            permissions.entries.forEach {
                val permissionName = it.key
                val isGranted = it.value

                if (isGranted) {
                    Toast.makeText(this,
                        "Permission Granted you can read the storage files",
                        Toast.LENGTH_LONG).show()
                } else {
                    if (permissionName == Manifest.permission.READ_EXTERNAL_STORAGE) {
                        Toast.makeText(this,
                            "Oops you have just denied the permission",
                            Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.drawingView.setSizeForBrush(20.toFloat())

        binding.ibBrush.setOnClickListener{
            showBrushSizeChooserDialog()
        }

        binding.ibSkin.setOnClickListener{
            paintClicked(it)
        }

        binding.ibBlack.setOnClickListener{
            paintClicked(it)
        }

        binding.ibRed.setOnClickListener{
            paintClicked(it)
        }

        binding.ibGreen.setOnClickListener{
            paintClicked(it)
        }

        binding.ibBlue.setOnClickListener{
            paintClicked(it)
        }

        binding.ibYellow.setOnClickListener{
            paintClicked(it)
        }

        binding.ibLollipop.setOnClickListener{
            paintClicked(it)
        }

        binding.ibRandom.setOnClickListener{
            paintClicked(it)
        }

        binding.ibWhite.setOnClickListener {
            paintClicked(it)
        }

        binding.ibGallery.setOnClickListener {
            requestStoragePermission()
        }

        val linearLayoutPaintColors = findViewById<LinearLayout>(R.id.ll_paint_colors)
        mImageButtonCurrentPaint = linearLayoutPaintColors[1] as ImageButton
        mImageButtonCurrentPaint!!.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.pallet_pressed
            )
        )
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

    private fun paintClicked(view: View) {
        Toast.makeText(this, "paint clicked", Toast.LENGTH_LONG).show()
        if (view !== mImageButtonCurrentPaint) {
            val imageButton = view as ImageButton
            val colorTag = imageButton.tag.toString()
            binding.drawingView.setColor(colorTag)
            imageButton.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.pallet_pressed
                )
            )

            mImageButtonCurrentPaint?.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.pallet_normal
                )
            )

            mImageButtonCurrentPaint = view
        }
    }

    private fun requestStoragePermission(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
        )){
            showRationaleDialog("Kids Drawing App",
            "Kids Drawing App needs to Access your External Storage")
        } else {
            requestPermission.launch(
                arrayOf(
                    Manifest.permission.READ_EXTERNAL_STORAGE
                //TODO: Writing External Storage permission
                )
            )
        }
    }

    private fun showRationaleDialog(
        title: String,
        message: String
    ){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle(title)
            .setMessage(message)
            .setPositiveButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
        builder.create().show()
    }
}