package com.example.user.bestfriends.list_kido;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.user.bestfriends.BaseActivity;
import com.example.user.bestfriends.R;
import com.example.user.bestfriends.list_kido.adapter.PersonAdapter;
import com.example.user.bestfriends.list_kido.database.SqliteDatabase;

import java.util.List;

public class PersonView extends BaseActivity {

    private SqliteDatabase database;
    private RecyclerView recyclerView;
    private PersonAdapter personAdapter;
    private List<Person> allPersons;
    private FloatingActionButton fab;
    private RelativeLayout list_kido_empty;

    private Chronometer mChronometer;
    private Button startChronometer;
    private Button stopChronometer;
    private Button restartChronometer;

    private DrawerLayout mDrawerLayout;
    private ImageView button_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_list_kido);
        init();
        toolbar_button_menu();
        chronometer();
    }

    public static Intent getStartIntent(Context context) {
        return new Intent(context, PersonView.class);
    }

    public void toolbar_button_menu() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        button_menu = findViewById(R.id.button_menu);
        button_menu.setOnClickListener(v -> mDrawerLayout.openDrawer(Gravity.START));

    }

    private void init() {
        recyclerView = findViewById(R.id.rv_list_kido);
        list_kido_empty = findViewById(R.id.list_kido_empty);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> addTaskDialog());

        showOrHideFab();

        database = new SqliteDatabase(this);
        allPersons = database.listPerson();

        if (allPersons.size() > 0) {
            recyclerView.setVisibility(View.VISIBLE);
            personAdapter = new PersonAdapter(this, allPersons);
            recyclerView.setAdapter(personAdapter);
        } else {
            recyclerView.setVisibility(View.GONE);
            list_kido_empty.setVisibility(View.VISIBLE);
        }

    }

    private void showOrHideFab() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0 && fab.getVisibility() == View.VISIBLE) {
                    fab.hide();
                } else if (dy < 0 && fab.getVisibility() != View.VISIBLE) {
                    fab.show();
                }
            }
        });
    }

    private void addTaskDialog() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View subView = inflater.inflate(R.layout.item_edit_list_kido, null);

        final EditText nameField = subView.findViewById(R.id.create_person_name);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.add_new_person);
        builder.setView(subView);
        builder.create();

        builder.setPositiveButton(R.string.add_person, (dialog, which) -> {
            final String name = nameField.getText().toString();

            if (TextUtils.isEmpty(name)) {
                Toast.makeText(PersonView.this, R.string.something_wrong, Toast.LENGTH_SHORT).show();
            } else {
                Person newPerson = new Person(name);
                database.addPerson(newPerson);

                finish();
                startActivity(getIntent());
            }
        });

        builder.setNegativeButton(R.string.cancel, (dialog, which) ->
                Toast.makeText(PersonView.this, R.string.task_cancelled, Toast.LENGTH_SHORT).show());
        builder.show();
    }

    private void chronometer() {
        // TODO: реализовать в другом потоке
        mChronometer = findViewById(R.id.chronometer);
        startChronometer = findViewById(R.id.start);
        stopChronometer = findViewById(R.id.stop);
        restartChronometer = findViewById(R.id.reset);

        mChronometer.setOnChronometerTickListener(chronometer -> {
            long elapsedMillis = SystemClock.elapsedRealtime() - mChronometer.getBase();
            if (elapsedMillis == 720000) {
                Toast.makeText(this, "Прошло 12 минут", Toast.LENGTH_SHORT).show();
            }
            if (elapsedMillis == 1800000) {
                Toast.makeText(this, "Прошло 30 минут", Toast.LENGTH_SHORT).show();
            }
        });

        startChronometer.setOnClickListener(v -> {
            mChronometer.setBase(SystemClock.elapsedRealtime());
            mChronometer.start();
        });

        stopChronometer.setOnClickListener(v -> mChronometer.stop());
        restartChronometer.setOnClickListener(v -> mChronometer.setBase(SystemClock.elapsedRealtime()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (database != null) {
            database.close();
        }
    }
}