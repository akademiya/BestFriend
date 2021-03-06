package com.example.user.bestfriends;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.example.user.bestfriends.birthday.BirthdayView;
import com.example.user.bestfriends.books.BooksView;
import com.example.user.bestfriends.calendar.HCalendarView;
import com.example.user.bestfriends.exercises.ExercisesView;
import com.example.user.bestfriends.korean.KoreanView;
import com.example.user.bestfriends.list_kido.PersonView;
import com.example.user.bestfriends.mense.MenseView;
import com.example.user.bestfriends.settings.SettingsView;
import com.example.user.bestfriends.tp_kido.TPkidoView;
import com.example.user.bestfriends.tp_photo.TPphotoView;
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

                case R.id.nav_tp_photo:
                    startActivity(TPphotoView.getStartIntent(this));
                    fullView.closeDrawers();
                    return true;

                case R.id.nav_mense:
                    startActivity(MenseView.getStartIntent(this));
                    fullView.closeDrawers();
                    return true;

                case R.id.nav_books:
                    startActivity(BooksView.getStartIntent(this));
                    fullView.closeDrawers();
                    return true;

                case R.id.nav_tp_kido:
                    startActivity(TPkidoView.getStartIntent(this));
                    fullView.closeDrawers();
                    return true;

                case R.id.nav_calendar:
                    startActivity(HCalendarView.getStartIntent(this));
                    fullView.closeDrawers();
                    return true;

                case R.id.nav_kido:
                    startActivity(PersonView.getStartIntent(this));
                    fullView.closeDrawers();
                    return true;

                case R.id.nav_korean:
                    startActivity(KoreanView.getStartIntent(this));

                    fullView.closeDrawers();
                    return true;

                case R.id.nav_exercises:
                    startActivity(ExercisesView.getStartIntent(this));
                    fullView.closeDrawers();
                    return true;

                case R.id.nav_video:
                    startActivity(VideoView.getStartIntent(this));
                    fullView.closeDrawers();
                    return true;

                case R.id.nav_contact:
                    Intent intent = new Intent(Intent.ACTION_DEFAULT, ContactsContract.Contacts.CONTENT_URI);
                    startActivityForResult(intent, 1);
                    fullView.closeDrawers();
                    return true;

                case R.id.nav_birthday:
                    startActivity(BirthdayView.getStartIntent(this));
                    fullView.closeDrawers();
                    return true;

                case R.id.nav_settings:
                    startActivity(SettingsView.getStartIntent(this));
                    fullView.closeDrawers();
                    return true;

                case R.id.nav_send:
                    startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:")));
                    fullView.closeDrawers();
                    return true;

                case R.id.nav_share:
                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    String shareBody = "Here is the share content body";
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "BestFriend");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                    startActivity(Intent.createChooser(sharingIntent, "Поделиться:"));

                    fullView.closeDrawers();
                    return true;

                default:
                    return false;
            }
        });
    }

}