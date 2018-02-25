package com.example.abakarmagomedov.shabimchat.Utilities;

import android.app.Notification;
import android.content.ContentProvider;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;

import com.example.abakarmagomedov.shabimchat.R;

/**
 * Created by Никита on 25.02.2018.
 */

public class NotificationManager {

    private boolean sound;
    private Context service_context;

    public NotificationManager(Context service_context) {
        service_context.this = service_context;
    }

    public void showNotify(String title, String description) {

        android.app.NotificationManager notificationManager = (android.app.NotificationManager) service_context.getSystemService(Context.NOTIFICATION_SERVICE);

                Notification.Builder notificationBuilder = new Notification.Builder(service_context)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle(title)
                .setContentText(description);

        notificationManager.notify(1, notificationBuilder.build());

    }

    public void soundOnOff(boolean sound) {
        this.sound = sound;
    }
}
