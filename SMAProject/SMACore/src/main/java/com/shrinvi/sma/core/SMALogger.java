package com.shrinvi.sma.core;

import android.util.Log;

/**
 * Created by dinesh.k.masthaiah on 04/17/18.
 */

public class SMALogger {
    public static final String LOG_TAG = "SMALOG";

    public static void printLog(String module, String message) {
        Log.i(LOG_TAG, module + ":" + message);
    }

    public static void printLog(String message) {
        Log.i(LOG_TAG, message);
    }
}
