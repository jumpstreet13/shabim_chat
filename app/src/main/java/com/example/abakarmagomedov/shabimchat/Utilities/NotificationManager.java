package com.example.abakarmagomedov.shabimchat.Utilities;


import android.app.Notification;
import android.app.NotificationChannel;
import android.content.Context;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.os.Build;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.example.abakarmagomedov.shabimchat.R;


/**
 * Created by Никита on 25.02.2018.
 */

public class NotificationManager {

    private  boolean soundOn;
    private  boolean vibrateOn;
    private  Context serviceContext;

    public NotificationManager(Context serviceContext) {
        this.serviceContext = serviceContext;
    }

    public void showNotify(int id, String title, String description) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(serviceContext.getApplicationContext())
                    .setSmallIcon(R.mipmap.ic_launcher_round)
                    .setContentTitle(title)
                    .setContentText(description);
//                    .setLights(1,3,4);
            if (vibrateOn) {
                notificationBuilder.setVibrate(new long[50]);
            }
            if (soundOn) {
                notificationBuilder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
            }

            android.app.NotificationManager notificationManager = (android.app.NotificationManager) serviceContext.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(id, notificationBuilder.build());
        } else {
//            Toast.makeText(serviceContext.getApplicationContext(), "Уведомления не работают :)", Toast.LENGTH_SHORT).show();
            AudioAttributes.Builder audioAttributesBuilder = new AudioAttributes.Builder();
            //audioAttributesBuilder.setContentType(AudioAttributes.CONTENT_TYPE_MUSIC);
            NotificationChannel notificationChannel = new NotificationChannel("1","Messages", android.app.NotificationManager.IMPORTANCE_LOW);
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long [50]);
            notificationChannel.setLightColor(Color.BLUE);
            notificationChannel.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, audioAttributesBuilder.build());

            Notification.Builder notificationBuilder = new Notification.Builder(serviceContext, "1");

            notificationBuilder.setContentTitle(title);
            notificationBuilder.setContentText(description);
            notificationBuilder.build();
        }


    }

    public void set_SoundNotify(boolean sound) {
        soundOn = sound;
    }

    public void set_VibrateNotify(boolean vibrate) {
        vibrateOn = vibrate;
    }

    public boolean get_SoundNotify() {
        return soundOn;
    }

    public boolean get_VibrateNotify() {
        return vibrateOn;
    }
}
