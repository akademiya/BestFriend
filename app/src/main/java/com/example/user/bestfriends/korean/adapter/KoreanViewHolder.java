package com.example.user.bestfriends.korean.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.user.bestfriends.R;
import com.example.user.bestfriends.korean.RecyclerViewModel;

public class KoreanViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    RecyclerViewModel pName;
    TextView rule;
    RelativeLayout container_rule;
    ItemListener mListener;

    public KoreanViewHolder(View view) {
        super(view);
        view.setOnClickListener(this);
        rule = view.findViewById(R.id.rule);
        container_rule = view.findViewById(R.id.container_rule);
    }

    public void setData(RecyclerViewModel pName) {
        this.pName = pName;
        rule.setText(pName.getItemName());
    }

    @Override
    public void onClick(View v) {
        if (mListener != null) {
            mListener.onItemClick(pName, getAdapterPosition());
        }
    }

    public interface ItemListener {
        void onItemClick(RecyclerViewModel pName, int position);
    }
}
