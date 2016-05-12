package br.maratonainterfatecs.Task;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.LinearLayout;

import br.maratonainterfatecs.Presenter.EdicaoPresenter;
import br.maratonainterfatecs.Presenter.OrganizacaoPresenter;
import br.maratonainterfatecs.View.EdicaoView;
import br.maratonainterfatecs.View.OrganizacaoView;

/**
 * Created by Falcao on 10/05/2016.
 */
public class EdicaoTask extends AsyncTask<Void, Void, LinearLayout> {

    EdicaoPresenter presenter;
    EdicaoView view;

    public EdicaoTask(EdicaoView view,EdicaoPresenter presenter){
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

