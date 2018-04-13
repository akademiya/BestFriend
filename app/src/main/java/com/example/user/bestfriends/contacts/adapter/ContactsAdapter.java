package com.example.user.bestfriends.contacts.adapter;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.example.user.bestfriends.contacts.Contacts;
import com.example.user.bestfriends.contacts.database.SqliteDatabase;

import java.util.List;


public class ContactsAdapter extends RecyclerView.Adapter<ContactsHolder> {

    private Context context;
    private List<Contacts> listContacts;
    private SqliteDatabase database;

    public ContactsAdapter(Context context, List<Contacts> listContacts) {
        this.context = context;
        this.listContacts = listContacts;
        database = new SqliteDatabase(context);
    }

    @NonNull
    @Override
    public ContactsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false);
        return new ContactsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsHolder holder, int position) {
        final Contacts singleContacts = listContacts.get(position);

        holder.person_photo.setImageResource(R.drawable.ic_person);
        holder.person_name.setText(singleContacts.getPersonName());

        if (!singleContacts.getPersonTelephone().isEmpty()) {
            holder.person_telephone.setText(singleContacts.getPersonTelephone());

            holder.send_call.setOnClickListener(v -> {
                String toDial = singleContacts.getPersonTelephone();
                context.startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + toDial)));
            });

            holder.send_soc.setOnClickListener(v -> {
                String toSoc = singleContacts.getPersonTelephone();
                context.startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:" + toSoc)));
            });
        } else {
            holder.person_telephone.setVisibility(View.GONE);
            holder.send_call.setVisibility(View.GONE);
            holder.send_soc.setVisibility(View.GONE);
        }

        if (!singleContacts.getPersonEmail().isEmpty()) {
            if (!singleContacts.getPersonEmail().matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) {
                holder.person_email.setError("Invalid Email address");
                Toast.makeText(context, R.string.error_email, Toast.LENGTH_SHORT).show();
            }
            holder.person_email.setText(singleContacts.getPersonEmail());
        } else {
            holder.person_email.setVisibility(View.GONE);
        }

        holder.listContacts.setOnLongClickListener(v -> {
            holder.listReview.setVisibility(View.VISIBLE);
            return false;
        });

        holder.go_back.setOnClickListener(v -> holder.listReview.setVisibility(View.GONE));
        holder.edit_item.setOnClickListener(v -> editTaskDialog(singleContacts));
        holder.delete_item.setOnClickListener(v -> {
            database.deleteItem(singleContacts.getContactsID());
            ((Activity) context).finish();
            context.startActivity(((Activity) context).getIntent());
        });

    }

    @Override
    public int getItemCount() {
        return listContacts.size();
    }

    private void editTaskDialog(final Contacts contacts) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View subView = inflater.inflate(R.layout.item_edit_contacts, null);

        final EditText nameField = subView.findViewById(R.id.create_contact_name);
        final EditText telephoneField = subView.findViewById(R.id.create_contact_telephone);
        final EditText emailField = subView.findViewById(R.id.create_contact_email);

        if (contacts != null) {
            nameField.setText(contacts.getPersonName());
            telephoneField.setText(contacts.getPersonTelephone());
            emailField.setText(contacts.getPersonEmail());
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.edit_person);
        builder.setView(subView);
        builder.create();

        builder.setPositiveButton(R.string.edit_person, (dialog, which) -> {
            final String name = nameField.getText().toString();
            final String telephone = telephoneField.getText().toString();
            final String email = emailField.getText().toString();

            if (TextUtils.isEmpty(name)) {
                Toast.makeText(context, R.string.something_wrong, Toast.LENGTH_SHORT).show();
            } else {
                assert contacts != null;
                database.updateContacts(new Contacts(contacts.getContactsID(), name, telephone, email));
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
            }
        });

        builder.setNegativeButton(R.string.cancel, (dialog, which) ->
                Toast.makeText(context, R.string.task_cancelled, Toast.LENGTH_SHORT).show());
        builder.show();
    }
}