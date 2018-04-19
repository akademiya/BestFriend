package com.example.user.bestfriends.korean;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.widget.ImageView;

import com.example.user.bestfriends.BaseActivity;
import com.example.user.bestfriends.R;

public class KoreanView extends BaseActivity {

    private DrawerLayout mDrawerLayout;
    private ImageView button_menu;
    private FragmentPagerAdapter mPagerAdapter;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, KoreanView.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_korean_tabs);
        toolbar_button_menu();
        tabLayout_vs_viewPager();
    }

    private void toolbar_button_menu() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        button_menu = findViewById(R.id.button_menu);
        button_menu.setOnClickListener(v -> mDrawerLayout.openDrawer(Gravity.START));
    }

    private void tabLayout_vs_viewPager() {
        mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new KoreanHomeFragment();
                    case 1:
                        return new KoreanGrammarFragment();
                }
                return null;
            }

            @Override
            public int getCount() { return 2; }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return "Основа";
                    case 1:
                        return "Грамматика";
                }
                return null;
            }
        };


        final ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(mPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

}