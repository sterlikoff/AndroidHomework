package ru.s.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {

            case R.id.action_open_notes:

                Intent notepad = new Intent(MainActivity.this, NotepadActivity.class);
                startActivity(notepad);

                return true;

            case R.id.action_open_subscribe:

                Intent subscribe = new Intent(MainActivity.this, SubscribeActivity.class);
                startActivity(subscribe);

                return true;

            case R.id.action_open_checkboxes:

                Intent checkboxes = new Intent(MainActivity.this, CheckboxActivity.class);
                startActivity(checkboxes);

                return true;

            case R.id.action_open_spinners:

                Intent spinners = new Intent(MainActivity.this, SpinnersActivity.class);
                startActivity(spinners);

                return true;

            case R.id.action_open_datetime:

                Intent datetime = new Intent(MainActivity.this, DateTimeActivity.class);
                startActivity(datetime);

                return true;

            case R.id.action_open_calculator:

                Intent calculator = new Intent(MainActivity.this, CalculatorActivity.class);
                startActivity(calculator);

                return true;

            case R.id.action_open_locale:

                Intent locale = new Intent(MainActivity.this, LocaleActivity.class);
                startActivity(locale);

                return true;

            case R.id.action_open_list:

                Intent list = new Intent(MainActivity.this, ListActivity.class);
                startActivity(list);

                return true;

            case R.id.action_open_geo:

                Intent geo = new Intent(MainActivity.this, AddressActivity.class);
                startActivity(geo);

                return true;

            case R.id.action_open_phone:

                Intent phone = new Intent(MainActivity.this, PhoneActivity.class);
                startActivity(phone);

                return true;

        }

        return super.onOptionsItemSelected(item);
    }

}
