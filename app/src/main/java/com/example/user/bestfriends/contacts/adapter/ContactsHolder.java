package com.example.user.bestfriends.contacts.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.user.bestfriends.R;

public class ContactsHolder extends RecyclerView.ViewHolder {
    ImageView person_photo;
    TextView person_name;
    TextView person_telephone;
    TextView person_email;
    ImageView send_call;
    ImageView send_soc;
    RelativeLayout listContacts;
    FrameLayout listReview;
    ImageView go_back;
    ImageView edit_item;
    ImageView delete_item;

    public ContactsHolder(View view) {
        super(view);
        person_photo = view.findViewById(R.id.person_photo);
        person_name = view.findViewById(R.id.contact_name);
        person_telephone = view.findViewById(R.id.info_telephone);
        person_email = view.findViewById(R.id.info_email);
        send_call = view.findViewById(R.id.contact_send_call);
        send_soc = view.findViewById(R.id.contact_send_soc);
        listContacts = view.findViewById(R.id.listView);
        listReview = view.findViewById(R.id.listReview);
        go_back = view.findViewById(R.id.go_back);
        edit_item = view.findViewById(R.id.edit_item);
        delete_item = view.findViewById(R.id.delete_item);
    }
}