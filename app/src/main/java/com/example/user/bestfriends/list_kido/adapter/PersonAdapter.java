package com.example.user.bestfriends.list_kido.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

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
        holder.edit_item.setOnClickListener(v -> editTaskDialog(singlePerson));
        holder.listView.setOnLongClickListener(v -> {
            holder.listReview.setVisibility(View.VISIBLE);
            return false;
        });
        holder.deleteItem.setOnClickListener(v -> {
            database.deleteItem(singlePerson.getPersonID());
            ((Activity)context).finish();
            context.startActivity(((Activity) context).getIntent());
        });
        holder.go_back.setOnClickListener(v -> holder.listReview.setVisibility(View.GONE));
    }

    @Override
    public int getItemCount() { return personList.size(); }

    private void editTaskDialog(final Person person){
        LayoutInflater inflater = LayoutInflater.from(context);
        View subView = inflater.inflate(R.layout.item_edit_list_kido, null);

        final EditText nameField = subView.findViewById(R.id.create_person_name);

        if(person != null){
            nameField.setText(person.getPersonName());
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.edit_person);
        builder.setView(subView);
        builder.create();

        builder.setPositiveButton(R.string.edit_person, (dialog, which) -> {
            final String name = nameField.getText().toString();

            if(TextUtils.isEmpty(name)){
                Toast.makeText(context, R.string.something_wrong, Toast.LENGTH_SHORT).show();
            }
            else{
                assert person != null;
                database.updatePerson(new Person(person.getPersonID(), name));
                ((Activity)context).finish();
                context.startActivity(((Activity)context).getIntent());
            }
        });

        builder.setNegativeButton(R.string.cancel, (dialog, which) ->
                Toast.makeText(context, R.string.task_cancelled, Toast.LENGTH_SHORT).show());
        builder.show();
    }
}