package com.example.user.bestfriends.tp_kido;

import java.util.ArrayList;

public interface ITPkido {

    interface View { void showListTPkido(ArrayList<TPkido> listTPkido); }
    interface Presenter { void loadListTPkido(); }
    interface OnResponseCallback { void onResponse(ArrayList<TPkido> listTPkido); }
}