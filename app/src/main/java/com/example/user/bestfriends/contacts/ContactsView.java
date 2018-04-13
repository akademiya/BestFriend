package com.example.user.bestfriends.contacts;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.user.bestfriends.BaseActivity;
import com.example.user.bestfriends.R;
import com.example.user.bestfriends.contacts.adapter.ContactsAdapter;
import com.example.user.bestfriends.contacts.database.SqliteDatabase;
import com.example.user.bestfriends.settings.SettingsView;

import java.util.List;

public class ContactsView extends BaseActivity {

    private SqliteDatabase database;
    private RecyclerView recyclerView;
    private ContactsAdapter adapter;
    private List<Contacts> allContacts;
    private FloatingActionButton fab;
    private RelativeLayout list_contacts_empty;

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
        return new Intent(context, ContactsView.class);
    }

    public void init() {
        recyclerView = findViewById(R.id.rv_list_contacts);
        list_contacts_empty = findViewById(R.id.list_kido_empty);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> addTaskDialog());

        showOrHideFab();

        database = new SqliteDatabase(this);
        allContacts = database.listContacts();

        if (allContacts.size() > 0) {
            recyclerView.setVisibility(View.VISIBLE);
            adapter = new ContactsAdapter(this, allContacts);
            recyclerView.setAdapter(adapter);
        } else {
            recyclerView.setVisibility(View.GONE);
            list_contacts_empty.setVisibility(View.VISIBLE);
        }
    }

    private void showOrHideFab() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0 && fab.getVisibility() == View.VISIBLE) { fab.hide(); }
                else if(dy < 0 && fab.getVisibility() != View.VISIBLE) { fab.show(); }
            }
        });
    }

    private void addTaskDialog() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View subView = inflater.inflate(R.layout.item_edit_contacts, null);

        final EditText nameField = subView.findViewById(R.id.create_contact_name);
        final EditText telephoneField = subView.findViewById(R.id.create_contact_telephone);
        final EditText emailField = subView.findViewById(R.id.create_contact_email);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.add_new_person);
        builder.setView(subView);
        builder.create();

        builder.setPositiveButton(R.string.add_person, (dialog, which) -> {
            final String name = nameField.getText().toString();
            final String telephone = telephoneField.getText().toString();
            final String email = emailField.getText().toString();

            if(TextUtils.isEmpty(name)){
                Toast.makeText(ContactsView.this, R.string.something_wrong, Toast.LENGTH_SHORT).show();
            } else {
                Contacts newContacts = new Contacts(name, telephone, email);
                database.addContacts(newContacts);

                finish();
                startActivity(getIntent());
            }
        });

        builder.setNegativeButton(R.string.cancel, (dialog, which) ->
                Toast.makeText(ContactsView.this, R.string.task_cancelled, Toast.LENGTH_SHORT).show());
        builder.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(database != null){
            database.close();
        }
    }

}