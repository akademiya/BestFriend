package com.example.user.bestfriends.list_kido;


import com.example.user.bestfriends.list_kido.model.ListKidoRepository;

import java.util.List;

public final class ListKidoPresenter implements IListKido.Presenter {

    private IListKido.View view;
    private ListKidoRepository repository;

    public ListKidoPresenter(IListKido.View view, ListKidoRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void loadListKido() {
        repository.getListKido(callback);
    }

    private final IListKido.OnResponseCallback callback = new IListKido.OnResponseCallback() {
        @Override
        public void onResponce(List<ListKido> listKido) { view.showListKido(listKido); }

//        @Override
//        public void onError(String errMsg) {
//            // Можно реализовать крутилку и выводить ошибку в случай нарушения работы
//        }
    };

}