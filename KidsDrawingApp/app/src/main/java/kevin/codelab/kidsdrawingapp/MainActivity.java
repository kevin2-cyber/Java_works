package kevin.codelab.kidsdrawingapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import kevin.codelab.kidsdrawingapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding = null;
    private @Nullable
    ImageButton mImageButtonCurrentPaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
}