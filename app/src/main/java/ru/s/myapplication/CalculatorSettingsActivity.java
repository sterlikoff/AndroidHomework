package ru.s.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class CalculatorSettingsActivity extends AppCompatActivity {

    EditText editText;
    Button btn;

    protected void initViews() {

        editText = findViewById(R.id.edit_image_path);
        btn = findViewById(R.id.btn_apply_settings);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), editText.getText().toString());

                if (file.exists()) {

                    Intent intent = new Intent();
                    intent.putExtra("path", file.getAbsolutePath());

                    setResult(1, intent);

                    finish();

                } else {
                    Toast.makeText(CalculatorSettingsActivity.this, "Файл не найден", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_settings);

        initViews();

    }
}
