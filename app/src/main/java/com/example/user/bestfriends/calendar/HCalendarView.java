package com.example.user.bestfriends.calendar;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.user.bestfriends.BaseActivity;
import com.example.user.bestfriends.R;
import com.example.user.bestfriends.settings.SettingsView;

public class HCalendarView extends BaseActivity {

    private DrawerLayout mDrawerLayout;
    private ImageView button_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_calendar);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        button_menu = findViewById(R.id.button_menu);
        button_menu.setOnClickListener(v -> mDrawerLayout.openDrawer(Gravity.START));
    }

    // TODO: app bar menu переход в activity по клику на item
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                startActivity(SettingsView.getStartIntent(this));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    // TODO: end app bar menu переход в activity по клику на item

    public static Intent getStartIntent(Context context) {
        return new Intent(context, HCalendarView.class);
    }

}