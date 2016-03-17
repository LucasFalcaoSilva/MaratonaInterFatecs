package br.maratonainterfatecs.Task;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.LinearLayout;

import br.maratonainterfatecs.Presenter.OrganizacaoPresenter;
import br.maratonainterfatecs.View.OrganizacaoView;

/**
 * Created by 40312939841 on 16/03/2016.
 */
public class OrganizacaoTask extends AsyncTask<Void, Void, LinearLayout>{

    OrganizacaoPresenter presenter;
    OrganizacaoView      view;

    public OrganizacaoTask(OrganizacaoView view,OrganizacaoPresenter presenter){
        this.view      = view;
        this.presenter = presenter;
    }

    @Override
    protected LinearLayout doInBackground(Void... params) {
        try {
            return presenter.builderTabs();
        } catch (Exception e) {
            Log.d(view.TAG, e.toString());
            return null;
        }
    }

    @Override
    protected void onPostExecute(LinearLayout result) {
        view.loadView(result);
    }

}
