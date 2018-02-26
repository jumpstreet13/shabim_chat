package com.example.abakarmagomedov.shabimchat.Utilities;


import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.example.abakarmagomedov.shabimchat.R;


/**
 * Created by Никита on 25.02.2018.
 */

public class NotificationManager {

    private boolean soundOn;
    private Context serviceContext;

    public NotificationManager(Context serviceContext) {
        this.serviceContext = serviceContext;
    }

    public void showNotify(int id, String title, String description) {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.O) {
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(serviceContext.getApplicationContext())
                    .setSmallIcon(R.mipmap.ic_launcher_round)
                    .setContentTitle(title)
                    .setContentText(description);
            if (soundOn) {
                notificationBuilder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
            }

            android.app.NotificationManager notificationManager = (android.app.NotificationManager) serviceContext.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(id, notificationBuilder.build());
        } else
            Toast.makeText(serviceContext.getApplicationContext(), "Уведомления не работают :)", Toast.LENGTH_SHORT).show();

    }

    public void soundNotify(boolean soundOn) {
        this.soundOn = soundOn;
    }
}
