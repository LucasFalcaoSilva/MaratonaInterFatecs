package br.maratonainterfatecs.Presenter;

import android.content.Context;
import android.widget.LinearLayout;

/**
 * Created by Luan on 20/05/2016.
 */
public interface PrepararPresenter {

    LinearLayout.LayoutParams createParametrosLinear(int margin);
    LinearLayout builderTabs() throws Exception;
    String rawResourceToString(Context context);

}
