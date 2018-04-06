package com.example.user.bestfriends.settings;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

import com.example.user.bestfriends.BaseActivity;
import com.example.user.bestfriends.R;

public class SettingsView extends BaseActivity {
    private Switch notification_new_video;
    private Switch notification_birthday;
    private Switch notification_calendar;
    private SharedPreferences mSet;
    public static final String NAME_PREFERENCES = "mysetting";
    public static final String BOOL_CHECKBOX = "checkboxset";
    DrawerLayout mDrawerLayout;
    ImageView button_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_settings);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();

        if (mSet.contains(BOOL_CHECKBOX)) {
            notification_new_video.setChecked(mSet.getBoolean(BOOL_CHECKBOX, false));
        }
        if (mSet.contains(BOOL_CHECKBOX)) {
            notification_birthday.setChecked(mSet.getBoolean(BOOL_CHECKBOX, false));
        }
        if (mSet.contains(BOOL_CHECKBOX)) {
            notification_calendar.setChecked(mSet.getBoolean(BOOL_CHECKBOX, false));
        }

        button_menu.setOnClickListener(v -> {
            final DrawerLayout fullView = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_main, null);
            mDrawerLayout.openDrawer(fullView, true);
        });

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//
//        return true;
//    }

    public static Intent getStartIntent(Context context) {
        return new Intent(context, SettingsView.class);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mSet = getSharedPreferences(NAME_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mSet.edit();
        editor.putBoolean(BOOL_CHECKBOX, notification_new_video.isChecked());
        editor.putBoolean(BOOL_CHECKBOX, notification_birthday.isChecked());
        editor.putBoolean(BOOL_CHECKBOX, notification_calendar.isChecked()); //Чекбокс сохранение значения при выходе из приложения-/-активности
        editor.apply();
    }

    @Override
    public void onAttachedToWindow() {

    }

    private void init() {
        mSet = getSharedPreferences(NAME_PREFERENCES, Context.MODE_PRIVATE);

        notification_new_video = findViewById(R.id.notification_new_video);
        notification_birthday = findViewById(R.id.notification_birthday);
        notification_calendar = findViewById(R.id.notification_calendar);
        button_menu = findViewById(R.id.button_menu);
    }

    //        switch_push.setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked) -> {
//            if (switch_push.isChecked()) {
//                NotificationReceiver.scheduleRepeatingRTCNotification(mContext);
//                NotificationReceiver.enableBootReceiver(mContext);
//            } else if (!switch_push.isChecked()) {
//                NotificationReceiver.cancelAlarmRTC();
//                NotificationReceiver.disableBootReceiver(mContext);
//            }
//
//        });

}
