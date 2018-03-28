package com.example.user.bestfriends.contacts;


import com.example.user.bestfriends.contacts.model.ContactsRepository;

public final class ContactsPresenter implements IContacts.Presenter {
    private IContacts.View view;
    private ContactsRepository repository;

    public ContactsPresenter(IContacts.View view, ContactsRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void loadListContacts() { repository.getListContacts(callback); }

    private final IContacts.OnResponseCallback callback = listContacts -> view.showListContacts(listContacts);
}