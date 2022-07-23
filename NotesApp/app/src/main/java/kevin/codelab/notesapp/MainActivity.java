package kevin.codelab.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        binding.signUpBtn.setOnClickListener(
                view ->
                startActivity(
                        new Intent(this, SignUpActivity.class)
                )
        );
        finish();

        binding.signInBtn.setOnClickListener(
                view ->
                        startActivity(
                                new Intent(this, LoginActivity.class)
                        )
        );
        finish();

    }
}