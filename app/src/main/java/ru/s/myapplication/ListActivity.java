package ru.s.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ru.s.myapplication.adapters.NoticeListAdapter;
import ru.s.myapplication.model.Notice;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        List<Notice> noticeList = new ArrayList<>();

        noticeList.add(new Notice("House", "Good house", "Moscow", 5000000d, 0));
        noticeList.add(new Notice("House", "Bad house", "Saint-Petersburg", 4900000d, 0));
        noticeList.add(new Notice("Flat", "Good flat", "Simferopol", 3990000d, 0));

        NoticeListAdapter adapter = new NoticeListAdapter(noticeList, this);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

    }
}
