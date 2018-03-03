package com.example.abakarmagomedov.shabimchat.Utilities;



import android.app.NotificationChannel;
import android.content.Context;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;

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
                    .setContentText(description)
                    .setLights(Color.BLUE,500,2000);
            if (vibrateOn) {
                notificationBuilder.setVibrate(new long[]{200,200});
            }
            if (soundOn) {
                notificationBuilder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
            }

            android.app.NotificationManager notificationManager = (android.app.NotificationManager) serviceContext.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(id, notificationBuilder.build());
        } else {
            NotificationChannel channel = new NotificationChannel("1","Messages", android.app.NotificationManager.IMPORTANCE_DEFAULT);
            channel.enableLights(true);
            channel.setLightColor(Color.BLUE);
            if(vibrateOn){
                channel.enableVibration(true);
                channel.setVibrationPattern(new long[]{200,200});
            }
            if (soundOn) {
                AudioAttributes.Builder audioAttributesBuilder = new AudioAttributes.Builder();
                channel.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, audioAttributesBuilder.build());
            }

            android.app.NotificationManager notificationManager = (android.app.NotificationManager) serviceContext.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);

            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(serviceContext, "1")
                    .setContentTitle(title)
                    .setContentText(description)
                    .setSmallIcon(R.mipmap.ic_launcher_round);

            notificationManager.notify(id,notificationBuilder.build());
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
