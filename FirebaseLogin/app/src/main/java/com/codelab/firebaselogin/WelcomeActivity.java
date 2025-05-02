package com.codelab.firebaselogin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.codelab.firebaselogin.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends AppCompatActivity {

    private static ActivityWelcomeBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
    }
}
