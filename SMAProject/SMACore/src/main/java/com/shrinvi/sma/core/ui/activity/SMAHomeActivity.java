package com.shrinvi.sma.core.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.shrinvi.sma.core.R;
import com.shrinvi.sma.core.model.UserSessionInfo;

public class SMAHomeActivity extends SMAPostSignInBaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TextView welcomeTv = findViewById(R.id.welcome_tv);
        String welcome = getString(R.string.welcome_user) + UserSessionInfo.getUserName();
        welcomeTv.setText(welcome);
    }

}
                                    