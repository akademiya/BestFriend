package com.example.user.bestfriends.settings;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.user.bestfriends.BaseActivity;
import com.example.user.bestfriends.R;

public class SettingsView extends BaseActivity {
    private Switch hide_list_kido;
    private Switch hide_korean;
    private Switch hide_video;
    private Switch hide_contacts;
    private Switch onBirthday;
    private Switch onCalendar;
    private Button save_settings;
    private Menu video;

    SharedPreferences state;

    private Boolean kido = true;

    DrawerLayout mDrawerLayout;
    ImageView button_menu;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, SettingsView.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_settings);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
        loadChange();

        save_settings.setOnClickListener(v -> {
            switch (v.getId()) {
                case R.id.save_settings:
                    saveChecked();
                    break;
                default:
                    break;
            }
        });

        button_menu.setOnClickListener(v -> {
            final DrawerLayout fullView = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_main, null);
            mDrawerLayout.openDrawer(fullView, true);
        });

    }

    private void saveChecked() {
        state = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = state.edit();
        editor.putBoolean("hide_kido", hide_list_kido.isChecked()); // TODO: реализовать правильное значение Boolean
        editor.putBoolean("hide_korean", hide_korean.isChecked());
        editor.putBoolean("hide_video", hide_video.isChecked());
        editor.putBoolean("hide_contacts", hide_contacts.isChecked());
        editor.putBoolean("onBirthday", onBirthday.isChecked());
        editor.putBoolean("onCalendar", onCalendar.isChecked());
        editor.commit();
        Toast.makeText(this, R.string.data_saved, Toast.LENGTH_SHORT).show();
    }

    private void loadChange() {
        state = getPreferences(MODE_PRIVATE);
        Boolean savedKido = state.getBoolean("hide_kido", hide_list_kido.isChecked()); // TODO: реализовать правильное значение Boolean
        hide_list_kido.setChecked(savedKido);

        Boolean saveKorean = state.getBoolean("hide_korean", hide_korean.isChecked());
        hide_korean.setChecked(saveKorean);

        Boolean saveVideo = state.getBoolean("hide_video", hide_video.isChecked());
        hide_video.setChecked(saveVideo);

        Boolean saveContacts = state.getBoolean("hide_contacts", hide_contacts.isChecked());
        hide_contacts.setChecked(saveContacts);

        Boolean saveBirthday = state.getBoolean("onBirthday", onBirthday.isChecked());
        onBirthday.setChecked(saveBirthday);

        Boolean saveCalendar = state.getBoolean("onCalendar", onCalendar.isChecked());
        onCalendar.setChecked(saveCalendar);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveChecked();
    }

    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//
//        return true;
//    }

    private void init() {
        hide_list_kido = findViewById(R.id.hide_list_kido);
        hide_korean = findViewById(R.id.hide_korean);
        hide_video = findViewById(R.id.hide_video);
        hide_contacts = findViewById(R.id.hide_contacts);
        onBirthday = findViewById(R.id.notification_birthday);
        onCalendar = findViewById(R.id.notification_calendar);
        save_settings = findViewById(R.id.save_settings);
        button_menu = findViewById(R.id.button_menu);

        video = findViewById(R.id.nav_video);
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
