package com.example.user.bestfriends;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    Toolbar toolbar;
    private TextView random_word;
    private ImageView main_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // TODO: Set random text by click
        final List<String> wordList = new ArrayList<>();

        BufferedReader reader = null;
        random_word = findViewById(R.id.random_word);
        main_image = findViewById(R.id.tp_photo);
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("random_word.txt")));

            String mLine;

            while ((mLine = reader.readLine()) != null) {
                wordList.add(mLine);
            }
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
        // TODO: End random text by click

    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

}