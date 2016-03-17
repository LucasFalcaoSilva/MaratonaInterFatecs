package br.maratonainterfatecs.View;

import android.content.Context;
import android.view.View;

/**
 * Created by 40312939841 on 16/03/2016.
 */
public interface OrganizacaoView {
    String TAG = "Organizacao";
    void loadView(View v);
    Context getContext();
}
