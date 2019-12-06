package ru.s.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        textView = findViewById(R.id.calculatorTextView);

    }

    public void onButtonClick(View view) {

        Button button = findViewById(view.getId());

        String text = textView.getText().toString();
        String newText = button.getText().toString();

        text += newText;

        textView.setText(text);

    }

}