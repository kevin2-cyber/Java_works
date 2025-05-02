package android.room.view.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.room.view.R;
import android.room.view.databinding.ActivityNewWordBinding;
import android.text.TextUtils;
import android.widget.EditText;

public class NewWordActivity extends AppCompatActivity {

    ActivityNewWordBinding binding;
    static final String EXTRA_REPLY = "android.room.view";
    EditText mEditWordView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityNewWordBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        mEditWordView = findViewById(R.id.edit_word);

        binding.buttonSave.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mEditWordView.getText())){
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String word = mEditWordView.getText().toString();
                replyIntent.putExtra(EXTRA_REPLY, word);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}