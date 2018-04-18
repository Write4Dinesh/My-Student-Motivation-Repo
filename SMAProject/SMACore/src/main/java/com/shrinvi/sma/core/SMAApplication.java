package com.shrinvi.sma.core;

import android.app.Application;

import com.backendless.Backendless;

public class SMAApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Backendless.setUrl(Defaults.SERVER_URL);
        Backendless.initApp(getApplicationContext(), Defaults.APPLICATION_ID, Defaults.API_KEY);
    }
}
