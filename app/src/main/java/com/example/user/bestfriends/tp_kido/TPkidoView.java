package com.example.user.bestfriends.tp_kido;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.widget.ImageView;

import com.example.user.bestfriends.BaseActivity;
import com.example.user.bestfriends.R;

public class TPkidoView extends BaseActivity {

    private DrawerLayout mDrawerLayout;
    private ImageView button_menu;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, TPkidoView.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_list_tp_kido);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        button_menu = findViewById(R.id.button_menu);
        button_menu.setOnClickListener(v -> mDrawerLayout.openDrawer(Gravity.START));
    }
}