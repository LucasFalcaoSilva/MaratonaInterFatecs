package br.maratonainterfatecs.Presenter;

import android.content.Context;
import android.widget.LinearLayout;

/**
 * Created by Falcao on 10/05/2016.
 */
public interface EdicaoPresenter {
    LinearLayout.LayoutParams createParametrosLinear(int margin);
    LinearLayout builderTabs() throws Exception;
    String rawResourceToString(Context context);
}
