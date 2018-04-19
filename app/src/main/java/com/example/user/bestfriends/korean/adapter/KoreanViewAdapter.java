package com.example.user.bestfriends.korean.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.bestfriends.R;
import com.example.user.bestfriends.korean.Korean;

import java.util.ArrayList;

public class KoreanViewAdapter extends RecyclerView.Adapter<KoreanViewHolder> {

    Context context;
    ArrayList<Korean> listLessons;
    private RecyclerViewClickListener mListener;

    public KoreanViewAdapter(Context context, ArrayList<Korean> listLessons) {
        this.context = context;
        this.listLessons = listLessons;
    }

    public KoreanViewAdapter(RecyclerViewClickListener listener) { mListener = listener; }

    public void setOnItemClickListener(RecyclerViewClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public KoreanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_korean_home_list, parent, false);
        context = parent.getContext();
        return new KoreanViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull KoreanViewHolder holder, int position) {
        holder.setName(listLessons.get(position));
    }

    @Override
    public int getItemCount() { return listLessons.size(); }
}