package com.shrinvi.sma.core.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.backendless.Backendless;
import com.shrinvi.sma.core.Defaults;
import com.shrinvi.sma.core.R;
import com.shrinvi.sma.core.model.UserSessionInfo;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SMASplashActivity extends SMABaseActivity {
    private static final long DELAY_IN_SPLASH_IN_MILLIS = 5 * 1000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        findViewById(R.id.fullscreen_content).setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
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
        Intent intent;
        if (UserSessionInfo.isUserSignedIn()) {
            intent = new Intent(this, SMAHomeActivity.class);
        } else {
            intent = new Intent(this, SMALandingActivity.class);
        }
        startActivity(intent);
        finish();
    }
}
