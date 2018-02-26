package com.example.abakarmagomedov.shabimchat.Utilities;


import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import com.example.abakarmagomedov.shabimchat.R;

import java.net.URI;

/**
 * Created by Никита on 25.02.2018.
 */

public class NotificationManager {

    private boolean soundOn;
    private Context serviceContext;

    public NotificationManager(Context serviceContext) {this.serviceContext = serviceContext;
    }

    public void showNotify(int id, String title, String description) {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.O) {
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(serviceContext.getApplicationContext())
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle(title)
                .setContentText(description);

        android.app.NotificationManager notificationManager = (android.app.NotificationManager) serviceContext.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(id, notificationBuilder.build());
    }

    }

    public void soundNotify(boolean soundOn) {
        this.soundOn = soundOn;
    }
}
