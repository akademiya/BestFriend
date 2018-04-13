package com.example.user.bestfriends.birthday.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.bestfriends.R;
import com.example.user.bestfriends.birthday.Birthday;
import com.example.user.bestfriends.birthday.database.SqliteDatabase;

import java.util.List;

public class BirthdayAdapter extends RecyclerView.Adapter<BirthdayHolder> {

    private Context context;
    private List<Birthday> listBirthday;
    private SqliteDatabase database;

    public BirthdayAdapter(Context context, List<Birthday> listBirthday) {
        this.context = context;
        this.listBirthday = listBirthday;
        database = new SqliteDatabase(context);
    }


    @NonNull
    @Override
    public BirthdayHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_birthday, parent, false);
        return new BirthdayHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BirthdayHolder holder, int position) {
        final Birthday singleBirthday = listBirthday.get(position);

        holder.person_name.setText(singleBirthday.getPerson_name());
        holder.date_birthday.setText(singleBirthday.getDate_birthday());

        holder.listView.setOnLongClickListener(v -> {
            holder.listReview.setVisibility(View.VISIBLE);
            return false;
        });
        holder.go_back.setOnClickListener(v -> holder.listReview.setVisibility(View.GONE));
        holder.edit_item.setOnClickListener(v -> editTaskDialog(singleBirthday));
        holder.delete_item.setOnClickListener(v -> {
            database.deleteItem(singleBirthday.getBirthdayID());
            ((Activity) context).finish();
            context.startActivity(((Activity) context).getIntent());
        });
    }

    @Override
    public int getItemCount() {
        return listBirthday.size();
    }

    private void editTaskDialog(final Birthday birthday) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View subView = inflater.inflate(R.layout.item_edit_list_birthday, null);

        final EditText nameField = subView.findViewById(R.id.create_person_name);
        final EditText birthdayField = subView.findViewById(R.id.create_date_birthday);

        if (birthday != null) {
            nameField.setText(birthday.getPerson_name());
            birthdayField.setText(birthday.getDate_birthday());
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.edit_person);
        builder.setView(subView);
        builder.create();

        builder.setPositiveButton(R.string.edit_person, (dialog, which) -> {
            final String name = nameField.getText().toString();
            final String date = birthdayField.getText().toString();

            assert birthday != null;
            database.updateBirthday(new Birthday(birthday.getBirthdayID(), name, date));
            ((Activity) context).finish();
            context.startActivity(((Activity) context).getIntent());

        });

        builder.setNegativeButton(R.string.cancel, (dialog, which) ->
                Toast.makeText(context, R.string.task_cancelled, Toast.LENGTH_SHORT).show());
        builder.show();
    }
}