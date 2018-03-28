package com.example.user.bestfriends.books;

import java.util.List;

public interface IBooks {
    interface View { void showListBooks(List<Books> listBooks); }
    interface Presenter { void loadListBooks(); }
    interface OnResponseCallback { void onResponse(List<Books> listBooks); }
}