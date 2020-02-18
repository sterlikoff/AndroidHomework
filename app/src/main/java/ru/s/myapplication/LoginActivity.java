package ru.s.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class LoginActivity extends AppCompatActivity {

    private EditText editLogin, editPassword;
    private String cLogin, cPassword;
    private boolean inExternal;

    private final String filename = "login.bin";

    protected boolean checkFields() {

        if (editLogin.getText().toString().length() == 0 || editPassword.getText().toString().length() == 0) {

            Toast.makeText(this, R.string.emptyFieldsMessage, Toast.LENGTH_LONG).show();
            return false;

        }

        return true;
    }

    protected void login(String login, String password) {

        loadLoginAndPassword();

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

    }

    protected void registration(String login, String password) {

        cLogin = login;
        cPassword = password;

        saveLoginAndPassword();

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

                String login = editLogin.getText().toString();
                String password = editPassword.getText().toString();

                login(login, password);

            }
        });

        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!checkFields()) return;

                String login = editLogin.getText().toString();
                String password = editPassword.getText().toString();

                registration(login, password);

            }
        });

    }

    protected void loadLoginAndPassword() {

        Reader reader;

        try {

            if (inExternal) {

                File file = new File(getExternalFilesDir(null), filename);
                reader = new FileReader(file);

            } else {

                FileInputStream fileInputStream = openFileInput(filename);
                reader = new InputStreamReader(fileInputStream);

            }

            BufferedReader bufferedReader = new BufferedReader(reader);

            cLogin = bufferedReader.readLine();
            cPassword = bufferedReader.readLine();

        } catch (Exception e) {

            Toast.makeText(this, R.string.errorMessage, Toast.LENGTH_LONG).show();

        }

    }

    protected void saveLoginAndPassword() {

        Writer writer;

        try {

            if (inExternal) {

                File file = new File(getExternalFilesDir(null), filename);
                writer = new FileWriter(file);

            } else {

                FileOutputStream fileOutputStream = openFileOutput(filename, MODE_PRIVATE);
                writer = new OutputStreamWriter(fileOutputStream);

            }

            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(cLogin);
            bufferedWriter.write("\n");
            bufferedWriter.write(cPassword);
            bufferedWriter.close();

            Toast.makeText(LoginActivity.this, R.string.registrationSuccessMessage, Toast.LENGTH_LONG).show();

        } catch (Exception e) {

            Toast.makeText(this, R.string.errorMessage, Toast.LENGTH_LONG).show();

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences preferences = getSharedPreferences("Settings", MODE_PRIVATE);
        inExternal = preferences.getBoolean("saveLoginInExternal", false);

        initViews();

    }

}
