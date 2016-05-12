package br.maratonainterfatecs.Presenter;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import br.maratonainterfatecs.View.EdicaoView;
import br.maratonainterfatecs.typeface.RobotoTypeFace;
import br.maratonainterfatecs.util.JsonIO;

/**
 * Created by Falcao on 10/05/2016.
 */
public class EdicaoPresenterImp implements EdicaoPresenter {

    private RobotoTypeFace mRobotoTypeFace;
    private EdicaoView     view;

    public EdicaoPresenterImp(EdicaoView view,RobotoTypeFace robotoTypeFace){
        this.view = view;
        this.mRobotoTypeFace = robotoTypeFace;
    }

    @Override
    public LinearLayout.LayoutParams createParametrosLinear(int margin) {
        LinearLayout.LayoutParams lp;

        lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1);

        if (margin != -1)
            lp.setMargins(margin, margin, margin, margin);

        return lp;
    }

    @Override
    public LinearLayout builderTabs() throws Exception {

        LinearLayout linearPrincipal = new LinearLayout(view.getContext());
        linearPrincipal.setOrientation(LinearLayout.VERTICAL);

        JSONObject json = new JSONObject(rawResourceToString(view.getContext()));
        JSONArray jsonConfig = json.getJSONArray("unidades");

        String texto = json.getString("descricao");

        TextView txtMensagem = new TextView(view.getContext());
        txtMensagem.setGravity(Gravity.LEFT);
        txtMensagem.setText(texto);
        txtMensagem.setTypeface(mRobotoTypeFace.getRobotoBlack());
        linearPrincipal.addView(txtMensagem, createParametrosLinear(15));

        for (int i = 0, size = jsonConfig.length(); i < size; i++) {
            JSONObject myObject = jsonConfig.getJSONObject(i);

            LinearLayout linearLayout = new LinearLayout(view.getContext());
            linearLayout.setOrientation(LinearLayout.VERTICAL);

            TextView txtTitulo = new TextView(view.getContext());
            txtTitulo.setGravity(Gravity.LEFT);
            txtTitulo.setText("      > " + myObject.getString("nome"));
            txtTitulo.setTypeface(mRobotoTypeFace.getRobotoBlack());
            linearLayout.addView(txtTitulo);
            linearPrincipal.addView(linearLayout, createParametrosLinear(10));

        }

        return linearPrincipal;
    }

    @Override
    public String rawResourceToString(Context context) {
        return new JsonIO().readArquivo(context, "json/json_edicoes.txt");
    }
}
