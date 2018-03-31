package com.example.user.bestfriends.list_kido.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.user.bestfriends.R;

public class PersonHolder extends RecyclerView.ViewHolder {
    ImageView personPhoto;
    TextView personName;
    ImageView deleteItem;
    CheckBox check_people;
    RelativeLayout containerPersonList;

    public PersonHolder(View view) {
        super(view);
        personPhoto = view.findViewById(R.id.person_photo);
        personName = view.findViewById(R.id.person_name);
        deleteItem = view.findViewById(R.id.delete_item);
        check_people = view.findViewById(R.id.check_people);
        containerPersonList = view.findViewById(R.id.listView);
    }
}