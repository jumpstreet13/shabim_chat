package com.example.abakarmagomedov.shabimchat;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by abakarmagomedov on 18/02/2018 at project ShabimChat.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
