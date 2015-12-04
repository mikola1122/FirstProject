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
        return getPrefs(context).getInt(SharedPrefConstants.KEY_KEYBOARD_BACKGROUND_COLOR,
                SharedPrefConstants.DEFAULT_KEYBOARD_BACKGROUND_COLOR);
    }

    public static void setKeyboardBackgroundColorPref(Context context, int value) {
        getPrefs(context).edit().putInt(SharedPrefConstants.KEY_KEYBOARD_BACKGROUND_COLOR, value).apply();
    }

    public static int getKeyboardBackgroundColorPref1(Context context) {
        return getPrefs(context).getInt(SharedPrefConstants.KEY_KEYBOARD_BACKGROUND_COLOR_PROGRESS,
                SharedPrefConstants.DEFAULT_KEYBOARD_BACKGROUND_COLOR_PROGRESS);
    }

    public static void setKeyboardBackgroundColorPref1(Context context, int value) {
        getPrefs(context).edit().putInt(SharedPrefConstants.KEY_KEYBOARD_BACKGROUND_COLOR_PROGRESS, value).apply();
    }

    public static int getKeyboardBackgroundTransparencyPref(Context context) {
        return getPrefs(context).getInt(SharedPrefConstants.KEY_KEYBOARD_BACKGROUND_TRANSPARENCY,
                SharedPrefConstants.DEFAULT_KEYBOARD_BACKGROUND_TRANSPARENCY);
    }

    public static void setKeyboardBackgroundTransparencyPref(Context context, int value) {
        getPrefs(context).edit().putInt(SharedPrefConstants.KEY_KEYBOARD_BACKGROUND_TRANSPARENCY, value).apply();
    }

    public static int getKeyboardSizeModePref(Context context) {
        return getPrefs(context).getInt(SharedPrefConstants.KEY_KEYBOARD_SIZE_MODE,
                SharedPrefConstants.DEFAULT_KEYBOARD_SIZE_MODE);
    }

    public static void setKeyboardSizeModePref(Context context, int value) {
        getPrefs(context).edit().putInt(SharedPrefConstants.KEY_KEYBOARD_SIZE_MODE, value).apply();
    }

    public static int getKeyboardSizePref(Context context) {
        return getPrefs(context).getInt(SharedPrefConstants.KEY_KEYBOARD_SIZE,
                SharedPrefConstants.DEFAULT_KEYBOARD_SIZE);
    }

    public static void setKeyboardSizePref(Context context, int value) {
        getPrefs(context).edit().putInt(SharedPrefConstants.KEY_KEYBOARD_SIZE, value).apply();
    }

    public static int getKeyboardFontSizePref(Context context) {
        return getPrefs(context).getInt(SharedPrefConstants.KEY_KEYBOARD_FONT_SIZE,
                SharedPrefConstants.DEFAULT_KEYBOARD_FONT_SIZE);
    }

    public static void setKeyboardFontSizePref(Context context, int value) {
        getPrefs(context).edit().putInt(SharedPrefConstants.KEY_KEYBOARD_FONT_SIZE, value).apply();
    }

    public static int getKeyboardFontStylePref(Context context) {
        return getPrefs(context).getInt(SharedPrefConstants.KEY_KEYBOARD_FONT_STYLE,
                SharedPrefConstants.DEFAULT_KEYBOARD_FONT_STYLE);
    }

    public static void setKeyboardFontStylePref(Context context, int value) {
        getPrefs(context).edit().putInt(SharedPrefConstants.KEY_KEYBOARD_FONT_STYLE, value).apply();
    }

    public static int getKeyboardKeyLabelsPref(Context context) {
        return getPrefs(context).getInt(SharedPrefConstants.KEY_KEYBOARD_KEY_LABELS,
                SharedPrefConstants.DEFAULT_KEYBOARD_KEY_LABELS);
    }

    public static void setKeyboardKeyLabelsPref(Context context, int value) {
        getPrefs(context).edit().putInt(SharedPrefConstants.KEY_KEYBOARD_KEY_LABELS, value).apply();
    }

    public static int getKeyboardVibroPref(Context context) {
        return getPrefs(context).getInt(SharedPrefConstants.KEY_KEYBOARD_VIBRO,
                SharedPrefConstants.DEFAULT_KEYBOARD_VIBRO);
    }

    public static void setKeyboardVibroPref(Context context, int value) {
        getPrefs(context).edit().putInt(SharedPrefConstants.KEY_KEYBOARD_VIBRO, value).apply();
    }

    public static int getKeyboardTextSpeechPref(Context context) {
        return getPrefs(context).getInt(SharedPrefConstants.KEY_KEYBOARD_TEXT_SPEECH,
                SharedPrefConstants.DEFAULT_KEYBOARD_TEXT_SPEECH);
    }

    public static void setKeyboardTextSpeechPref(Context context, int value) {
        getPrefs(context).edit().putInt(SharedPrefConstants.KEY_KEYBOARD_TEXT_SPEECH, value).apply();
    }

        public static int getKeyboardKeySoundPref(Context context) {
        return getPrefs(context).getInt(SharedPrefConstants.KEY_KEYBOARD_KEY_SOUND,
                SharedPrefConstants.DEFAULT_KEYBOARD_KEY_SOUND);
    }

    public static void setKeyboardKeySoundPref(Context context, int value) {
        getPrefs(context).edit().putInt(SharedPrefConstants.KEY_KEYBOARD_KEY_SOUND, value).apply();
    }

        public static int getKeyboardSpellCheckingPref(Context context) {
        return getPrefs(context).getInt(SharedPrefConstants.KEY_KEYBOARD_SPELL_CHECKING,
                SharedPrefConstants.DEFAULT_KEYBOARD_SPELL_CHECKING);
    }

    public static void setKeyboardSpellCheckingPref(Context context, int value) {
        getPrefs(context).edit().putInt(SharedPrefConstants.KEY_KEYBOARD_SPELL_CHECKING, value).apply();
    }

        public static int getKeyboardEnableHotkeysPref(Context context) {
        return getPrefs(context).getInt(SharedPrefConstants.KEY_KEYBOARD_ENABLE_HOTKEYS,
                SharedPrefConstants.DEFAULT_KEYBOARD_ENABLE_HOTKEYS);
    }

    public static void setKeyboardEnableHotkeysPref(Context context, int value) {
        getPrefs(context).edit().putInt(SharedPrefConstants.KEY_KEYBOARD_ENABLE_HOTKEYS, value).apply();
    }

        public static int getKeyboardEnableStatisticPref(Context context) {
        return getPrefs(context).getInt(SharedPrefConstants.KEY_KEYBOARD_ENABLE_STATISTIC,
                SharedPrefConstants.DEFAULT_KEYBOARD_ENABLE_STATISTIC);
    }

    public static void setKeyboardEnableStatisticPref(Context context, int value) {
        getPrefs(context).edit().putInt(SharedPrefConstants.KEY_KEYBOARD_ENABLE_STATISTIC, value).apply();
    }



}
