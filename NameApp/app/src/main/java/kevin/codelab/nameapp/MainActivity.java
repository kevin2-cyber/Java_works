package kevin.codelab.nameapp;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import kevin.codelab.nameapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());


        binding.tvText1.setOnClickListener(v ->
                Toast.makeText(this,"Clicked Text one", Toast.LENGTH_LONG).show()
        );

        binding.tvText2.setOnClickListener(v ->
                Toast.makeText(this,"Clicked Text Two", Toast.LENGTH_LONG).show()
        );
    }
}
