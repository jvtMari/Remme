package com.example.jose.remme.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jose.remme.R;
import com.example.jose.remme.Utils.AppPreferences;

public class MainActivity extends AppCompatActivity {

    AppPreferences appPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        appPreferences = new AppPreferences(getApplicationContext());

        //Check if the App has a login on.
        loginCheck();

    }

    private void loginCheck() {
        if (appPreferences.getLoginMode() == null ){
            appPreferences.setLoginMode("");
            startLoginActivity();
        }else if (!appPreferences.getLoginMode().isEmpty()){
       //   startMainTabsActivity();
            startLoginActivity();
        }else{
            startLoginActivity();
        }
    }

    private void startLoginActivity() {
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);
        finish();
    }

    private void startMainTabsActivity() {
        Intent i = new Intent(getApplicationContext(), MainTabsActivity.class);
        startActivity(i);
        finish();
    }
}
