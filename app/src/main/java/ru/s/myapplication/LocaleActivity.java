package ru.s.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Locale;

import ru.s.myapplication.utils.Utils;

public class LocaleActivity extends AppCompatActivity {

    private Spinner languagesSpinner;
    private Spinner themesSpinner;
    private Spinner marginsSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_locale);

        initViews();

    }

    protected void initViews() {

        languagesSpinner = findViewById(R.id.languagesSpinner);

        ArrayAdapter<CharSequence> languagesAdapter = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        languagesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languagesSpinner.setAdapter(languagesAdapter);

        themesSpinner = findViewById(R.id.themesSpinner);

        ArrayAdapter<CharSequence> themesAdapter = ArrayAdapter.createFromResource(this, R.array.themes, android.R.layout.simple_spinner_item);
        themesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        themesSpinner.setAdapter(themesAdapter);

        marginsSpinner = findViewById(R.id.marginsSpinner);

        ArrayAdapter<CharSequence> marginsAdapter = ArrayAdapter.createFromResource(this, R.array.margins, android.R.layout.simple_spinner_item);
        marginsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        marginsSpinner.setAdapter(marginsAdapter);

    }

    protected void applyLanguage() {

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

    protected void applyTheme() {

        String language = themesSpinner.getSelectedItem().toString();

        int theme = Utils.THEME_DEFAULT;

        switch (language) {

            case "Зеленый":
                theme = Utils.THEME_GREEN;
                break;

            case "Синий":
                theme = Utils.THEME_BLUE;
                break;

        }

        Utils.changeToTheme(this, theme);

    }

    protected void applyMargin() {

        String margin = marginsSpinner.getSelectedItem().toString();

        int theme = Utils.THEME_MARGIN_1;

        switch (margin) {

            case "Средние":
                theme = Utils.THEME_MARGIN_3;
                break;

            case "Большие":
                theme = Utils.THEME_MARGIN_10;
                break;

        }

        Utils.changeToTheme(this, theme);

    }

    public void onApplyBtnClick(View view) {

        applyLanguage();
        applyMargin();
//        applyTheme(); // uncomment for colors change

    }

}
