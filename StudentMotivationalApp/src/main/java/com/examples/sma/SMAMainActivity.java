package com.examples.sma;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.util.Log;
import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.property.UserProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SMAMainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Backendless.setUrl( Defaults.SERVER_URL );
        Backendless.initApp( getApplicationContext(), Defaults.APPLICATION_ID, Defaults.API_KEY );

        HashMap testObject = new HashMap<>();
        testObject.put( "foo", "bar" );
        Backendless.Data.of( "TestTable" ).save(testObject, new AsyncCallback<Map>() {
          @Override
          public void handleResponse(Map response) {
            TextView label = new TextView(SMAMainActivity.this);
            label.setText("Object is saved in Backendless. Please check in the console.");
            setContentView(label);
          }

          @Override
          public void handleFault(BackendlessFault fault) {
            Log.e( "MYAPP", "Server reported an error " + fault.getMessage() );
          }
        });

        TextView label = new TextView(this);
        label.setText("Hello world!");
// do not forget to call Backendless.initApp when your app initializes
        Backendless.UserService.describeUserClass( new AsyncCallback<List<UserProperty>>()
        {
            public void handleResponse( List<UserProperty> properties )
            {
                for( UserProperty userProp : properties )
                {
                    Log.i( "MYAPP", "Property name - " + userProp.getName());
                    Log.i( "MYAPP", "\trequired - " + userProp.isRequired());
                    Log.i( "MYAPP", "\tidentity - " + userProp.isIdentity());
                    Log.i( "MYAPP", "\tdata type - " + userProp.getType());
                }
            }

            public void handleFault( BackendlessFault fault )
            {
            }
        });
        setContentView(label);
        registerUser();
    }
    private void registerUser(){
        // do not forget to call Backendless.initApp when your app initializes

        BackendlessUser user = new BackendlessUser();
        user.setProperty( "email", "dinesh042@gmail.com" );
        user.setPassword( "abcd1234" );
        user.setProperty("name", "abcd1234" );

        Backendless.UserService.register( user, new AsyncCallback<BackendlessUser>()
        {
            public void handleResponse( BackendlessUser registeredUser )
            {
                Log.i( "MYAPP", "Registration successful");
            }

            public void handleFault( BackendlessFault fault )
            {
                Log.i( "MYAPP", "Registration error:" + fault.getMessage());
            }
        } );
    }
}
                                    