package br.maratonainterfatecs.Task;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.LinearLayout;

import br.maratonainterfatecs.Presenter.SobrePresenter;
import br.maratonainterfatecs.View.SobreView;

/**
 * Created by Luan on 05/04/2016.
 */
public class SobreTask extends AsyncTask<Void, Void, LinearLayout> {

    SobrePresenter presenter;
    SobreView view;

    public SobreTask(SobreView view,SobrePresenter presenter){
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
    protected void onPostExecute(LinearLayout linearLayout) {
        //super.onPostExecute(linearLayout);
        view.loadView(linearLayout);
    }
}
