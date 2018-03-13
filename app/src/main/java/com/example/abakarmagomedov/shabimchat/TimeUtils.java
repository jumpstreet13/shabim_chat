package com.example.abakarmagomedov.shabimchat;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import wseemann.media.FFmpegMediaMetadataRetriever;

/**
 * Created by abakarmagomedov on 21/02/2018 at project ShabimChat.
 */

public class TimeUtils {

    public static String formatDateFromLong(long time) {
        Date date = new Date(time);
        SimpleDateFormat df2 = new SimpleDateFormat("hh:mm", Locale.getDefault());
        return df2.format(date);
    }

    public static String formatMillisToSeconds(int millis) {
        Date date = new Date(millis);
        SimpleDateFormat df2 = new SimpleDateFormat("mm:ss", Locale.getDefault());
        return df2.format(date);
    }

    public static int getMillisFromAudio(Context context, String pathStr) throws IOException {
        MediaPlayer mp = new MediaPlayer();
        mp.setDataSource(pathStr);
        mp.prepare();
        return mp.getDuration();
    }
}
