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

import com.example.user.bestfriends.R;
import com.example.user.bestfriends.korean.adapter.KoreanViewAdapter;
import com.example.user.bestfriends.korean.adapter.RecyclerViewClickListener;
import com.example.user.bestfriends.korean.grammar.GrammarAso;
import com.example.user.bestfriends.korean.grammar.GrammarEso;
import com.example.user.bestfriends.korean.grammar.GrammarNumbers;
import com.example.user.bestfriends.korean.grammar.GrammarSpacing;
import com.example.user.bestfriends.korean.grammar.GrammarVerbP;
import com.example.user.bestfriends.korean.grammar.GrammarVerbR;
import com.example.user.bestfriends.korean.grammar.GrammarVerbRy;
import com.example.user.bestfriends.korean.grammar.GrammarVerbS;
import com.example.user.bestfriends.korean.grammar.GrammarVerbT;
import com.example.user.bestfriends.korean.grammar.GrammarVerbYi;

import java.util.ArrayList;

public class KoreanGrammarFragment extends Fragment implements RecyclerViewClickListener {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout, parent, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ArrayList<Korean> mItem = new ArrayList<>();
        mItem.add(new Korean(R.string.aso));
        mItem.add(new Korean(R.string.eso));
        mItem.add(new Korean(R.string.numbers));
        mItem.add(new Korean(R.string.spacing));
        mItem.add(new Korean(R.string.irregular_t));
        mItem.add(new Korean(R.string.irregular_r));
        mItem.add(new Korean(R.string.irregular_p));
        mItem.add(new Korean(R.string.irregular_s));
        mItem.add(new Korean(R.string.irregular_ry));
        mItem.add(new Korean(R.string.irregular_yi));

        final RecyclerView home_list_recycler = view.findViewById(R.id.rv_list_fragment);
        home_list_recycler.setHasFixedSize(true);
        home_list_recycler.setLayoutManager(new LinearLayoutManager(this.getContext()));

        final KoreanViewAdapter adapter = new KoreanViewAdapter(this.getContext(), mItem);
        home_list_recycler.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(int position) {
        switch (position) {
            case 0:
                startActivity(new Intent(getActivity(), GrammarAso.class));
                break;
            case 1:
                startActivity(new Intent(getActivity(), GrammarEso.class));
                break;
            case 2:
                startActivity(new Intent(getActivity(), GrammarNumbers.class));
                break;
            case 3:
                startActivity(new Intent(getActivity(), GrammarSpacing.class));
                break;
            case 4:
                startActivity(new Intent(getActivity(), GrammarVerbT.class));
                break;
            case 5:
                startActivity(new Intent(getActivity(), GrammarVerbR.class));
                break;
            case 6:
                startActivity(new Intent(getActivity(), GrammarVerbP.class));
                break;
            case 7:
                startActivity(new Intent(getActivity(), GrammarVerbS.class));
                break;
            case 8:
                startActivity(new Intent(getActivity(), GrammarVerbRy.class));
                break;
            case 9:
                startActivity(new Intent(getActivity(), GrammarVerbYi.class));
                break;
            default: break;
        }
    }
}