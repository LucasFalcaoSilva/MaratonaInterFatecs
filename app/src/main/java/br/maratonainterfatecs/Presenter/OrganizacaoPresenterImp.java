package br.maratonainterfatecs.Presenter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;

import br.maratonainterfatecs.typeface.RobotoTypeFace;
import br.maratonainterfatecs.View.OrganizacaoView;
import br.maratonainterfatecs.util.JsonIO;

/**
 * Created by 40312939841 on 16/03/2016.
 */
public class OrganizacaoPresenterImp implements  OrganizacaoPresenter {

    private OrganizacaoView organizacaoView;
    private RobotoTypeFace  mRobotoTypeFace;

    public OrganizacaoPresenterImp(OrganizacaoView organizacaoView,RobotoTypeFace robotoTypeFace){
        this.organizacaoView = organizacaoView;
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

        JSONArray jsonConfig = new JSONArray(rawResourceToString(organizacaoView.getContext()));
        LinearLayout linearPrincipal = new LinearLayout(organizacaoView.getContext());
        linearPrincipal.setOrientation(LinearLayout.VERTICAL);

        for (int i = 0, size = jsonConfig.length(); i < size; i++) {
            JSONObject myObject = jsonConfig.getJSONObject(i);

            LinearLayout linearLayout = new LinearLayout(organizacaoView.getContext());
            linearLayout.setOrientation(LinearLayout.VERTICAL);

            TextView txtTiulo = new TextView(organizacaoView.getContext());
            txtTiulo.setText(myObject.getString("titulo"));
            txtTiulo.setTextColor(Color.BLACK);
            txtTiulo.setTypeface(mRobotoTypeFace.getRobotoBlack());

            linearLayout.addView(txtTiulo);

            JSONArray itensArray = myObject.getJSONArray("itens");

            for (int j = 0; j < itensArray.length(); j++) {

                LinearLayout linearNomes = new LinearLayout(organizacaoView.getContext());
                linearNomes.setOrientation(LinearLayout.VERTICAL);

                JSONObject item = itensArray.getJSONObject(j);

                TextView txtNome = new TextView(organizacaoView.getContext());
                txtNome.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                txtNome.setText(item.getString("cargo") + " " + item.getString("nome"));
                txtNome.setTypeface(mRobotoTypeFace.getRobotoMedium());

                TextView txtFatec = new TextView(organizacaoView.getContext());
                txtNome.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                txtFatec.setText(item.getString("fatec"));
                txtFatec.setTypeface(mRobotoTypeFace.getRobotoMedium());

                linearNomes.addView(txtNome);
                linearNomes.addView(txtFatec);

                linearLayout.addView(linearNomes, createParametrosLinear(15));
            }

            linearPrincipal.addView(linearLayout, createParametrosLinear(-1));

        }
        return linearPrincipal;
    }

    @Override
    public String rawResourceToString(Context context) {
       return new JsonIO().readArquivo(context,"json/json_organizacao.txt");
    }
}
