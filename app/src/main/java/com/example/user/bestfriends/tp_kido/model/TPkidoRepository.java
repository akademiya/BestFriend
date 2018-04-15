package com.example.user.bestfriends.tp_kido.model;

import com.example.user.bestfriends.tp_kido.ITPkido;

public interface TPkidoRepository {
    void getListTPkido(ITPkido.OnResponseCallback callback);
}