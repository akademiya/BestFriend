package com.example.user.bestfriends.korean.grammar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.user.bestfriends.BaseActivity;
import com.example.user.bestfriends.R;

public class GrammarVerbRy extends BaseActivity {

    public static Intent getStartIntent(Context context) {
        return new Intent(context, GrammarVerbRy.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_korean_grammar_verb_ry);
        toolbar_button_menu();
    }

    private void toolbar_button_menu() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}