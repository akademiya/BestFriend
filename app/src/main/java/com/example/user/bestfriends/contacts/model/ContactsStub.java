package com.example.user.bestfriends.contacts.model;

import com.example.user.bestfriends.R;
import com.example.user.bestfriends.contacts.Contacts;
import com.example.user.bestfriends.contacts.IContacts;

import java.util.ArrayList;

public final class ContactsStub implements ContactsRepository {

    @Override
    public void getListContacts(IContacts.OnResponseCallback callback) {

        new android.os.Handler().postDelayed(() -> {
            ArrayList<Contacts> listContacts = new ArrayList<>();
            listContacts.add(new Contacts(R.drawable.ic_person, "Bob Hankler", "25.02.1987", "+38 099 1234567", "bob@gmail.com", "chukpok issoe"));
            listContacts.add(new Contacts(R.drawable.ic_person, "Tom Hankler", "25.02.1987", "+38 067 2222222", "bob@gmail.com", "chukpok issoe"));
            listContacts.add(new Contacts(R.drawable.ic_person, "Diana Hankler", "25.02.1987", "+38 050 3333333", "bob@gmail.com", "chukpok issoe"));
            listContacts.add(new Contacts(R.drawable.ic_person, "Viola Hankler", "25.02.1987", "+38 044 9876543", "bob@gmail.com", "chukpok issoe"));

            callback.onResponce(listContacts);
        }, 0);


    }
}