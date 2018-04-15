package com.example.user.bestfriends.tp_kido.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.bestfriends.R;
import com.example.user.bestfriends.tp_kido.TPkido;

import java.util.ArrayList;

public class TPkidoAdapter extends RecyclerView.Adapter<TPkidoHolder> {

    private Context context;
    private ArrayList<TPkido> listTPkido = new ArrayList<>();

    public TPkidoAdapter(Context context) { this.context = context; }

    @NonNull
    @Override
    public TPkidoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_tpkido, parent, false);
        return new TPkidoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TPkidoHolder holder, int position) {
        final TPkido singleList = listTPkido.get(position);

        holder.name_book_kido.setText(singleList.getNameTPkido());
        holder.listTPkidoLayout.setOnClickListener(v -> {
            final String website = singleList.getWebsite();
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
            context.startActivity(browserIntent);
        });
    }

    public void setListTPkido(ArrayList<TPkido> list) {
        listTPkido.clear();
        listTPkido.addAll(list);
        notifyDataSetChanged();
    }

    public TPkidoAdapter(Context context, ArrayList<TPkido> listTPkido) {
        this.context = context;
        this.listTPkido = listTPkido;
    }

    @Override
    public int getItemCount() { return listTPkido.size(); }
}