package com.example.user.bestfriends.korean;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.bestfriends.DestenationFragment;
import com.example.user.bestfriends.R;
import com.example.user.bestfriends.korean.adapter.KoreanViewAdapter;
import com.example.user.bestfriends.korean.adapter.RecyclerViewClickListener;

import java.util.ArrayList;

public class KoreanHomeFragment extends Fragment implements RecyclerViewClickListener {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout, parent, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ArrayList<Korean> mItem = new ArrayList<>();
        mItem.add(new Korean(R.string.enter_in_korean));
        mItem.add(new Korean(R.string.korean_topic));
        mItem.add(new Korean(R.string.korean_object));
        mItem.add(new Korean(R.string.korean_this));
        mItem.add(new Korean(R.string.tenses));
        mItem.add(new Korean(R.string.korean_future));
        mItem.add(new Korean(R.string.korean_progressive));
        mItem.add(new Korean(R.string.korean_present));
        mItem.add(new Korean(R.string.korean_past));
        mItem.add(new Korean(R.string.negative_expressions));
        mItem.add(new Korean(R.string.korean_not_be));
        mItem.add(new Korean(R.string.korean_cannot));
        mItem.add(new Korean(R.string.korean_not_verb));
        mItem.add(new Korean(R.string.korean_not_noun));
        mItem.add(new Korean(R.string.particles));
        mItem.add(new Korean(R.string.also));
        mItem.add(new Korean(R.string.unusually));
        mItem.add(new Korean(R.string.every));
        mItem.add(new Korean(R.string.much));
        mItem.add(new Korean(R.string.only));
        mItem.add(new Korean(R.string.more));
        mItem.add(new Korean(R.string.time));
        mItem.add(new Korean(R.string.to));
        mItem.add(new Korean(R.string.in));
        mItem.add(new Korean(R.string.of));
        mItem.add(new Korean(R.string.like));
        mItem.add(new Korean(R.string.listing));
        mItem.add(new Korean(R.string.but_than));
        mItem.add(new Korean(R.string.although));
        mItem.add(new Korean(R.string.not_only));
        mItem.add(new Korean(R.string.or));
        mItem.add(new Korean(R.string.and));
        mItem.add(new Korean(R.string.but));
        mItem.add(new Korean(R.string.time_expressions));
        mItem.add(new Korean(R.string.after_action));
        mItem.add(new Korean(R.string.during));
        mItem.add(new Korean(R.string.upon_finishing));
        mItem.add(new Korean(R.string.before));
        mItem.add(new Korean(R.string.do_sth));
        mItem.add(new Korean(R.string.kor_while));
        mItem.add(new Korean(R.string.soon));
        mItem.add(new Korean(R.string.ability));
        mItem.add(new Korean(R.string.cant_be));
        mItem.add(new Korean(R.string.cant_do));
        mItem.add(new Korean(R.string.can_do));
        mItem.add(new Korean(R.string.demands));
        mItem.add(new Korean(R.string.allowed));
        mItem.add(new Korean(R.string.must));
        mItem.add(new Korean(R.string.not_allowed));
        mItem.add(new Korean(R.string.please));
        mItem.add(new Korean(R.string.hope));
        mItem.add(new Korean(R.string.want));
        mItem.add(new Korean(R.string.wish));

        final RecyclerView home_list_recycler = view.findViewById(R.id.rv_list_fragment);
        home_list_recycler.setHasFixedSize(true);
        home_list_recycler.setLayoutManager(new LinearLayoutManager(this.getContext()));

        KoreanViewAdapter adapter = new KoreanViewAdapter(this.getContext(), mItem);
        home_list_recycler.setAdapter(adapter);
        adapter.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(int position) {
        switch (position) {
            case 0:
                break;
            case 1:
                startActivity(new Intent(getActivity(), DestenationFragment.class));
                break;
            case 2:
                startActivity(new Intent(getActivity(), DestActivity.class));
                break;
                default: break;
        }
    }
}