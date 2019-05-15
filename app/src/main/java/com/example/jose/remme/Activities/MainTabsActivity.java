package com.example.jose.remme.Activities;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.jose.remme.Fragments.TodoTabFragment;
import com.example.jose.remme.R;
import com.example.jose.remme.Utils.AppPreferences;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//Statics
import static com.example.jose.remme.Utils.Finals.OFFLINE;
import static com.example.jose.remme.Utils.Finals.ONLINE;



public class MainTabsActivity extends AppCompatActivity {


    @BindView(R.id.tv_loginMode)
    TextView tvLoginMode;
    @BindView(R.id.ic_settings)
    ImageView icSettings;
    @Nullable
    @BindView(R.id.tab_todo)
    TabItem tabTodo;
    @Nullable
    @BindView(R.id.tab_calendar)
    TabItem tabCalendar;
    @Nullable
    @BindView(R.id.tab_chores)
    TabItem tabChores;
    @BindView(R.id.mainFrameLayout)
    FrameLayout mainFrameLayout;
    @BindView(R.id.main_tabLayout)
    TabLayout mainTabLayout;

    AppPreferences appPreferences;
    static Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tabs);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        appPreferences = new AppPreferences(getApplicationContext());

        //Check login mode.
        checkLoginMode();

        //Add Main tab layout listener.
        addMainTabLayoutListener();

    }

    private void addMainTabLayoutListener() {


        //Set default the Tab To Do (Fragment).
        currentFragment = TodoTabFragment.newInstance(appPreferences.getLoginMode());
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameLayout, currentFragment).commit();

        mainTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if(getSupportFragmentManager().getBackStackEntryCount() > 0){
                    getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                }

                switch(tab.getPosition()){

                    case 1:
                        currentFragment = TodoTabFragment.newInstance(appPreferences.getLoginMode());
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameLayout, currentFragment).commit();
                        break;

                    case 2:
                    //    currentFragment = TodoTabFragment.newInstance(appPreferences.getLoginMode());
                    //    getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameLayout, currentFragment).commit();

                        break;

                    case 3:
                   //     currentFragment = TodoTabFragment.newInstance(appPreferences.getLoginMode());
                   //     getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameLayout, currentFragment).commit();

                        break;

                    default:
                        break;
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    @OnClick(R.id.ic_settings)
    public void onViewClicked() {
    }



    private void checkLoginMode() {

        switch (appPreferences.getLoginMode()) {

            case OFFLINE:
                tvLoginMode.setText(R.string.offline);
                tvLoginMode.setTextColor(getColor(R.color.colorAccent));


                break;

            case ONLINE:
                tvLoginMode.setText(R.string.online);
                tvLoginMode.setTextColor(getColor(R.color.colorPrimary));



                break;

            default:
                break;

        }
    }




}
