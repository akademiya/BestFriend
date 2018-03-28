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
            listBooks.add(new Books(RANDOM.nextInt(Integer.MAX_VALUE), R.drawable.books, "Мастер и Маргарита", "https://drive.google.com/open?id=1Ama-V0GgW2Quw5Ydrit3hyOOYT54uvKb"));
            listBooks.add(new Books(RANDOM.nextInt(Integer.MAX_VALUE), R.drawable.books, "Преступление и наказание", "https://drive.google.com/open?id=1Ama-V0GgW2Quw5Ydrit3hyOOYT54uvKb"));
            listBooks.add(new Books(RANDOM.nextInt(Integer.MAX_VALUE), R.drawable.books, "Битва за Рамен", "https://drive.google.com/open?id=1Ama-V0GgW2Quw5Ydrit3hyOOYT54uvKb"));
            listBooks.add(new Books(RANDOM.nextInt(Integer.MAX_VALUE), R.drawable.books, "Сойти с ума", "https://drive.google.com/open?id=1Ama-V0GgW2Quw5Ydrit3hyOOYT54uvKb"));
            listBooks.add(new Books(RANDOM.nextInt(Integer.MAX_VALUE), R.drawable.books, "Лестница в небеса", "https://drive.google.com/open?id=1Ama-V0GgW2Quw5Ydrit3hyOOYT54uvKb"));
            listBooks.add(new Books(RANDOM.nextInt(Integer.MAX_VALUE), R.drawable.books, "Человек, нашедший свое лицо", "https://drive.google.com/open?id=1Ama-V0GgW2Quw5Ydrit3hyOOYT54uvKb"));
            listBooks.add(new Books(RANDOM.nextInt(Integer.MAX_VALUE), R.drawable.books, "Мастер и Маргарита", "https://drive.google.com/open?id=1Ama-V0GgW2Quw5Ydrit3hyOOYT54uvKb"));
            listBooks.add(new Books(RANDOM.nextInt(Integer.MAX_VALUE), R.drawable.books, "Мастер и Маргарита", "https://drive.google.com/open?id=1Ama-V0GgW2Quw5Ydrit3hyOOYT54uvKb"));
            listBooks.add(new Books(RANDOM.nextInt(Integer.MAX_VALUE), R.drawable.books, "Мастер и Маргарита", "https://drive.google.com/open?id=1Ama-V0GgW2Quw5Ydrit3hyOOYT54uvKb"));
            listBooks.add(new Books(RANDOM.nextInt(Integer.MAX_VALUE), R.drawable.books, "Мастер и Маргарита", "https://drive.google.com/open?id=1Ama-V0GgW2Quw5Ydrit3hyOOYT54uvKb"));
            listBooks.add(new Books(RANDOM.nextInt(Integer.MAX_VALUE), R.drawable.books, "Мастер и Маргарита", "https://drive.google.com/open?id=1Ama-V0GgW2Quw5Ydrit3hyOOYT54uvKb"));
            listBooks.add(new Books(RANDOM.nextInt(Integer.MAX_VALUE), R.drawable.books, "Мастер и Маргарита", "https://drive.google.com/open?id=1Ama-V0GgW2Quw5Ydrit3hyOOYT54uvKb"));

            callback.onResponse(listBooks);
        }, 0);

    }
}