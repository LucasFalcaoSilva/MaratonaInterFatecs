package br.maratonainterfatecs.Task;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.LinearLayout;

import br.maratonainterfatecs.Presenter.PrepararPresenter;
import br.maratonainterfatecs.View.PrepararView;

/**
 * Created by Luan on 20/05/2016.
 */
public class PrepararTask extends AsyncTask<Void, Void, LinearLayout> {

    PrepararPresenter presenter;
    PrepararView view;

    public PrepararTask(PrepararView view,PrepararPresenter presenter){
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
