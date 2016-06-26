package br.maratonainterfatecs.activity;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.maratonainterfatecs.Domain.Equipes;
import br.maratonainterfatecs.Domain.Unidades;
import br.maratonainterfatecs.Presenter.EquipesPresenterImp;
import br.maratonainterfatecs.R;
import br.maratonainterfatecs.Task.EquipesItemTask;
import br.maratonainterfatecs.typeface.RobotoTypeFace;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Falcao on 20/05/2016.
 */
public class EquipesItemActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.linear_organizacao)
    LinearLayout mLinearOrganizacao;

    private RobotoTypeFace mRobotoTypeFace;
    private EquipesPresenterImp equipesItemPresenter;

    static List<Equipes> equipes;
    static String nomeFatec;
    static Boolean abrir = false;

    public static Class<EquipesItemActivity> Instance(Unidades unidades) {

        nomeFatec = unidades.getNameFatec();

        if (unidades.getEquipesList() != null && unidades.getEquipesList().size() > 0) {
            abrir = true;
            equipes = unidades.getEquipesList();
        } else {
            abrir = false;
            equipes = new ArrayList<>();
        }

        return EquipesItemActivity.class;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_equipes);
        ButterKnife.bind(this);

        nomeFatec = nomeFatec.substring(nomeFatec.indexOf(".") + 1, nomeFatec.length()).replace("fatec", "");

        mToolbar.setTitle("FATEC " + nomeFatec.toUpperCase());

        setSupportActionBar(mToolbar);

        if (abrir) {
            mRobotoTypeFace = new RobotoTypeFace(this);
            equipesItemPresenter = new EquipesPresenterImp(this, mRobotoTypeFace, equipes);

            new EquipesItemTask(this, equipesItemPresenter).execute();
        } else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Aviso");
            alertDialogBuilder
                    .setMessage("Não foi encontrado nenhuma equipe para essa Fatec")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            EquipesItemActivity.this.finish();
                        }
                    });
            alertDialogBuilder.create().show();
        }
    }


    public void loadView(View result) {
        mLinearOrganizacao.addView(result, equipesItemPresenter.createParametrosLinear(-1));
    }
}
