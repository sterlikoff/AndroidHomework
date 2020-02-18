package ru.s.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private TextView textView;
    private FrameLayout engineerLayout;
    private ImageView backgroundImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        textView = findViewById(R.id.calculatorTextView);
        engineerLayout = findViewById(R.id.engineerLine);
        backgroundImage = findViewById(R.id.background_image);

        Button settingsBtn = findViewById(R.id.settings_button);
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CalculatorActivity.this, CalculatorSettingsActivity.class);
                startActivityForResult( intent, 1);

            }
        });

    }

    public void onButtonClick(View view) {

        Button button = findViewById(view.getId());

        String text = textView.getText().toString();
        String newText = button.getText().toString();

        text += newText;

        textView.setText(text);

    }

    public void onEngineerBtnClick(View view) {

        int currentVisibility = engineerLayout.getVisibility();
        if (currentVisibility == View.GONE) {
            engineerLayout.setVisibility(View.VISIBLE);
        } else {
            engineerLayout.setVisibility(View.GONE);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (data == null) return;

        String path = data.getStringExtra("path");

        Bitmap bitmap = BitmapFactory.decodeFile(path);
        backgroundImage.setImageBitmap(bitmap);

    }
}