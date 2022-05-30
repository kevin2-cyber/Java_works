package com.codelab.simplesignin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.codelab.simplesignin.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());



        binding.loginbtn.setOnClickListener(
                view -> {
                    if (binding.username.getText().toString().equals("admin") && binding.password.getText().toString().equals("password")) {
                        startActivity(new Intent(this, WelcomeActivity.class));
                        Toast.makeText(MainActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}