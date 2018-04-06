package com.example.user.bestfriends.korean;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import static com.example.user.bestfriends.korean.TabFragment.int_items;

public class KoreanAdapter extends FragmentPagerAdapter {

    public KoreanAdapter(FragmentManager fm) {
        super(fm);
    }

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
    public int getCount() {
        return int_items;
    }

    @Nullable
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
}
