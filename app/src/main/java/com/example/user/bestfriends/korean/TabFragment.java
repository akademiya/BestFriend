package com.example.user.bestfriends.korean;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.user.bestfriends.R;

public class TabFragment extends android.support.v4.app.Fragment {

    private DrawerLayout mDrawerLayout;
    private ImageView button_menu;
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 2;

    public TabFragment() { }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_korean_tabs, null);
        tabLayout = view.findViewById(R.id.tabs);
        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(new KoreanAdapter(getChildFragmentManager()));
        tabLayout.post(() -> tabLayout.setupWithViewPager(viewPager));
        return view;
    }

//    @SuppressLint("Registered")
//    class OpenDrawer extends BaseActivity {
//        private void toolbar_button_menu() {
//            Toolbar toolbar = findViewById(R.id.toolbar);
//            setSupportActionBar(toolbar);
//            getSupportActionBar().setHomeButtonEnabled(true);
//            mDrawerLayout = findViewById(R.id.drawer_layout);
//            button_menu = findViewById(R.id.button_menu);
//            button_menu.setOnClickListener(v -> mDrawerLayout.openDrawer(Gravity.START));
//        }
//    }

}