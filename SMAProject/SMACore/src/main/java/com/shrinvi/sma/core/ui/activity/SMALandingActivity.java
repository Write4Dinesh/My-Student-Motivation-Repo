package com.shrinvi.sma.core.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.shrinvi.sma.core.R;

public class SMALandingActivity extends SMABaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        Button signUp = findViewById(R.id.sign_up_button);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSignUpScreen();
            }
        });
        Button signIn = findViewById(R.id.sign_in_button);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSignInScreen();
            }
        });
    }

    private void goToSignUpScreen() {
        Intent intent = new Intent(this, SMASignUpActivity.class);
        startActivity(intent);
    }

    private void goToSignInScreen() {
        Intent intent = new Intent(this, SMASignInActivity.class);
        startActivity(intent);
    }
}
                                    