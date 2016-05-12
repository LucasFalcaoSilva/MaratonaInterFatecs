package br.maratonainterfatecs.View;

import android.content.Context;
import android.view.View;

/**
 * Created by Falcao on 10/05/2016.
 */
public interface EdicaoView {
    String TAG = "Edições anteriores";
    void loadView(View v);
    Context getContext();
}
