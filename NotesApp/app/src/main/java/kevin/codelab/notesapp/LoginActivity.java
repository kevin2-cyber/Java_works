package kevin.codelab.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import kevin.codelab.notesapp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());


        binding.btnLogin.setOnClickListener(
                view ->
                        firebaseLogin()
        );
    }

    private void firebaseLogin(){
        startActivity(new Intent(this, HomeActivity.class));
    }
}