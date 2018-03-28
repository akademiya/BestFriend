package com.example.user.bestfriends.contacts;

import java.util.List;

public interface IContacts {

    interface View {
        void showListContacts(List<Contacts> list);
        void showContainerBirthday();
        void showContainerTelephone(Boolean visibility);
        void showContainerEmail(Boolean visibility);
    }

    interface Presenter { void loadListContacts(); }

    interface OnResponseCallback { void onResponce(List<Contacts> listKido); }
}
