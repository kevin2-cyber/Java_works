package kevin.codelab.kidsdrawingapp;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


import kevin.codelab.kidsdrawingapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding = null;
    private @Nullable
    ImageButton mImageButtonCurrentPaint;

    ActivityResultLauncher<String> requestPermission = registerForActivityResult(new ActivityResultContracts.RequestPermission()) {}

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.drawingView.setSizeForBrush(20.0F);

        binding.ibSkin.setOnClickListener(this::paintClicked);

        binding.ibBlack.setOnClickListener(this::paintClicked);

        binding.ibRed.setOnClickListener(this::paintClicked);

        binding.ibGreen.setOnClickListener(this::paintClicked);

        binding.ibBlue.setOnClickListener(this::paintClicked);

        binding.ibYellow.setOnClickListener(this::paintClicked);

        binding.ibLollipop.setOnClickListener(this::paintClicked);

        binding.ibRandom.setOnClickListener(this::paintClicked);

        binding.ibWhite.setOnClickListener(this::paintClicked);

        // LinearLayout linearLayoutPaintColors = (LinearLayout) findViewById(R.id.ll_paint_colors);
        // LinearLayout[] linearLayouts =
        // mImageButtonCurrentPaint = (ImageButton) linearLayoutPaintColors[1];

    }

    private void showBrushSizeChooserDialog() {
        Dialog brushDialog = new Dialog(this);
        brushDialog.setContentView(R.layout.dialog_brush_size);
        brushDialog.setTitle("Brush Size: ");
        ImageButton smallBtn = brushDialog.findViewById(R.id.ib_small_brush);
        ImageButton mediumBtn = brushDialog.findViewById(R.id.ib_medium_brush);
        ImageButton largeBtn = brushDialog.findViewById(R.id.ib_large_brush);

        smallBtn.setOnClickListener(
                view -> {
                    binding.drawingView.setSizeForBrush(10.0F);
                    brushDialog.dismiss();
                }
        );

        mediumBtn.setOnClickListener(
                view -> {
                    binding.drawingView.setSizeForBrush(20.0F);
                    brushDialog.dismiss();
                }
        );

        largeBtn.setOnClickListener(
                view -> {
                    binding.drawingView.setSizeForBrush(30.0F);
                    brushDialog.dismiss();
                }
        );

        brushDialog.show();
    }

    private void paintClicked(View view) {
        Toast.makeText(this,"Paint clicked", Toast.LENGTH_LONG).show();
        if (view != mImageButtonCurrentPaint){
            ImageButton imageButton = (ImageButton) view;
            String colorTag = imageButton.getTag().toString();
            binding.drawingView.setColor(colorTag);
            imageButton.setImageDrawable(
                    ContextCompat.getDrawable(
                            this,
                            R.drawable.pallet_pressed
                    )
            );

            assert mImageButtonCurrentPaint != null;
            mImageButtonCurrentPaint.setImageDrawable(
                    ContextCompat.getDrawable(
                            this,
                            R.drawable.pallet_normal
                    )
            );

            mImageButtonCurrentPaint = (ImageButton) view;
        }
    }

    private void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)) {
            showRationaleDialog("Kids Drawing App",
                    "Kids Drawing App needs Access to your External Storage");
        } else {
            requestPermission.launch(
                    Manifest.permission.READ_EXTERNAL_STORAGE
            );
        }
    }


    private void showRationaleDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("Cancel", (dialog, which) -> {
                    dialog.dismiss();
                });
        builder.create().show();

    }
}