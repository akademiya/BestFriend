package com.example.user.bestfriends.list_kido.model;


import com.example.user.bestfriends.list_kido.IListKido;

public interface ListKidoRepository {
    void getListKido(IListKido.OnResponseCallback callback);
}