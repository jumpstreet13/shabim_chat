package com.example.abakarmagomedov.shabimchat;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Никита on 23.02.2018.
 */

public class SettingsActivity extends AppCompatActivity {
    private Switch sound_sw, vibro_sw;
    private TextView appVersion_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        sound_sw = findViewById(R.id.sound_sw);
        vibro_sw = findViewById(R.id.vibro_sw);
        final Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        com.example.abakarmagomedov.shabimchat.managers.NotificationManager notificationManager = new com.example.abakarmagomedov.shabimchat.managers.NotificationManager(getApplication());

        sound_sw.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (sound_sw.isChecked()) {
                Toast.makeText(getApplicationContext(), R.string.sound_notify_on, Toast.LENGTH_SHORT).show();
                notificationManager.setSoundNotify(true);
            } else {
                Toast.makeText(getApplicationContext(), R.string.sound_notify_off, Toast.LENGTH_SHORT).show();
                notificationManager.setSoundNotify(false);
            }
        });
        vibro_sw.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (vibro_sw.isChecked()) {
                Toast.makeText(getApplicationContext(), R.string.vibro_notify_on, Toast.LENGTH_SHORT).show();
                notificationManager.setVibrateNotify(true);
                vibrator.vibrate(100);
            } else {
                Toast.makeText(getApplicationContext(), R.string.vibro_notify_off, Toast.LENGTH_SHORT).show();
                notificationManager.setVibrateNotify(false);
                vibrator.cancel();
            }
        });

    }

    public void setAppVersion(String version) {
        appVersion_tv = findViewById(R.id.appVersion_tv);
        appVersion_tv.setText("Version: " + version);
    }
}
