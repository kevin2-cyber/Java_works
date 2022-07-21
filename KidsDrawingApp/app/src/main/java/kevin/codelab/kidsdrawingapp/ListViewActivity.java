package kevin.codelab.kidsdrawingapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import kevin.codelab.kidsdrawingapp.databinding.ActivityListviewBinding;

public class ListViewActivity extends AppCompatActivity {

    @Nullable
    private ActivityListviewBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        binding = ActivityListviewBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
    }
}