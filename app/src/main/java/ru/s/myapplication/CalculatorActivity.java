package ru.s.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private TextView textView;
    private LinearLayout engineerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        textView = findViewById(R.id.calculatorTextView);
        engineerLayout = findViewById(R.id.engineerLine);

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

}