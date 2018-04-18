package com.shrinvi.sma.core.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.property.UserProperty;
import com.shrinvi.sma.core.Defaults;
import com.shrinvi.sma.core.SMALogger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SMAHomeActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView label = new TextView(this);
        //persistAnObjectInTestTable();
        setContentView(label);
        //registerUser();
    }

}
                                    