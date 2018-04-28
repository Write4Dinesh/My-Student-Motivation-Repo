package com.shrinvi.sma.core;

import android.app.Application;

import com.backendless.Backendless;

public class SMAApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Backendless.setUrl(AppSettings.BASE_SERVER_URL);
        Backendless.initApp(getApplicationContext(), AppSettings.APPLICATION_ID, AppSettings.API_KEY);
    }
}
