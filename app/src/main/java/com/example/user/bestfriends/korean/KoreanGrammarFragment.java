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

public class KoreanGrammarFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout, parent, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ArrayList<RecyclerViewModel> mItem = new ArrayList<>();
        mItem.add(new RecyclerViewModel("- 은/는 (topic marker)"));
        mItem.add(new RecyclerViewModel("- 을/를 (object marker)"));
        mItem.add(new RecyclerViewModel("- 을/를 (object marker)"));
        mItem.add(new RecyclerViewModel("- 을/를 (object marker)"));
        mItem.add(new RecyclerViewModel("- 을/를 (object marker)"));
        mItem.add(new RecyclerViewModel("- 을/를 (object marker)"));
        mItem.add(new RecyclerViewModel("- 을/를 (object marker)"));
        mItem.add(new RecyclerViewModel("- 을/를 (object marker)"));
        mItem.add(new RecyclerViewModel("- 을/를 (object marker)"));

        final KoreanViewAdapter itemsAdapter = new KoreanViewAdapter(KoreanGrammarFragment.this.getActivity(), mItem, null);
        final RecyclerView home_list_recycler = view.findViewById(R.id.rv_list_fragment);
        home_list_recycler.setLayoutManager(new LinearLayoutManager(KoreanGrammarFragment.this.getActivity()));
        home_list_recycler.setHasFixedSize(true);
        home_list_recycler.setAdapter(itemsAdapter);
    }
}