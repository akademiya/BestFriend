package com.example.user.bestfriends.list_kido;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

import com.example.user.bestfriends.BaseActivity;
import com.example.user.bestfriends.R;
import com.example.user.bestfriends.list_kido.adapter.PersonAdapter;

public class ListKidoView extends BaseActivity {

    private Chronometer mChronometer;
    private Button startChronometer;
    private Button stopChronometer;
    private Button restartChronometer;

    private RecyclerView recyclerView;
    private ListKidoAdapter kidoAdapter;
    private IListKido.Presenter presenter;

    private FloatingActionButton fab;
    private PersonAdapter personAdapter;
    private Person person;

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_list_books);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true); TODO for hamburger


        // TODO: реализовать в другом потоке
        // TODO: Chronometer
//        mChronometer = findViewById(R.id.chronometer);
//        startChronometer = findViewById(R.id.start);
//        stopChronometer = findViewById(R.id.stop);
//        restartChronometer = findViewById(R.id.reset);
//
//        mChronometer.setOnChronometerTickListener(chronometer -> {
//            long elapsedMillis = SystemClock.elapsedRealtime() - mChronometer.getBase();
//            if (elapsedMillis == 720000) {
//                Toast.makeText(this, "Прошло 12 минут", Toast.LENGTH_SHORT).show();
//            }
//            if (elapsedMillis == 1800000) {
//                Toast.makeText(this, "Прошло 30 минут", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        startChronometer.setOnClickListener(v -> {
//            mChronometer.setBase(SystemClock.elapsedRealtime());
//            mChronometer.start();
//        });
//
//        stopChronometer.setOnClickListener(v -> mChronometer.stop());
//        restartChronometer.setOnClickListener(v -> mChronometer.setBase(SystemClock.elapsedRealtime()));
        // TODO: End Chronometer

//        init(); TODO список ListKido

        // TODO for hamburger icon and open navigation drawer
//        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
//            @Override
//            public void onDrawerOpened(View drawerView) {
//                super.onDrawerOpened(drawerView);
//
//                invalidateOptionsMenu();
//            }
//
//            @Override
//            public void onDrawerClosed(View drawerView) {
//                super.onDrawerClosed(drawerView);
//                invalidateOptionsMenu();
//            }
//        };
//
//        mDrawerLayout.setDrawerListener(mDrawerToggle);
        // TODO end hamburger icon and open navigation drawer
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

//    public static Intent getStartIntent(Context context) {
//        return new Intent(context, ListKidoView.class);
//    }

    // TODO реализация отображения списка ListKido, need implements IListKido.View
//    private void init() {
//        presenter = new ListKidoPresenter(this, new ListKidoStub());
//        recyclerView = findViewById(R.id.rv_list_kido);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        kidoAdapter = new ListKidoAdapter(this);
//        recyclerView.setAdapter(kidoAdapter);
//        listener.onRefresh();
//    }
//
//    private final SwipeRefreshLayout.OnRefreshListener listener = () -> presenter.loadListKido();
//
//    @Override
//    public void showListKido(List<ListKido> listKido) {
//        kidoAdapter.setList(listKido);
//    }
//
//    protected void onDestroy() {
//        super.onDestroy();
//        presenter.loadListKido();
//    }
    // TODO end реализация отображения списка ListKido

    // TODO for hamburger icon and open navigation drawer
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (mDrawerToggle.onOptionsItemSelected(item)) {return true;}
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    protected void onPostCreate(Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        mDrawerToggle.syncState();
//    }

}