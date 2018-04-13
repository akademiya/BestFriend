package com.example.user.bestfriends;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private TextView random_word;
    private String mLine;
    private ImageView main_image;
    private DrawerLayout mDrawerLayout;
    private ImageView button_menu;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        toolbar_button_menu();
        set_random_text();
    }

    private void set_random_text() {
        final List<String> wordList = new ArrayList<>();

        BufferedReader reader = null;
        random_word = findViewById(R.id.random_word);
        main_image = findViewById(R.id.tp_photo);
        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open("random_word.txt")));

            while ((mLine = reader.readLine()) != null) { wordList.add(mLine); }
        } catch (IOException e) {
            Toast.makeText(this, "File not found", Toast.LENGTH_SHORT).show();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    Toast.makeText(this, "IO Error", Toast.LENGTH_SHORT).show();
                }
            }
        }

        main_image.setOnClickListener(v -> random_word.setText(wordList.get((int) (Math.random() * wordList.size()))));
    }

    private void toolbar_button_menu() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        button_menu = findViewById(R.id.button_menu);
        button_menu.setOnClickListener(v -> mDrawerLayout.openDrawer(Gravity.START));
    }

}