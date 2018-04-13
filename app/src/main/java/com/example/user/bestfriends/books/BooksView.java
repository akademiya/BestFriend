package com.example.user.bestfriends.books;


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
import com.example.user.bestfriends.books.model.BooksStub;

import java.util.List;

public class BooksView extends BaseActivity implements IBooks.View {

    private RecyclerView recyclerView;
    private BooksAdapter booksAdapter;
    private IBooks.Presenter presenter;
    private DrawerLayout mDrawerLayout;
    private ImageView button_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_list_books);
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

    public static Intent getStartIntent(Context context) {
        return new Intent(context, BooksView.class);
    }

    private void init() {
        presenter = new BooksPresenter(this, new BooksStub());
        recyclerView = findViewById(R.id.view_list_books);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        booksAdapter = new BooksAdapter(this);
        recyclerView.setAdapter(booksAdapter);
        listener.onRefresh();
    }

    private final SwipeRefreshLayout.OnRefreshListener listener = () -> presenter.loadListBooks();

    @Override
    public void showListBooks(List<Books> listBooks) { booksAdapter.setListBooks(listBooks); }

    protected void onDestroy() {
        super.onDestroy();
        presenter.loadListBooks();
    }
}