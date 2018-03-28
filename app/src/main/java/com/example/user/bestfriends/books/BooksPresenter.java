package com.example.user.bestfriends.books;


import com.example.user.bestfriends.books.model.BooksRepository;

public final class BooksPresenter implements IBooks.Presenter {

    private IBooks.View view;
    private BooksRepository repository;

    public BooksPresenter(IBooks.View view, BooksRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void loadListBooks() {repository.getListBooks(callback);}

    private final IBooks.OnResponseCallback callback = listBooks -> view.showListBooks(listBooks);
}