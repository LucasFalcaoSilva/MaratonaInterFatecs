package br.maratonainterfatecs.Presenter;

import android.content.Context;
import android.widget.LinearLayout;

/**
 * Created by 40312939841 on 16/03/2016.
 */
public interface OrganizacaoPresenter {
    LinearLayout.LayoutParams createParametrosLinear(int margin);
    LinearLayout builderTabs() throws Exception;
    String rawResourceToString(Context context);
}
