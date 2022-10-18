package com.codelab.simplesignin;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.codelab.simplesignin.databinding.ActivityMainBinding;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        Glide.with(getApplicationContext()).load(R.drawable.google)
                .apply(bitmapTransform(new BlurTransformation(2)))
                .into((ImageView) findViewById(R.id.google));

        Glide.with(getApplicationContext()).load(R.drawable.fb)
                .apply(bitmapTransform(new BlurTransformation(2)))
                .into((ImageView) findViewById(R.id.fb));

        Glide.with(getApplicationContext()).load(R.drawable.twitter)
                .apply(bitmapTransform(new BlurTransformation(2)))
                .into((ImageView) findViewById(R.id.twitter));

        Glide.with(getApplicationContext()).load(R.drawable.github)
                .apply(bitmapTransform(new BlurTransformation(2)))
                .into((ImageView) findViewById(R.id.github));

        binding.loginbtn.setOnClickListener(
                view -> {
                    validateData();
                }
        );
    }

    private void validateData(){
        if (binding.username.getText().toString().equals("admin") && binding.password.getText().toString().equals("password")) {
            login();
        } else {
            Toast.makeText(MainActivity.this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();
        }
    }

    private void login(){
        startActivity(new Intent(this, WelcomeActivity.class));
        Toast.makeText(MainActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
    }
}