package com.example.user.bestfriends.contacts;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.bestfriends.R;

import java.util.ArrayList;
import java.util.List;


public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsHolder> {

    private Context context;
    private ArrayList<Contacts> listContacts = new ArrayList<>();

    public ContactsAdapter(Context context) { this.context = context; }

    @NonNull
    @Override
    public ContactsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false);
        return new ContactsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsHolder holder, int position) {
        holder.person_photo.setImageResource(listContacts.get(position).getPersonPhoto());
        holder.person_name.setText(listContacts.get(position).getPersonName());
        holder.person_birthday.setText(listContacts.get(position).getPersonBirthday());
        holder.person_telephone.setText(listContacts.get(position).getPersonTelephone());
        holder.person_email.setText(listContacts.get(position).getPersonEmail());
        holder.chukpok.setText(listContacts.get(position).getPersonChukpok());
        holder.send_call.setOnClickListener(v -> {
            String toDial = listContacts.get(position).getPersonTelephone();
            context.startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + toDial)));
        });
        holder.send_soc.setOnClickListener(v -> {
            String toSoc = listContacts.get(position).getPersonTelephone();
            context.startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:" + toSoc)));
        });
        holder.send_email.setOnClickListener(v -> {
            String toEmail = listContacts.get(position).getPersonEmail();
            context.startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + toEmail)));
        });
    }

    public void setListContacts(List<Contacts> list) {
        listContacts.clear();
        listContacts.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() { return listContacts.size(); }

    public static class ContactsHolder extends RecyclerView.ViewHolder {
        ImageView person_photo;
        TextView person_name;
        TextView person_birthday;
        TextView person_telephone;
        TextView person_email;
        TextView chukpok;
        ImageView send_call;
        ImageView send_soc;
        ImageView send_email;

        public ContactsHolder(View view) {
            super(view);
            person_photo = view.findViewById(R.id.person_photo);
            person_name = view.findViewById(R.id.contact_name);
            person_birthday = view.findViewById(R.id.info_birthday);
            person_telephone = view.findViewById(R.id.info_telephone);
            person_email = view.findViewById(R.id.info_email);
            chukpok = view.findViewById(R.id.info_chukpok);
            send_call = view.findViewById(R.id.contact_send_call);
            send_soc = view.findViewById(R.id.contact_send_soc);
            send_email = view.findViewById(R.id.contact_send_email);
        }
    }


}