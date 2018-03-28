package com.example.user.bestfriends.list_kido.model;

import com.example.user.bestfriends.R;
import com.example.user.bestfriends.list_kido.IListKido;
import com.example.user.bestfriends.list_kido.ListKido;

import java.util.ArrayList;

public final class ListKidoStub implements ListKidoRepository {

    @Override
    public void getListKido(final IListKido.OnResponseCallback callback) {

        new android.os.Handler().postDelayed(() -> {
            ArrayList<ListKido> kidoLists = new ArrayList<>();
            kidoLists.add(new ListKido(R.drawable.ic_person, "Bob Harwey", false));
            kidoLists.add(new ListKido(R.drawable.ic_person, "Tom Readle", false));
            kidoLists.add(new ListKido(R.drawable.ic_person, "Bob Harwey", false));
            kidoLists.add(new ListKido(R.drawable.ic_person, "Bob2 Harwey", false));
            kidoLists.add(new ListKido(R.drawable.ic_person, "Bob3 Harwey", false));
            kidoLists.add(new ListKido(R.drawable.ic_person, "Bob4 Harwey", false));
            kidoLists.add(new ListKido(R.drawable.ic_person, "Bob5 Harwey", false));
            kidoLists.add(new ListKido(R.drawable.ic_person, "Bob6 Harwey", false));
            kidoLists.add(new ListKido(R.drawable.ic_person, "Bob7 Harwey", false));
            kidoLists.add(new ListKido(R.drawable.ic_person, "Bob8 Harwey", false));
            kidoLists.add(new ListKido(R.drawable.ic_person, "Bob9 Harwey", false));
            kidoLists.add(new ListKido(R.drawable.ic_person, "Bob10 Harwey", false));
            kidoLists.add(new ListKido(R.drawable.ic_person, "Bob11 Harwey", false));

            callback.onResponce(kidoLists);
        }, 0);

    }
}