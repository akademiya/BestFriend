package com.example.user.bestfriends.list_kido.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.bestfriends.R;
import com.example.user.bestfriends.list_kido.Person;
import com.example.user.bestfriends.list_kido.database.SqliteDatabase;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonHolder> {

    private Context context;
    private List<Person> personList;
    private SqliteDatabase database;

    public PersonAdapter(Context context, List<Person> personList) {
        this.personList = personList;
        this.context = context;
        database = new SqliteDatabase(context);
    }

    @NonNull
    @Override
    public PersonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_kido, parent, false);
        return new PersonHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonHolder holder, int position) {
        final Person singlePerson = personList.get(position);

        holder.personName.setText(singlePerson.getPersonName());
        holder.deleteItem.setOnClickListener(v -> {
            database.deleteItem(singlePerson.getPersonID());
            ((Activity)context).finish();
            context.startActivity(((Activity) context).getIntent());
        });
    }


    @Override
    public int getItemCount() { return personList.size(); }
}