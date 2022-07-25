package kevin.codelab.notesapp;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import kevin.codelab.notesapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @RequiresApi(api = Build.VERSION_CODES.S)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        getSplashScreen().setSplashScreenTheme(R.style.Theme_AppCompat_SplashDay);
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