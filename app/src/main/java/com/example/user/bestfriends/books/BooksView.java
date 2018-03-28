package com.example.user.bestfriends.books;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.user.bestfriends.BaseActivity;
import com.example.user.bestfriends.MainView;
import com.example.user.bestfriends.R;
import com.example.user.bestfriends.books.model.BooksStub;
import com.example.user.bestfriends.calendar.HCalendarView;

import java.util.List;

public class BooksView extends BaseActivity implements IBooks.View {

    private RecyclerView recyclerView;
    private BooksAdapter booksAdapter;
    private IBooks.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_list_books);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, BooksView.class);
        return intent;
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