package ru.s.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PhoneActivity extends AppCompatActivity {

    EditText phoneNumberEdit, messageEdit;

    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 11;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 12;

    protected boolean checkPermission(String permission, int request) {

        boolean can = checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;

        if (!can) {
            ActivityCompat.requestPermissions(PhoneActivity.this, new String[]{permission}, request);
        }

        return can;
    }

    protected void call() {

        if (checkPermission(Manifest.permission.CALL_PHONE, MY_PERMISSIONS_REQUEST_CALL_PHONE)) {

            String phone = phoneNumberEdit.getText().toString();
            Uri uri = Uri.parse("tel:" + phone);

            Intent intent = new Intent(Intent.ACTION_CALL, uri);
            startActivity(intent);

        }

    }

    protected void send() {

        if (checkPermission(Manifest.permission.SEND_SMS, MY_PERMISSIONS_REQUEST_SEND_SMS)) {

            String phone = phoneNumberEdit.getText().toString();
            String message = messageEdit.getText().toString();

            SmsManager manager = SmsManager.getDefault();
            manager.sendTextMessage(phone, null, message, null, null);

        }

    }

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
                call();
            }
        });

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            switch (requestCode) {

                case MY_PERMISSIONS_REQUEST_CALL_PHONE: {
                    call();
                }

                case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                    send();
                }

            }

        } else {

            finish();

        }

    }

}
