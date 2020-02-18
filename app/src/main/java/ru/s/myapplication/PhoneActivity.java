package ru.s.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PhoneActivity extends AppCompatActivity {

    EditText phoneNumberEdit, messageEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        phoneNumberEdit = findViewById(R.id.edit_phone_number);
        messageEdit = findViewById(R.id.edit_message_text);

        Button callBtn = findViewById(R.id.btn_call);
        Button sendBtn = findViewById(R.id.btn_send);

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phone = phoneNumberEdit.getText().toString();
                Uri uri = Uri.parse("tel:" + phone);

                Intent intent = new Intent(Intent.ACTION_CALL, uri);
                startActivity(intent);

            }
        });

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phone = phoneNumberEdit.getText().toString();
                String message = messageEdit.getText().toString();

                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage(phone, null, message, null, null);

            }
        });

    }
}
