package com.example.user.bestfriends.contacts;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.user.bestfriends.BaseActivity;
import com.example.user.bestfriends.R;
import com.example.user.bestfriends.contacts.model.ContactsStub;
import com.example.user.bestfriends.settings.SettingsView;

import java.util.List;

public class ContactsView extends BaseActivity implements IContacts.View {

    private RecyclerView recyclerView;
    private ContactsAdapter adapter;
    private IContacts.Presenter presenter;
    private ContactsAdapter.ContactsHolder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_contact);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
    }

    // TODO: app bar menu переход в activity по клику на item
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                startActivity(SettingsView.getStartIntent(this));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    // TODO: end app bar menu переход в activity по клику на item

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, ContactsView.class);
        return intent;
    }

    public void init() {
        presenter = new ContactsPresenter(this, new ContactsStub());
        recyclerView = findViewById(R.id.rv_list_contacts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ContactsAdapter(this);
        recyclerView.setAdapter(adapter);
        listener.onRefresh();
    }

    private final SwipeRefreshLayout.OnRefreshListener listener = () -> presenter.loadListContacts();

    @Override
    public void showListContacts(List<Contacts> list) { adapter.setListContacts(list); }

    @Override
    public void showContainerBirthday() {
        if (holder.person_birthday != null){
            Toast.makeText(this, "др существует, ура!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showContainerTelephone(Boolean visibility) {
        if (holder.person_telephone != null){
            Toast.makeText(this, "телефон существует, ура!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showContainerEmail(Boolean visibility) {
        if (holder.person_email != null){
            Toast.makeText(this, "email существует, ура!", Toast.LENGTH_SHORT).show();
        }
    }
}