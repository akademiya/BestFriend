package com.example.user.bestfriends.korean.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.user.bestfriends.R;
import com.example.user.bestfriends.korean.Korean;

public class KoreanViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    Korean pName;
    TextView lesson;
    RelativeLayout container_lesson;
    private RecyclerViewClickListener rvListener;

    public KoreanViewHolder(View view, RecyclerViewClickListener listener) {
        super(view);
        this.rvListener = listener;
        view.setOnClickListener(this);
        lesson = view.findViewById(R.id.rule);
        container_lesson = view.findViewById(R.id.container_rule);
    }

    public void setName(Korean pName) {
        this.pName = pName;
        lesson.setText(pName.getItemName());
    }

    @Override
    public void onClick(View view) {
        if (rvListener != null) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                rvListener.onItemClick(position);
            }
        }
    }

}