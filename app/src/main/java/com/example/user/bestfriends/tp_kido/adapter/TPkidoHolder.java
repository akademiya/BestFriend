package com.example.user.bestfriends.tp_kido.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.user.bestfriends.R;

public class TPkidoHolder extends RecyclerView.ViewHolder {
    TextView name_book_kido;
    RelativeLayout listTPkidoLayout;

    public TPkidoHolder(View view) {
        super(view);
        name_book_kido = view.findViewById(R.id.name_book_kido);
        listTPkidoLayout = view.findViewById(R.id.listTPkidoLayout);
    }
}