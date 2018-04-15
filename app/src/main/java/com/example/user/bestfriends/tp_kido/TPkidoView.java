package com.example.user.bestfriends.tp_kido;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.widget.ImageView;

import com.example.user.bestfriends.BaseActivity;
import com.example.user.bestfriends.R;
import com.example.user.bestfriends.tp_kido.adapter.TPkidoAdapter;
import com.example.user.bestfriends.tp_kido.model.TPkidoStub;

import java.util.ArrayList;
import java.util.List;

public class TPkidoView extends BaseActivity implements ITPkido.View {

    private DrawerLayout mDrawerLayout;
    private ImageView button_menu;

    private RecyclerView recyclerView;
    private TPkidoAdapter adapter;
    private ITPkido.Presenter presenter;


    public static Intent getStartIntent(Context context) {
        return new Intent(context, TPkidoView.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_list_tp_kido);
        init();
        toolbar_button_menu();
    }

    private void toolbar_button_menu() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        button_menu = findViewById(R.id.button_menu);
        button_menu.setOnClickListener(v -> mDrawerLayout.openDrawer(Gravity.START));
    }

    private void init() {
        presenter = new TPkidoPresenter(this, new TPkidoStub());
        recyclerView = findViewById(R.id.view_list_tpkido);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TPkidoAdapter(this);
        recyclerView.setAdapter(adapter);
        listener.onRefresh();
    }

    private final SwipeRefreshLayout.OnRefreshListener listener = () -> presenter.loadListTPkido();

    @Override
    public void showListTPkido(ArrayList<TPkido> listTPkido) { adapter.setListTPkido(listTPkido); }

    protected void onDestroy() {
        super.onDestroy();
        presenter.loadListTPkido();
    }
}