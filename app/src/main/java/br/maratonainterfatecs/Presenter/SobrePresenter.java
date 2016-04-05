package br.maratonainterfatecs.Presenter;

import android.content.Context;
import android.widget.LinearLayout;

/**
 * Created by Luan on 05/04/2016.
 */
public interface SobrePresenter {

    LinearLayout.LayoutParams createParametrosLinear(int margin);
    LinearLayout builderTabs() throws Exception;
    String rawResourceToString(Context context);

}
