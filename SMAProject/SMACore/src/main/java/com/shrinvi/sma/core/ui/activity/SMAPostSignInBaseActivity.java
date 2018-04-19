package com.shrinvi.sma.core.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.shrinvi.sma.core.R;
import com.shrinvi.sma.core.model.UserSessionInfo;

public class SMAPostSignInBaseActivity extends SMABaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.signout) {
            Toast.makeText(this, "Try to signing out", Toast.LENGTH_LONG).show();
            Backendless.UserService.logout(new AsyncCallback<Void>() {
                @Override
                public void handleResponse(Void response) {
                    UserSessionInfo.onLogout();
                    Toast.makeText(SMAPostSignInBaseActivity.this, "Sign out successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SMAPostSignInBaseActivity.this, SMALandingActivity.class);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void handleFault(BackendlessFault fault) {
                    Toast.makeText(SMAPostSignInBaseActivity.this, "Error while signing out:" + fault.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
        return super.onOptionsItemSelected(item);
    }
}
                                    