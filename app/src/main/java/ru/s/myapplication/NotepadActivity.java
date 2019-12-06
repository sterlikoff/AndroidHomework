package ru.s.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NotepadActivity extends AppCompatActivity {

    private EditText mInputNote;

    private SharedPreferences myNoteSharedPref;

    private static String NOTE_TEXT = "note_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad);

        initViews();

        String noteTxt = myNoteSharedPref.getString(NOTE_TEXT, "");
        mInputNote.setText(noteTxt);

    }

    private void initViews() {

        mInputNote = findViewById(R.id.inputNote);

        myNoteSharedPref = getSharedPreferences("MyNote", MODE_PRIVATE);

    }

    public void onSaveButtonClick(View view) {

        SharedPreferences.Editor myEditor = myNoteSharedPref.edit();
        String noteTxt = mInputNote.getText().toString();
        myEditor.putString(NOTE_TEXT, noteTxt);
        myEditor.apply();
        Toast.makeText(this, "данные сохранены", Toast.LENGTH_LONG).show();

    }

}