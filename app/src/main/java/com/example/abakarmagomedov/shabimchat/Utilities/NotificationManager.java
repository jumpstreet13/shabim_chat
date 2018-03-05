package com.example.abakarmagomedov.shabimchat.Utilities;


import android.app.NotificationChannel;
import android.content.Context;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;

import com.example.abakarmagomedov.shabimchat.R;

import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Method;


/**
 * Created by Никита on 25.02.2018.
 */

public class NotificationManager {

    private boolean soundOn;
    private boolean vibrateOn;
    private Context serviceContext;

    public NotificationManager(Context serviceContext) {
        this.serviceContext = serviceContext;
    }

    public void showNotify(int id, String title, String description) {
        setVariables();

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O)
            buildNofifyLowSDK(id, title, description);
        else
            buildNotifyHighSDK(id, title, description);
    }

    private void buildNofifyLowSDK(int id, String title, String description) {
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(serviceContext.getApplicationContext())
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle(title)
                .setContentText(description)
                .setLights(Color.BLUE, 500, 2000);
        if (vibrateOn) {
            notificationBuilder.setVibrate(new long[]{200, 200});
        }
        if (soundOn) {
            notificationBuilder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
        }

        android.app.NotificationManager notificationManager = (android.app.NotificationManager) serviceContext.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(id, notificationBuilder.build());
    }

    private void buildNotifyHighSDK(int id, String title, String description) {
        if (Build.VERSION.SDK_INT >= 26) {
            android.app.NotificationManager notificationManager = (android.app.NotificationManager) serviceContext.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(setChannelSettings());

            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(serviceContext, "1")
                    .setContentTitle(title)
                    .setContentText(description)
                    .setSmallIcon(R.mipmap.ic_launcher_round);

            notificationManager.notify(id, notificationBuilder.build());
        }
    }

    private void setVariables(){
        Bundle bundle = new Bundle();
//        if (bundle.get("soundOn") == null)
//            soundOn = false;
//        else soundOn = bundle.getBoolean("soundOn");
//
//        if (bundle.get("vibroOn") == null)
//            vibrateOn = true;
//        else vibrateOn = bundle.getBoolean("vibroOn");
    }

    @Nullable
    private NotificationChannel setChannelSettings() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel channel = new NotificationChannel("1", "Messages", android.app.NotificationManager.IMPORTANCE_DEFAULT);
            channel.enableLights(true);
            channel.setLightColor(Color.BLUE);
            if (vibrateOn) {
                channel.enableVibration(true);
                channel.setVibrationPattern(new long[]{200, 200});
            }
            if (soundOn) {
                AudioAttributes.Builder audioAttributesBuilder = new AudioAttributes.Builder();
                channel.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, audioAttributesBuilder.build());
            }
            return channel;
        }
        return null;
    }

    public void setSoundNotify(boolean sound) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("soundOn", sound);
    }

    public void setVibrateNotify(boolean vibrate) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("vibroOn", vibrate);
    }

    public boolean getSoundNotify() {
        return soundOn;
    }

    public boolean getVibrateNotify() {
        return vibrateOn;
    }
}
