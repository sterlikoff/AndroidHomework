package ru.s.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubscribeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe);

        final EditText nameEdit = findViewById(R.id.nameEditText);
        final EditText emailEdit = findViewById(R.id.emailEditText);
        final TextView resultView = findViewById(R.id.resultView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String name = nameEdit.getText().toString();
                String email = emailEdit.getText().toString();

                String result = getString(R.string.responseText, name, email);

                resultView.setText(result);

            }

        });

        Button clearButton = findViewById(R.id.clearButton);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nameEdit.setText("");
                emailEdit.setText("");
                resultView.setText("");

            }
        });

    }
}
