package ru.s.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;

public class NoticeFormActivity extends AppCompatActivity {

    EditText titleEdit, addressEdit, priceEdit, descriptionEdit;

    protected void initViews() {

        Button btn = findViewById(R.id.btn_notice_submit);

        titleEdit = findViewById(R.id.edit_notice_title);
        addressEdit = findViewById(R.id.edit_notice_address);
        priceEdit = findViewById(R.id.edit_notice_price);
        descriptionEdit = findViewById(R.id.edit_notice_description);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String title = titleEdit.getText().toString();
                String address = addressEdit.getText().toString();
                String price = priceEdit.getText().toString();
                String description = descriptionEdit.getText().toString();

                if ((title.length() == 0) || (address.length() == 0) || (price.length() == 0) || (description.length() == 0)) {

                    Toast.makeText(NoticeFormActivity.this, "Заполните все поля.", Toast.LENGTH_LONG).show();
                    return;

                } else {

                    File file = new File(getExternalFilesDir(""), "notices.txt");

                    try {

                        StringBuilder sBuilder = new StringBuilder();
                        sBuilder.append(title);
                        sBuilder.append(";");
                        sBuilder.append(address);
                        sBuilder.append(";");
                        sBuilder.append(price);
                        sBuilder.append(";");
                        sBuilder.append(description);
                        sBuilder.append("\n");

                        FileWriter writer = new FileWriter(file, true);
                        writer.append(sBuilder.toString());
                        writer.close();

                    } catch (Exception e) {

                        //

                    }

                    Intent intent = new Intent(NoticeFormActivity.this, ListActivity.class);
                    startActivity(intent);

                }

            }

        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_form);

        initViews();

    }

}
