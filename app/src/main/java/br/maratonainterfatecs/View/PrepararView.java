package br.maratonainterfatecs.View;

import android.content.Context;
import android.view.View;

/**
 * Created by Luan on 20/05/2016.
 */
public interface PrepararView {

    String TAG = "Como se preparar";
    void loadView(View v);
    Context getContext();

}
