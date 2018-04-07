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
import com.example.user.bestfriends.korean.adapter.KoreanViewHolder;

import java.util.ArrayList;

public class KoreanGrammarFragment extends Fragment {

    private KoreanViewHolder.RecyclerViewClickListener listener;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout, parent, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ArrayList<RecyclerViewModel> mItem = new ArrayList<>();
        mItem.add(new RecyclerViewModel(R.string.aso));
        mItem.add(new RecyclerViewModel(R.string.eso));
        mItem.add(new RecyclerViewModel(R.string.numbers));
        mItem.add(new RecyclerViewModel(R.string.spacing));
        mItem.add(new RecyclerViewModel(R.string.irregular_t));
        mItem.add(new RecyclerViewModel(R.string.irregular_r));
        mItem.add(new RecyclerViewModel(R.string.irregular_p));
        mItem.add(new RecyclerViewModel(R.string.irregular_s));
        mItem.add(new RecyclerViewModel(R.string.irregular_ry));
        mItem.add(new RecyclerViewModel(R.string.irregular_yi));

        final KoreanViewAdapter itemsAdapter = new KoreanViewAdapter(KoreanGrammarFragment.this.getActivity(), mItem, null);
        final RecyclerView home_list_recycler = view.findViewById(R.id.rv_list_fragment);
        home_list_recycler.setLayoutManager(new LinearLayoutManager(KoreanGrammarFragment.this.getActivity()));
        home_list_recycler.setHasFixedSize(true);
        home_list_recycler.setAdapter(itemsAdapter);
    }
}