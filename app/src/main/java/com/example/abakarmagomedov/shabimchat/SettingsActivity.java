package com.example.abakarmagomedov.shabimchat;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
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
//        final Uri sound_url = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//        final Notification notification = new Notification();
//        final NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        sound_sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (sound_sw.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Звуковые уведомления включены", Toast.LENGTH_SHORT).show();
                    com.example.abakarmagomedov.shabimchat.Utilities.NotificationManager.set_SoundNotify(true);
//                    Написать кокманду включения и отключения звука на устройстве
                } else {
                    Toast.makeText(getApplicationContext(), "Звуковые уведомления отключены", Toast.LENGTH_SHORT).show();
                    com.example.abakarmagomedov.shabimchat.Utilities.NotificationManager.set_SoundNotify(false);
                }
            }
        });
        vibro_sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (vibro_sw.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Вибрация включена", Toast.LENGTH_SHORT).show();
                    com.example.abakarmagomedov.shabimchat.Utilities.NotificationManager.set_VibrateNotify(true);
                    vibrator.vibrate(50);
                } else {
                    Toast.makeText(getApplicationContext(), "Вибрация отключена", Toast.LENGTH_SHORT).show();
                    com.example.abakarmagomedov.shabimchat.Utilities.NotificationManager.set_VibrateNotify(false);
                    vibrator.cancel();
                }
            }
        });

    }

    public void setAppVersion(String version) {
        appVersion_tv = findViewById(R.id.appVersion_tv);
        appVersion_tv.setText("Version: " + version);
    }
}
