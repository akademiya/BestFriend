package com.example.user.bestfriends.korean;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.bestfriends.R;
import com.example.user.bestfriends.korean.adapter.KoreanViewAdapter;

import java.util.ArrayList;

public class KoreanHomeFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout, parent, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ArrayList<RecyclerViewModel> mItem = new ArrayList<>();
        mItem.add(new RecyclerViewModel(R.string.enter_in_korean));
        mItem.add(new RecyclerViewModel(R.string.korean_topic));
        mItem.add(new RecyclerViewModel(R.string.korean_object));
        mItem.add(new RecyclerViewModel(R.string.korean_this));
        mItem.add(new RecyclerViewModel(R.string.tenses));
        mItem.add(new RecyclerViewModel(R.string.korean_future));
        mItem.add(new RecyclerViewModel(R.string.korean_progressive));
        mItem.add(new RecyclerViewModel(R.string.korean_present));
        mItem.add(new RecyclerViewModel(R.string.korean_past));
        mItem.add(new RecyclerViewModel(R.string.negative_expressions));
        mItem.add(new RecyclerViewModel(R.string.korean_not_be));
        mItem.add(new RecyclerViewModel(R.string.korean_cannot));
        mItem.add(new RecyclerViewModel(R.string.korean_not_verb));
        mItem.add(new RecyclerViewModel(R.string.korean_not_noun));
        mItem.add(new RecyclerViewModel(R.string.particles));
        mItem.add(new RecyclerViewModel(R.string.also));
        mItem.add(new RecyclerViewModel(R.string.unusually));
        mItem.add(new RecyclerViewModel(R.string.every));
        mItem.add(new RecyclerViewModel(R.string.much));
        mItem.add(new RecyclerViewModel(R.string.only));
        mItem.add(new RecyclerViewModel(R.string.more));
        mItem.add(new RecyclerViewModel(R.string.time));
        mItem.add(new RecyclerViewModel(R.string.to));
        mItem.add(new RecyclerViewModel(R.string.in));
        mItem.add(new RecyclerViewModel(R.string.of));
        mItem.add(new RecyclerViewModel(R.string.like));
        mItem.add(new RecyclerViewModel(R.string.listing));
        mItem.add(new RecyclerViewModel(R.string.but_than));
        mItem.add(new RecyclerViewModel(R.string.although));
        mItem.add(new RecyclerViewModel(R.string.not_only));
        mItem.add(new RecyclerViewModel(R.string.or));
        mItem.add(new RecyclerViewModel(R.string.and));
        mItem.add(new RecyclerViewModel(R.string.but));
        mItem.add(new RecyclerViewModel(R.string.time_expressions));
        mItem.add(new RecyclerViewModel(R.string.after_action));
        mItem.add(new RecyclerViewModel(R.string.during));
        mItem.add(new RecyclerViewModel(R.string.upon_finishing));
        mItem.add(new RecyclerViewModel(R.string.before));
        mItem.add(new RecyclerViewModel(R.string.do_sth));
        mItem.add(new RecyclerViewModel(R.string.kor_while));
        mItem.add(new RecyclerViewModel(R.string.soon));
        mItem.add(new RecyclerViewModel(R.string.ability));
        mItem.add(new RecyclerViewModel(R.string.cant_be));
        mItem.add(new RecyclerViewModel(R.string.cant_do));
        mItem.add(new RecyclerViewModel(R.string.can_do));
        mItem.add(new RecyclerViewModel(R.string.demands));
        mItem.add(new RecyclerViewModel(R.string.allowed));
        mItem.add(new RecyclerViewModel(R.string.must));
        mItem.add(new RecyclerViewModel(R.string.not_allowed));
        mItem.add(new RecyclerViewModel(R.string.please));
        mItem.add(new RecyclerViewModel(R.string.hope));
        mItem.add(new RecyclerViewModel(R.string.want));
        mItem.add(new RecyclerViewModel(R.string.wish));

        final KoreanViewAdapter itemsAdapter = new KoreanViewAdapter(KoreanHomeFragment.this.getActivity(), mItem, null);
        final RecyclerView home_list_recycler = view.findViewById(R.id.rv_list_fragment);
        home_list_recycler.setLayoutManager(new LinearLayoutManager(KoreanHomeFragment.this.getActivity()));
        home_list_recycler.setHasFixedSize(true);
        home_list_recycler.setAdapter(itemsAdapter);
    }

}