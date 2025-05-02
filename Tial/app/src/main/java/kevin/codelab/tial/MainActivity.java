package kevin.codelab.tial;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import kevin.codelab.tial.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    String email = "kimikevin@zoho.com";
    String password = "12345savage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

    }
}
