package com.codelab.simplesignin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.codelab.simplesignin.databinding.ActivityWelcomeBinding;
import com.google.android.material.button.MaterialButton;

public class WelcomeActivity extends AppCompatActivity {
    private ActivityWelcomeBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mBinding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(mBinding.getRoot());

        mBinding.logoutBtn.setOnClickListener(view -> {
            startActivity(new Intent(this, MainActivity.class));
        });
    }
}