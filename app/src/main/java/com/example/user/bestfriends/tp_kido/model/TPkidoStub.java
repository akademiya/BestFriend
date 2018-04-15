package com.example.user.bestfriends.tp_kido.model;

import android.os.Handler;

import com.example.user.bestfriends.R;
import com.example.user.bestfriends.tp_kido.ITPkido;
import com.example.user.bestfriends.tp_kido.TPkido;

import java.util.ArrayList;

public final class TPkidoStub implements TPkidoRepository {

    @Override
    public void getListTPkido(ITPkido.OnResponseCallback callback) {
        new Handler().postDelayed(() -> {
            ArrayList<TPkido> listTPkido = new ArrayList<>();
            listTPkido.add(new TPkido(R.string.pr_nadezdy, "https://drive.google.com/open?id=1toUJ1c30Vlwavzi5hKMPtwTZuNYOEmYL"));
            listTPkido.add(new TPkido(R.string.pr_pobedy, "https://drive.google.com/file/d/1TM6A10VQ-t4AOIWwmxLw_TiWINvCk2eF/view?usp=sharing"));
            listTPkido.add(new TPkido(R.string.pr_pochtitelnosty, "https://drive.google.com/file/d/1yTCik1IztTOu3H1aTwoL2dHQv4aQPQFX/view?usp=sharing"));
            listTPkido.add(new TPkido(R.string.pr_serdca, "https://drive.google.com/file/d/1BtZOmLedLsZCwp-RyLcPXgiCmiLgjGfe/view?usp=sharing"));
            listTPkido.add(new TPkido(R.string.pr_voskresheniya, "https://drive.google.com/file/d/1wFfKDODipDZBIh6pjOJHmrtb8RdTFese/view?usp=sharing"));
            listTPkido.add(new TPkido(R.string.pr_zelaniya, "https://drive.google.com/file/d/1f607yQ7g29RkAWcu9H4rH_I9bOsja-dl/view?usp=sharing"));

            callback.onResponse(listTPkido);
        }, 0);
    }
}