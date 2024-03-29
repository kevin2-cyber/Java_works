package kevin.codelab.notesapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import kevin.codelab.notesapp.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {


    ActivitySignUpBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.acbSignUp.setOnClickListener(
                view ->
                        firebaseSignUp()
        );
    }

    private void firebaseSignUp() {
        startActivity(
                new Intent(this, HomeActivity.class)
        );
    }
}