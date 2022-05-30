package com.codelab.simplesignin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        MaterialButton button = findViewById(R.id.logout_btn);
        TextView textView = findViewById(R.id.input_text);

        button.setOnClickListener(view -> {
            startActivity(new Intent(this, MainActivity.class));
        });
    }
}