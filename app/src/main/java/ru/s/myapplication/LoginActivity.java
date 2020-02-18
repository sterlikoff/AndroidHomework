package ru.s.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LoginActivity extends AppCompatActivity {

    private EditText editLogin, editPassword;

    protected boolean checkFields() {

        if (editLogin.getText().toString().length() == 0 || editPassword.getText().toString().length() == 0) {

            Toast.makeText(this, R.string.emptyFieldsMessage, Toast.LENGTH_LONG).show();
            return false;

        }

        return true;
    }

    protected void initViews() {

        editLogin = findViewById(R.id.edit_login);
        editPassword = findViewById(R.id.edit_password);

        Button btnLogin = findViewById(R.id.btn_login);
        Button btnRegistration = findViewById(R.id.btn_registration);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!checkFields()) return;

                FileInputStream fileInputStream;

                try {

                    fileInputStream = openFileInput("login.bin");

                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                    BufferedReader reader = new BufferedReader(inputStreamReader);

                    String cLogin = reader.readLine();

                    fileInputStream = openFileInput("password.bin");

                    inputStreamReader = new InputStreamReader(fileInputStream);
                    reader = new BufferedReader(inputStreamReader);

                    String cPassword = reader.readLine();

                    String login = editLogin.getText().toString();
                    String password = editLogin.getText().toString();

                    if (login.equals(cLogin)) {

                        if (password.equals(cPassword)) {

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);

                        } else {

                            Toast.makeText(LoginActivity.this, R.string.incorrectPasswordMessage, Toast.LENGTH_LONG).show();

                        }

                    } else {
                        Toast.makeText(LoginActivity.this, R.string.incorrectLoginMessage, Toast.LENGTH_LONG).show();
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });

        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!checkFields()) return;

                String login = editLogin.getText().toString();
                String password = editLogin.getText().toString();

                FileOutputStream fileOutputStream;

                try {

                    fileOutputStream = openFileOutput("login.bin", MODE_PRIVATE);

                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                    BufferedWriter bw = new BufferedWriter(outputStreamWriter);
                    bw.write(login);
                    bw.close();

                    fileOutputStream = openFileOutput("password.bin", MODE_PRIVATE);

                    outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                    bw = new BufferedWriter(outputStreamWriter);
                    bw.write(password);
                    bw.close();

                    Toast.makeText(LoginActivity.this, R.string.registrationSuccessMessage, Toast.LENGTH_LONG).show();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

    }
}
