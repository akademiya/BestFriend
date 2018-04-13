package com.example.user.bestfriends.birthday.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.user.bestfriends.R;

public class BirthdayHolder extends RecyclerView.ViewHolder {

    TextView person_name;
    TextView date_birthday;
    RelativeLayout listView;
    FrameLayout listReview;
    ImageView go_back;
    ImageView edit_item;
    ImageView delete_item;

    public BirthdayHolder(View view) {
        super(view);
        person_name = view.findViewById(R.id.person_name);
        date_birthday = view.findViewById(R.id.date_birthday);
        listView = view.findViewById(R.id.listView);
        listReview = view.findViewById(R.id.listReview);
        go_back = view.findViewById(R.id.go_back);
        edit_item = view.findViewById(R.id.edit_item);
        delete_item = view.findViewById(R.id.delete_item);
    }
}