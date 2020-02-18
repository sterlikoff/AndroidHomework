package ru.s.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ru.s.myapplication.adapters.NoticeListAdapter;
import ru.s.myapplication.model.Notice;

public class ListActivity extends AppCompatActivity {

    private File file;
    private List<Notice> noticeList;
    private NoticeListAdapter adapter;

    private void loadData() {

        noticeList.clear();

        FileReader reader;

        try {

            reader = new FileReader(file);
            Scanner scanner = new Scanner(reader);

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                String[] data = line.split(";");
                Notice notice = new Notice(data[0], data[3], data[1], Double.parseDouble(data[2]), 0);
                noticeList.add(notice);

            }

            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        file = new File(getExternalFilesDir(""), "notices.txt");
        noticeList = new ArrayList<>();

        loadData();

        adapter = new NoticeListAdapter(noticeList,this);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        Button btn = findViewById(R.id.add_item_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ListActivity.this, NoticeFormActivity.class);
                startActivityForResult(intent, 1);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (data == null) return;

        String result = data.getStringExtra("result");

        FileWriter writer;

        try {

            writer = new FileWriter(file, true);
            writer.append(result);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        loadData();
        adapter.notifyDataSetChanged();

    }

}
