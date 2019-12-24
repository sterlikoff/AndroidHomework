package ru.s.myapplication.utils;

import android.app.Activity;
import android.content.Intent;

import ru.s.myapplication.R;

public class Utils {

    private static int sTheme;

    public final static int THEME_DEFAULT = 0;
    public final static int THEME_GREEN = 1;
    public final static int THEME_BLUE = 2;

    public final static int THEME_MARGIN_1 = 3;
    public final static int THEME_MARGIN_3 = 4;
    public final static int THEME_MARGIN_10 = 5;

    public static void changeToTheme(Activity activity, int theme) {

        sTheme = theme;
        activity.finish();

        activity.startActivity(new Intent(activity, activity.getClass()));

    }

    public static void onActivityCreateSetTheme(Activity activity) {

        switch (sTheme) {
            default:

            case THEME_DEFAULT:
                activity.setTheme(R.style.BlackTheme);
                break;
            case THEME_GREEN:
                activity.setTheme(R.style.GreenTheme);
                break;
            case THEME_BLUE:
                activity.setTheme(R.style.BlueTheme);
                break;

            case THEME_MARGIN_1:
                activity.setTheme(R.style.Margin1);
                break;
            case THEME_MARGIN_3:
                activity.setTheme(R.style.Margin3);
                break;
            case THEME_MARGIN_10:
                activity.setTheme(R.style.Margin10);
                break;

        }

    }

}