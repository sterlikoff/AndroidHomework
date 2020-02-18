package ru.s.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddressActivity extends AppCompatActivity {

    EditText editAddress;

    protected static boolean hasLetters(String string) {

        for (int i = 0; i < string.length(); i++) {
            if (Character.isLetter(string.charAt(i))) return true;
        }

        return false;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        Button btn = findViewById(R.id.btn_geo_submit);
        editAddress = findViewById(R.id.edit_address);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String query = editAddress.getText().toString();

                if (hasLetters(query)) query = "?q=" + query;

                Uri data = Uri.parse("geo:" + query);

                Intent intent = new Intent(Intent.ACTION_VIEW, data);
                startActivity(intent);

            }
        });

    }

}
