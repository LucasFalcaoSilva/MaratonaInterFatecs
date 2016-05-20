package br.maratonainterfatecs.Presenter;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import br.maratonainterfatecs.Domain.Equipes;
import br.maratonainterfatecs.Domain.Integrantes;
import br.maratonainterfatecs.activity.EquipesItemActivity;
import br.maratonainterfatecs.typeface.RobotoTypeFace;

/**
 * Created by Falcao on 20/05/2016.
 */
public class EquipesPresenterImp implements  OrganizacaoPresenter {

    private EquipesItemActivity view;
    private RobotoTypeFace mRobotoTypeFace;
    private List<Equipes> equipes;

    public EquipesPresenterImp(EquipesItemActivity view,RobotoTypeFace robotoTypeFace,List<Equipes> equipes){
        this.view = view;
        this.mRobotoTypeFace = robotoTypeFace;
        this.equipes = equipes;
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

        LinearLayout linearPrincipal = new LinearLayout(view.getApplicationContext());
        linearPrincipal.setOrientation(LinearLayout.VERTICAL);

        for (Equipes equipe : equipes) {

            LinearLayout linearLayout = new LinearLayout(view.getApplicationContext());
            linearLayout.setOrientation(LinearLayout.VERTICAL);

            TextView txtTiulo = new TextView(view.getApplicationContext());
            txtTiulo.setText(equipe.getName_coach());
            txtTiulo.setTextColor(Color.BLACK);
            txtTiulo.setTypeface(mRobotoTypeFace.getRobotoBlack());

            linearLayout.addView(txtTiulo);

            TextView txtTiulo0 = new TextView(view.getApplicationContext());
            txtTiulo0.setText(equipe.getName_equipe());
            txtTiulo0.setTextColor(Color.BLACK);
            txtTiulo0.setTypeface(mRobotoTypeFace.getRobotoBlack());

            linearLayout.addView(txtTiulo0);


            for (Integrantes in : equipe.getIntegrantes()) {

                LinearLayout linearNomes = new LinearLayout(view.getApplicationContext());
                linearNomes.setOrientation(LinearLayout.VERTICAL);

                TextView txtNome = new TextView(view.getApplicationContext());
                txtNome.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                txtNome.setText(in.getName());
                txtNome.setTextColor(Color.BLACK);
                txtNome.setTypeface(mRobotoTypeFace.getRobotoMedium());


                linearNomes.addView(txtNome);

                linearLayout.addView(linearNomes, createParametrosLinear(15));
            }

            linearPrincipal.addView(linearLayout, createParametrosLinear(-1));

        }
        return linearPrincipal;
    }

    @Override
    public String rawResourceToString(Context context) {
        return null;
    }
}
