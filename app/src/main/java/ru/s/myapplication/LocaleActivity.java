package ru.s.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Locale;

public class LocaleActivity extends AppCompatActivity {

    private Spinner languagesSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locale);

        initViews();

    }

    protected void initViews() {

        languagesSpinner = findViewById(R.id.languagesSpinner);

        ArrayAdapter<CharSequence> adapterCountries = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapterCountries.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languagesSpinner.setAdapter(adapterCountries);

    }

    public void onSelectLanguageBtnClick(View view) {

        String language = languagesSpinner.getSelectedItem().toString();

        String code = "ru";

        switch (language) {

            case "Украинский":
                code = "uk";
                break;

            case "Английский":
                code = "en";
                break;

        }

        Locale locale = new Locale(code);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();

    }

}
