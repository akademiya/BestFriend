package com.example.user.bestfriends.korean.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.bestfriends.R;
import com.example.user.bestfriends.korean.RecyclerViewModel;

public class KoreanViewHolder extends RecyclerView.ViewHolder {

    RecyclerViewModel pName;
    TextView rule;
    RelativeLayout container_rule;
    ItemListener mListener;
    Context context;

    public KoreanViewHolder(Context context, View view) {
        super(view);
//        view.setOnClickListener(this);
        rule = view.findViewById(R.id.rule);
        container_rule = view.findViewById(R.id.container_rule);

        view.setOnClickListener(v -> {
            int position = getAdapterPosition();
            if (mListener != null) {
                mListener.onItemClick(v, getAdapterPosition());
            }
            Toast.makeText(context, pName.getItemName(), Toast.LENGTH_SHORT).show();
        });
    }

    public void setData(RecyclerViewModel pName) {
        this.pName = pName;
        rule.setText(pName.getItemName());
    }

//    @Override
//    public void onClick(View v) {
//        if (mListener != null) {
//            mListener.onItemClick(pName, getAdapterPosition());
//        }
//    }

    public interface ItemListener {
//        void onItemClick(RecyclerViewModel pName, int position);
        void onItemClick(View view, int position);
    }
}
