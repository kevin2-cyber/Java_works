package kevin.codelab.nameapp;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvTextOne = findViewById(R.id.tv_text_1);
        TextView tvTextTwo = findViewById(R.id.tv_text_2);

        tvTextOne.setOnClickListener(v ->
                Toast.makeText(this,"Clicked Text one", Toast.LENGTH_LONG).show()
        );

        tvTextTwo.setOnClickListener(v ->
                Toast.makeText(this,"Clicked Text Two", Toast.LENGTH_LONG).show()
        );
    }
}
