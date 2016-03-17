package br.maratonainterfatecs.Presenter;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;

import br.maratonainterfatecs.typeface.RobotoTypeFace;
import br.maratonainterfatecs.View.OrganizacaoView;

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
                txtNome.setText(item.getString("nome"));
                txtNome.setTypeface(mRobotoTypeFace.getRobotoMedium());

                TextView txtFatec = new TextView(organizacaoView.getContext());
                txtNome.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                txtFatec.setText(item.getString("fatec"));
                txtFatec.setTypeface(mRobotoTypeFace.getRobotoMedium());

                linearNomes.addView(txtNome);
                linearNomes.addView(txtFatec);

                linearLayout.addView(linearNomes, createParametrosLinear(5));
            }

            linearPrincipal.addView(linearLayout, createParametrosLinear(-1));

        }
        return linearPrincipal;
    }

    @Override
    public String rawResourceToString(Context context) {
        byte[] buffer = null;
        InputStream is = null;
        try {
            is = context.getAssets().open("json/json_organizacao.txt");

            buffer = new byte[is.available()];
            while (is.read(buffer) != -1) ;
        } catch (Exception e) {
            buffer = new byte[2];
        } finally {
            try {
                if (is == null) {
                    is.close();
                }
            } catch (Exception e) {
                Log.d(organizacaoView.TAG, "Erro ao Fechar Sream: " + e.toString());
            }
        }

        return new String(buffer);
    }
}
