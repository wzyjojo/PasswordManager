package com.wzy.passwordmanager.utils;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.wzy.passwordmanager.R;

/**
 * Created by lgp on 2015/6/7.
 */
public class ThemeUtils {

    public static void changeTheme(Activity activity, Theme theme){
        if (activity == null)
            return;
        int style = R.style.AppTheme_Red;
        switch (theme){
            case BROWN:
                style = R.style.AppTheme_Brown;
                break;
            case BLUE:
                style = R.style.AppTheme_Blue;
                break;
            case BLUE_GREY:
                style = R.style.AppTheme_BlueGrey;
                break;
            case YELLOW:
                style = R.style.AppTheme_Yellow;
                break;
            case DEEP_PURPLE:
                style = R.style.AppTheme_DeepPurple;
                break;
            case PINK:
                style = R.style.AppTheme_Pink;
                break;
            case GREEN:
                style = R.style.AppTheme_Green;
                break;
            default:
                break;
        }
        activity.setTheme(style);
    }

    public static Theme getCurrentTheme(Context context){
        int value = (int) SPUtils.get(context, context.getResources().getString(R.string.change_theme_key), 6);
        Log.i(context.getClass().getName(),"value"+value);
        return Theme.mapValueToTheme(value);
    }

    public enum Theme{
        RED(0x00),
        BROWN(0x01),
        BLUE(0x02),
        BLUE_GREY(0x03),
        YELLOW(0x04),
        DEEP_PURPLE(0x05),
        PINK(0x06),
        GREEN(0x07);

        private int mValue;

        Theme(int value){
            this.mValue = value;
        }

        public static Theme mapValueToTheme(final int value) {
            for (Theme theme : Theme.values()) {
                if (value == theme.getIntValue()) {
                    return theme;
                }
            }
            // If run here, return default
            return RED;
        }

        static Theme getDefault()
        {
            return RED;
        }
        public int getIntValue() {
            return mValue;
        }
    }
}
