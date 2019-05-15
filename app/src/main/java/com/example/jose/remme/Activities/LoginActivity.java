package com.example.jose.remme.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.jose.remme.R;
import com.example.jose.remme.Utils.AppPreferences;
import com.example.jose.remme.Utils.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.jose.remme.Utils.Finals.OFFLINE;
import static com.example.jose.remme.Utils.Finals.ONLINE;


public class LoginActivity extends AppCompatActivity {


    @BindView(R.id.btn_offline)
    TextView btnOffline;
    @BindView(R.id.btn_offline_info)
    ImageView btnOfflineInfo;
    @BindView(R.id.btn_online)
    TextView btnOnline;
    @BindView(R.id.btn_online_info)
    ImageView btnOnlineInfo;
    AppPreferences appPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        appPreferences = new AppPreferences(getApplicationContext());


    }

    @OnClick({R.id.btn_offline, R.id.btn_offline_info, R.id.btn_online, R.id.btn_online_info})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_offline:
                startMainTabsActivity(OFFLINE);
                break;
            case R.id.btn_offline_info:
                showAlertDialog(getString(R.string.dialog_title_offline), getString(R.string.dialog_message_offline));
                break;
            case R.id.btn_online:
                startMainTabsActivity(ONLINE);
                Toast.makeText(getApplicationContext(), "Not available at this moment, This mode is on develop.", Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_online_info:
                showAlertDialog(getString(R.string.dialog_title_online), getString(R.string.dialog_message_online));
                break;
        }
    }


    private void showAlertDialog(String title, String message) {
        Dialog dialog = Utils.generateScrollTextDialog(new Dialog(this), 1000, 700, title, message);
        dialog.show();
    }

    private void startMainTabsActivity(String mode) {
        Intent intent = new Intent(getApplicationContext(), MainTabsActivity.class);
        appPreferences.setLoginMode(mode);
        startActivity(intent);
    }

}
