package com.example.user.bestfriends.list_kido;


import java.util.List;

public interface IListKido {
    interface View { void showListKido(List<ListKido> listKido); }
    interface Presenter { void loadListKido(); }
    interface OnResponseCallback { void onResponce(List<ListKido> listKido); }
}