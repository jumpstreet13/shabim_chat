package com.example.abakarmagomedov.shabimchat.managers;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by abakarmagomedov on 05/03/2018 at project ShabimChat.
 */

public class SharedPrefManager {

    private final static String VIBRATE_SETTING = "vibrate_setting";
    private final static String SOUND_SETTING = "sound_setting";
    private final static String IS_FIRST_RUN = "is_first_run";
    private SharedPreferences sharedPreference;

    public SharedPrefManager(Context context) {
        sharedPreference = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void writeVibrateSetting(boolean isVibrate) {
        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putBoolean(VIBRATE_SETTING, isVibrate);
        editor.apply();
    }

    public void writeSoundSetting(boolean isSound) {
        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putBoolean(SOUND_SETTING, isSound);
        editor.apply();
    }

    public void writeFirstRun() {
        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putBoolean(IS_FIRST_RUN, false);
        editor.apply();
    }

    public boolean isFirstRun() {
        return sharedPreference.getBoolean(IS_FIRST_RUN, true);
    }

    public boolean readVibrateSetting() {
        return sharedPreference.getBoolean(VIBRATE_SETTING, false);
    }

    public boolean readSoundSetting() {
        return sharedPreference.getBoolean(SOUND_SETTING, true);
    }
}
