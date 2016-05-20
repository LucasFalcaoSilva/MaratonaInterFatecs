package br.maratonainterfatecs.Presenter;

import android.content.Context;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import br.maratonainterfatecs.View.PrepararView;
import br.maratonainterfatecs.typeface.RobotoTypeFace;
import br.maratonainterfatecs.util.JsonIO;

/**
 * Created by Luan on 20/05/2016.
 */
public class PrepararPresenterImp implements PrepararPresenter {

    private PrepararView prepararView;
    private RobotoTypeFace mRobotoTypeFace;

    public PrepararPresenterImp(PrepararView prepararView,RobotoTypeFace robotoTypeFace){
        this.prepararView = prepararView;
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
        JSONArray jsonConfig = new JSONArray(rawResourceToString(prepararView.getContext()));
        LinearLayout linearPrincipal = new LinearLayout(prepararView.getContext());
        linearPrincipal.setOrientation(LinearLayout.VERTICAL);

        for (int i = 0, size = jsonConfig.length(); i < size; i++) {
            JSONObject myObject = jsonConfig.getJSONObject(i);

            LinearLayout linearLayout = new LinearLayout(prepararView.getContext());
            linearLayout.setOrientation(LinearLayout.VERTICAL);

// JSON - Titulo
            TextView txtTitulo = new TextView(prepararView.getContext());
            txtTitulo.setGravity(Gravity.CENTER);
            txtTitulo.setText(myObject.getString("titulo"));
            txtTitulo.setTypeface(mRobotoTypeFace.getRobotoBlack());

            linearLayout.addView(txtTitulo);

// JSON - Link1
            String link1 = myObject.getString("link1");
            String text1 = myObject.getString("texto1");
            String texto = "<a href='" + link1 + "'> " + text1 + " </a>";

// JSON - Texto1
            TextView txtTexto1 = new TextView(prepararView.getContext());
            txtTexto1.setClickable(true);
            txtTexto1.setMovementMethod(LinkMovementMethod.getInstance());
            txtTexto1.setText(Html.fromHtml(texto));
            txtTexto1.setTypeface(mRobotoTypeFace.getRobotoRegular());
            txtTexto1.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));

            linearLayout.addView(txtTexto1);

// JSON - Link2
            String link2 = myObject.getString("link2");
            String text2 = myObject.getString("texto2");
            texto = "<a href='" + link2 + "'> " + text2 + " </a>";

// JSON - Texto2
            TextView txtTexto2 = new TextView(prepararView.getContext());
            txtTexto2.setClickable(true);
            txtTexto2.setMovementMethod(LinkMovementMethod.getInstance());
            txtTexto2.setText(Html.fromHtml(texto));
            txtTexto2.setTypeface(mRobotoTypeFace.getRobotoRegular());
            txtTexto2.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));

            linearLayout.addView(txtTexto2);

// JSON - Link3
            String link3 = myObject.getString("link3");
            String text3 = myObject.getString("texto3");
            texto = "<a href='" + link3 + "'> " + text3 + " </a>";

// JSON - Texto3
            TextView txtTexto3 = new TextView(prepararView.getContext());
            txtTexto3.setClickable(true);
            txtTexto3.setMovementMethod(LinkMovementMethod.getInstance());
            txtTexto3.setText(Html.fromHtml(texto));
            txtTexto3.setTypeface(mRobotoTypeFace.getRobotoRegular());
            txtTexto3.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));

            linearLayout.addView(txtTexto3);

            linearPrincipal.addView(linearLayout, createParametrosLinear(15));

        }
        return linearPrincipal;
    }

    @Override
    public String rawResourceToString(Context context) {
        return new JsonIO().readArquivo(context, "json/json_preparar.txt");
    }

}
