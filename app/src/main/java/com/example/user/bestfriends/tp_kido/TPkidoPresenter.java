package com.example.user.bestfriends.tp_kido;

import com.example.user.bestfriends.tp_kido.model.TPkidoRepository;

public class TPkidoPresenter implements ITPkido.Presenter {

    private ITPkido.View view;
    private TPkidoRepository repository;

    public TPkidoPresenter(ITPkido.View view, TPkidoRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void loadListTPkido() { repository.getListTPkido(callback); }

    private final ITPkido.OnResponseCallback callback = listTPkido -> view.showListTPkido(listTPkido);
}