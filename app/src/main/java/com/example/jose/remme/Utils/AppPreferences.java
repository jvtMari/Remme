package com.example.jose.remme.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPreferences {

    //References
    private static final String PREF_FILE = "MyPreferences";
    private static final String LOGIN_MODE = "login_mode";

    private Context context;

    public AppPreferences(Context context) {
        this.context = context;
    }

    public AppPreferences() {
    }

    private SharedPreferences getSharedPreferences() {
        return context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
    }

    //Login mode
    public String getLoginMode() {
        return getSharedPreferences().getString(LOGIN_MODE, null);
    }

    public void setLoginMode(String loginMode) {
        this.getSharedPreferences().edit().putString(LOGIN_MODE, loginMode).apply();
    }

}
