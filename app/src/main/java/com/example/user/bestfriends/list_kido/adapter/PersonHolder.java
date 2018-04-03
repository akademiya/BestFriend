package com.example.user.bestfriends.list_kido.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.user.bestfriends.R;

public class PersonHolder extends RecyclerView.ViewHolder {
    TextView personName;
    ImageView deleteItem;
    ImageView edit_item;
    ImageView go_back;
    CheckBox check_people;
    RelativeLayout listView;
    FrameLayout listReview;

    public PersonHolder(View view) {
        super(view);
        personName = view.findViewById(R.id.person_name);
        deleteItem = view.findViewById(R.id.delete_item);
        edit_item = view.findViewById(R.id.edit_item);
        go_back = view.findViewById(R.id.go_back);
        check_people = view.findViewById(R.id.check_people);
        listView = view.findViewById(R.id.listView);
        listReview = view.findViewById(R.id.listReview);
    }
}