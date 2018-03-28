package com.example.user.bestfriends.books.model;

import com.example.user.bestfriends.books.IBooks;

public interface BooksRepository {
    void getListBooks(IBooks.OnResponseCallback callback);
}