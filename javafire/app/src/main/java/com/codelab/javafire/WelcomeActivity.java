package com.codelab.javafire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.codelab.javafire.databinding.ActivityWelcomeBinding;

import java.util.Objects;

public class WelcomeActivity extends AppCompatActivity {

    private ActivityWelcomeBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();

        mBinding.buttonTv.setOnClickListener(view -> {
            startActivity(new Intent(this, LoginActivity.class));
        });
    }
}