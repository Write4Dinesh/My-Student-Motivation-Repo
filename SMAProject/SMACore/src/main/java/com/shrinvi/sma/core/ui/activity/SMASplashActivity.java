package com.shrinvi.sma.core.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.shrinvi.sma.core.R;

public class SMASplashActivity extends SMABaseActivity {
    private static final long DELAY_IN_SPLASH_IN_MILLIS = 5 * 1000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                goToNextScreen();
            }
        }, DELAY_IN_SPLASH_IN_MILLIS);
    }

    private void goToNextScreen() {
        //TODO: check if the user has already logged in, if yes, take them directly to home else landing page
        Intent intent = new Intent(this, SMALandingActivity.class);
        startActivity(intent);
        finish();
    }
}
                                    