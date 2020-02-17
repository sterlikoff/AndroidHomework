package ru.s.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import ru.s.myapplication.adapters.NoticeListAdapter;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        NoticeListAdapter adapter = new NoticeListAdapter(this);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        Button btn = findViewById(R.id.add_item_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ListActivity.this, NoticeFormActivity.class);
                startActivity(intent);

            }
        });

    }
}
