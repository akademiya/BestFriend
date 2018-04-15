package com.example.user.bestfriends.books.model;


import android.os.Handler;

import com.example.user.bestfriends.R;
import com.example.user.bestfriends.books.Books;
import com.example.user.bestfriends.books.IBooks;

import java.util.ArrayList;
import java.util.Random;

public final class BooksStub implements BooksRepository {

    static final Random RANDOM = new Random();

    @Override
    public void getListBooks(IBooks.OnResponseCallback callback) {
        new Handler().postDelayed(() -> {
            ArrayList<Books> listBooks = new ArrayList<>();
            listBooks.add(new Books(RANDOM.nextInt(Integer.MAX_VALUE), R.drawable.books, "Чампумоген", "https://drive.google.com/open?id=1oaMSqDtTmYXHlct0NwSxHs0hAa9HOfEK"));
            listBooks.add(new Books(RANDOM.nextInt(Integer.MAX_VALUE), R.drawable.books, "Божественный Принцип", "https://drive.google.com/open?id=1ky3o3LVl3CbKfvzOBVlM-zzSap6iEswS"));
            listBooks.add(new Books(RANDOM.nextInt(Integer.MAX_VALUE), R.drawable.books, "Чонсонген", "https://drive.google.com/open?id=1DRk27KyXYgQXPrSROrjs7lkkMhqwVsf0"));
            listBooks.add(new Books(RANDOM.nextInt(Integer.MAX_VALUE), R.drawable.books, "Писания Мира", "https://drive.google.com/open?id=1LNs31oa6EYb2clrHeCLTveVwIT_HhXV4"));
            listBooks.add(new Books(RANDOM.nextInt(Integer.MAX_VALUE), R.drawable.books, "Истинная Семья: врата, ведущие на Небеса", "https://drive.google.com/open?id=1St8i_XLz3KAaT7pAtn1ywrzbeSAMta3I"));
            listBooks.add(new Books(RANDOM.nextInt(Integer.MAX_VALUE), R.drawable.books, "Хозяин мира, Владыка родословия", "https://drive.google.com/open?id=1RcO_XntOXX3JAO_q28te7vciok2RR5vv"));
            listBooks.add(new Books(RANDOM.nextInt(Integer.MAX_VALUE), R.drawable.books, "Всемирное Писание", "https://drive.google.com/open?id=15agnU_mbUeFVz4Ael5RSsnaGGKfxEAFD"));
            listBooks.add(new Books(RANDOM.nextInt(Integer.MAX_VALUE), R.drawable.books, "Человек планеты, любящий мир", "https://drive.google.com/open?id=1e5ZAh3kIVQWs_moaXLPQiHsCMhedsnZw"));

            callback.onResponse(listBooks);
        }, 0);

    }
}