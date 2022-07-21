package kevin.codelab.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import kevin.codelab.notesapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        TextView textView = findViewById(R.id.tvHello);
        textView.setOnClickListener(v ->
                Toast.makeText(MainActivity.this,
                                "Nice",
                                Toast.LENGTH_LONG)
                        .show());
    }
}