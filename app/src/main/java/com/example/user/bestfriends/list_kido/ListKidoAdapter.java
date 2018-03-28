package com.example.user.bestfriends.list_kido;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.bestfriends.R;

import java.util.ArrayList;
import java.util.List;

public class ListKidoAdapter extends RecyclerView.Adapter<ListKidoAdapter.ListKidoHolder> {

    private final Context context;
    private final List<ListKido> listString = new ArrayList<>();

    public ListKidoAdapter(Context context) { this.context = context; }

    @NonNull
    @Override
    public ListKidoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_kido, parent, false);
        return new ListKidoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListKidoHolder holder, int position) {
        holder.personPhoto.setImageResource(listString.get(position).getPerson_photo());
        holder.personName.setText(listString.get(position).getPersonName());
        holder.check_people.setOnCheckedChangeListener(null);
        holder.check_people.setChecked(listString.get(position).getCheck());
        holder.check_people.setOnCheckedChangeListener((buttonView, isChecked) -> listString.get(holder.getAdapterPosition()).setCheck(isChecked));
    }

    @Override
    public int getItemCount() {
        return listString.size();
    }

    public void setList(List<ListKido> list) {
        listString.clear();
        listString.addAll(list);
        notifyDataSetChanged();
    }


    public static class ListKidoHolder extends RecyclerView.ViewHolder {

        ImageView personPhoto;
        TextView personName;
        CheckBox check_people;

        public ListKidoHolder(View view) {
            super(view);
            personPhoto = view.findViewById(R.id.person_photo);
            personName = view.findViewById(R.id.person_name);
            check_people = view.findViewById(R.id.check_people);
        }
    }
}