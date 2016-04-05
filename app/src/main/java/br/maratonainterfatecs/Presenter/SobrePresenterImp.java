package br.maratonainterfatecs.Presenter;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import br.maratonainterfatecs.View.SobreView;
import br.maratonainterfatecs.typeface.RobotoTypeFace;
import br.maratonainterfatecs.util.JsonIO;

/**
 * Created by Luan on 05/04/2016.
 */
public class SobrePresenterImp implements SobrePresenter{

    private SobreView sobreView;
    private RobotoTypeFace mRobotoTypeFace;

    public SobrePresenterImp(SobreView sobreView,RobotoTypeFace robotoTypeFace){
        this.sobreView = sobreView;
        this.mRobotoTypeFace = robotoTypeFace;
    }

    @Override
    public LinearLayout.LayoutParams createParametrosLinear(int margin) {
        //return null;

        LinearLayout.LayoutParams lp;

        lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1);

        if (margin != -1)
            lp.setMargins(margin, margin, margin, margin);

        return lp;

    }

    @Override
    public LinearLayout builderTabs() throws Exception {
        JSONArray jsonConfig = new JSONArray(rawResourceToString(sobreView.getContext()));
        LinearLayout linearPrincipal = new LinearLayout(sobreView.getContext());
        linearPrincipal.setOrientation(LinearLayout.VERTICAL);

        for (int i = 0, size = jsonConfig.length(); i < size; i++) {
            JSONObject myObject = jsonConfig.getJSONObject(i);

            LinearLayout linearLayout = new LinearLayout(sobreView.getContext());
            linearLayout.setOrientation(LinearLayout.VERTICAL);

// JSON - Titulo
            TextView txtTitulo = new TextView(sobreView.getContext());
            txtTitulo.setGravity(Gravity.CENTER);
            txtTitulo.setText(myObject.getString("titulo"));
            txtTitulo.setTypeface(mRobotoTypeFace.getRobotoBlack());

            linearLayout.addView(txtTitulo);

// JSON - Texto
            TextView txtTexto = new TextView(sobreView.getContext());
            txtTexto.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            txtTexto.setText(myObject.getString("texto"));
            txtTexto.setTypeface(mRobotoTypeFace.getRobotoRegular());

            linearLayout.addView(txtTexto);

            linearPrincipal.addView(linearLayout, createParametrosLinear(15));

        }
        return linearPrincipal;
    }

    @Override
    public String rawResourceToString(Context context) {
        return new JsonIO().readArquivo(context, "json/json_sobre_formatoeregras.txt");
    }
}
