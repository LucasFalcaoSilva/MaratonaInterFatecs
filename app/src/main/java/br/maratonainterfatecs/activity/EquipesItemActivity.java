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
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

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
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void loadView(View result) {
        mLinearOrganizacao.addView(result, equipesItemPresenter.createParametrosLinear(-1));
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "EquipesItem Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://br.maratonainterfatecs.activity/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "EquipesItem Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://br.maratonainterfatecs.activity/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
