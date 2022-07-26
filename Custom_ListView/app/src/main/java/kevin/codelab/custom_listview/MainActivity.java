package kevin.codelab.custom_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<String> list = new ArrayList<>();
    ArrayAdapter<String> adapter;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);

        list.add("Banana");
        list.add("Cocoa");
        list.add("Pawpaw");
        list.add("Cacao");
        list.add("Cheese");
        list.add("Apple");
        list.add("Mango");
        list.add("Garlic");
        list.add("Guava");
        list.add("Pear");
        list.add("Avocado");

        adapter = new ArrayAdapter<>(this, R.layout.list_items, list);
        listView.setAdapter(adapter);

    }
}