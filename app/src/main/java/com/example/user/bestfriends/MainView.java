package com.example.user.bestfriends;


import android.support.v7.app.AppCompatActivity;

import com.example.user.bestfriends.books.BooksView;
import com.example.user.bestfriends.calendar.HCalendarView;
import com.example.user.bestfriends.settings.SettingsView;

public class MainView extends AppCompatActivity implements MainPresenter{
    @Override
    public void onCalendarDrawerClick() {
        startActivity(HCalendarView.getStartIntent(this));
    }

    @Override
    public void onBooksDrawerClick() {
        startActivity(SettingsView.getStartIntent(this));
    }

    @Override
    public void onNotesDrawerClick() {

    }
}
