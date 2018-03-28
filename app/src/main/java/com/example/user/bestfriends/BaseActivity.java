package com.example.user.bestfriends;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.example.user.bestfriends.books.BooksView;
import com.example.user.bestfriends.calendar.HCalendarView;
import com.example.user.bestfriends.contacts.ContactsView;
import com.example.user.bestfriends.list_kido.ListKidoView;
import com.example.user.bestfriends.settings.SettingsView;
import com.example.user.bestfriends.video.VideoView;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public void setContentView(int layoutResID) {
        final DrawerLayout fullView = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_main, null);
        FrameLayout activityContainer = fullView.findViewById(R.id.activity_content);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);
        super.setContentView(fullView);
        final NavigationView navigationView = fullView.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {

                case R.id.nav_main:
                    startActivity(MainActivity.getStartIntent(this));
                    fullView.closeDrawers();
                    return true;

                case R.id.nav_books:
                    startActivity(BooksView.getStartIntent(this));
                    fullView.closeDrawers();
                    return true;

//                case R.id.nav_note:
//                    startActivity(NotesView.getStartIntent(this));
//                    fullView.closeDrawers();
//                    return true;

                case R.id.nav_calendar:
                    startActivity(HCalendarView.getStartIntent(this));
                    fullView.closeDrawers();
                    return true;

                case R.id.nav_kido:
                    startActivity(ListKidoView.getStartIntent(this));
                    fullView.closeDrawers();
                    return true;

                case R.id.nav_video:
                    startActivity(VideoView.getStartIntent(this));
                    fullView.closeDrawers();
                    return true;

                case R.id.nav_contact:
                    startActivity(ContactsView.getStartIntent(this));
                    fullView.closeDrawers();
                    return true;

                case R.id.nav_settings:
                    startActivity(SettingsView.getStartIntent(this));
                    fullView.closeDrawers();
                    return true;

                default:
                    return false;
            }
        });
    }

}