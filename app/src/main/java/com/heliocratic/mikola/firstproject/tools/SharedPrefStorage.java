package com.heliocratic.mikola.firstproject.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.heliocratic.mikola.firstproject.constants.SharedPrefConstants;

public class SharedPrefStorage {

    public static SharedPreferences getPrefs(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static int getKeyboardBackgroundColorPref(Context context) {
        return getPrefs(context).getInt(SharedPrefConstants.KEY_KEYBORD_BACKGROUND_COLOR,
                SharedPrefConstants.DEFAULT_KEYBORD_BACKGROUND_COLOR);
    }

    public static void setKeyboardBackgroundColorPref(Context context, int value) {
        getPrefs(context).edit().putInt(SharedPrefConstants.KEY_KEYBORD_BACKGROUND_COLOR, value).apply();
    }

    public static int getKeyboardBackgroundTransparencyPref(Context context) {
        return getPrefs(context).getInt(SharedPrefConstants.KEY_KEYBORD_BACKGROUND_TRANSPARENCY,
                SharedPrefConstants.DEFAULT_KEYBORD_BACKGROUND_TRANSPARENCY);
    }

    public static void setKeyboardBackgroundTransparencyPref(Context context, int value) {
        getPrefs(context).edit().putInt(SharedPrefConstants.KEY_KEYBORD_BACKGROUND_TRANSPARENCY, value).apply();
    }

    public static int getKeyboardSizeModePref(Context context) {
        return getPrefs(context).getInt(SharedPrefConstants.KEY_KEYBORD_SIZE_MODE,
                SharedPrefConstants.DEFAULT_KEYBORD_SIZE_MODE);
    }

    public static void setKeyboardSizeModePref(Context context, int value) {
        getPrefs(context).edit().putInt(SharedPrefConstants.KEY_KEYBORD_SIZE_MODE, value).apply();
    }

    public static int getKeyboardSizePref(Context context) {
        return getPrefs(context).getInt(SharedPrefConstants.KEY_KEYBORD_SIZE,
                SharedPrefConstants.DEFAULT_KEYBORD_SIZE);
    }

    public static void setKeyboardSizePref(Context context, int value) {
        getPrefs(context).edit().putInt(SharedPrefConstants.KEY_KEYBORD_SIZE, value).apply();
    }

    public static int getKeyboardFontSizePref(Context context) {
        return getPrefs(context).getInt(SharedPrefConstants.KEY_KEYBORD_FONT_SIZE,
                SharedPrefConstants.DEFAULT_KEYBORD_FONT_SIZE);
    }

    public static void setKeyboardFontSizePref(Context context, int value) {
        getPrefs(context).edit().putInt(SharedPrefConstants.KEY_KEYBORD_FONT_SIZE, value).apply();
    }

    public static int getKeyboardFontStylePref(Context context) {
        return getPrefs(context).getInt(SharedPrefConstants.KEY_KEYBORD_FONT_STYLE,
                SharedPrefConstants.DEFAULT_KEYBORD_FONT_STYLE);
    }

    public static void setKeyboardFontStylePref(Context context, int value) {
        getPrefs(context).edit().putInt(SharedPrefConstants.KEY_KEYBORD_FONT_STYLE, value).apply();
    }

    public static int getKeyboardKeyLabelsPref(Context context) {
        return getPrefs(context).getInt(SharedPrefConstants.KEY_KEYBORD_KEY_LABELS,
                SharedPrefConstants.DEFAULT_KEYBORD_KEY_LABELS);
    }

    public static void setKeyboardKeyLabelsPref(Context context, int value) {
        getPrefs(context).edit().putInt(SharedPrefConstants.KEY_KEYBORD_FONT_STYLE, value).apply();
    }


}
