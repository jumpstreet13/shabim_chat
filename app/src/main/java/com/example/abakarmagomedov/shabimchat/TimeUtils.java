package com.example.abakarmagomedov.shabimchat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by abakarmagomedov on 21/02/2018 at project ShabimChat.
 */

public class TimeUtils {

    public static String formatDateFromLong(long time) {
        Date date = new Date(time);
        SimpleDateFormat df2 = new SimpleDateFormat("hh:mm", Locale.getDefault());
        return df2.format(date);
    }
}
