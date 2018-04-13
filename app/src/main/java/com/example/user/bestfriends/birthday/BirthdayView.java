package com.example.user.bestfriends.birthday;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.user.bestfriends.BaseActivity;
import com.example.user.bestfriends.BindView;
import com.example.user.bestfriends.R;
import com.example.user.bestfriends.birthday.adapter.BirthdayAdapter;
import com.example.user.bestfriends.birthday.database.SqliteDatabase;
import com.example.user.bestfriends.contacts.ContactsView;
import com.example.user.bestfriends.contacts.adapter.ContactsAdapter;

import java.util.List;

import butterknife.ButterKnife;

public class BirthdayView extends BaseActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private RelativeLayout list_birthday_empty;
    private SqliteDatabase database;
    private BirthdayAdapter adapter;
    private List<Birthday> allBirthday;


    public static Intent getStartIntent(Context context) {
        return new Intent(context, BirthdayView.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_list_birthday);

        init();
    }

    public void init() {
        list_birthday_empty = findViewById(R.id.list_kido_empty);
        recyclerView = findViewById(R.id.rv_list_birthday);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> addTaskDialog());
        showOrHideFab();

        database = new SqliteDatabase(this);
        allBirthday = database.listBirthday();

        if (allBirthday.size() > 0) {
            recyclerView.setVisibility(View.VISIBLE);
            adapter = new BirthdayAdapter(this, allBirthday);
            recyclerView.setAdapter(adapter);
        } else {
            recyclerView.setVisibility(View.GONE);
            list_birthday_empty.setVisibility(View.VISIBLE);
        }
    }

    private void showOrHideFab() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0 && fab.getVisibility() == View.VISIBLE) { fab.hide(); }
                else if (dy < 0 && fab.getVisibility() != View.VISIBLE) { fab.show(); }
            }
        });
    }

    private void addTaskDialog() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View subView = inflater.inflate(R.layout.item_edit_list_birthday, null);

        final EditText nameField = subView.findViewById(R.id.create_person_name);
        final EditText birthdayField = subView.findViewById(R.id.create_date_birthday);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.add_new_person);
        builder.setView(subView);
        builder.create();

        builder.setPositiveButton(R.string.add_person, (dialog, which) -> {
            final String name = nameField.getText().toString();
            final String birthday = birthdayField.getText().toString();

            if (TextUtils.isEmpty(name)) {
                Toast.makeText(BirthdayView.this, R.string.something_wrong, Toast.LENGTH_SHORT).show();
            } else {
                Birthday newBirthday = new Birthday(name, birthday);
                database.addBirthday(newBirthday);

                finish();
                startActivity(getIntent());
            }
        });

        builder.setNegativeButton(R.string.cancel, (dialog, which) ->
                Toast.makeText(BirthdayView.this, R.string.task_cancelled, Toast.LENGTH_SHORT).show());
        builder.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (database != null) {
            database.close();
        }
    }
}