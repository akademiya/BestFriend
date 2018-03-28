package com.example.user.bestfriends;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.bestfriends.books.BooksView;
import com.example.user.bestfriends.list_kido.ListKidoView;
import com.example.user.bestfriends.notes.NotesView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;

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

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

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