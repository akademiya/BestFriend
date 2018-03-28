package com.example.user.bestfriends.settings;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.user.bestfriends.BaseActivity;
import com.example.user.bestfriends.R;

public class SettingsView extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_settings);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SettingsView.class);
        return intent;
    }
}
