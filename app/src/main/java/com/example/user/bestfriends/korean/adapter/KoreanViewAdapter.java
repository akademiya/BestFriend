package com.example.user.bestfriends.korean.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.bestfriends.R;
import com.example.user.bestfriends.korean.RecyclerViewModel;

import java.util.ArrayList;

public class KoreanViewAdapter extends RecyclerView.Adapter<KoreanViewHolder> {

    Context context;
    KoreanViewHolder.ItemListener mItemListener;
    ArrayList<RecyclerViewModel> mList;

    public KoreanViewAdapter(Context context, ArrayList<RecyclerViewModel> mList, KoreanViewHolder.ItemListener mItemListener) {
        this.context = context;
        this.mList = mList;
        this.mItemListener = mItemListener;
    }

    @NonNull
    @Override
    public KoreanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_korean_home_list, parent, false);
        context = parent.getContext();
        return new KoreanViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull KoreanViewHolder holder, int position) {
        holder.setData(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
