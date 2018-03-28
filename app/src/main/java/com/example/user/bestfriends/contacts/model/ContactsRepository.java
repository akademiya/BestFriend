package com.example.user.bestfriends.contacts.model;

import com.example.user.bestfriends.contacts.IContacts;

public interface ContactsRepository {
    void getListContacts(IContacts.OnResponseCallback callback);
}