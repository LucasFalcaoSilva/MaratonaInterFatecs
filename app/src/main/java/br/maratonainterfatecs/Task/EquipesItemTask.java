package br.maratonainterfatecs.Task;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.LinearLayout;

import br.maratonainterfatecs.Presenter.EquipesPresenterImp;
import br.maratonainterfatecs.Presenter.OrganizacaoPresenter;
import br.maratonainterfatecs.View.OrganizacaoView;
import br.maratonainterfatecs.activity.EquipesItemActivity;

/**
 * Created by Falcao on 20/05/2016.
 */
public class EquipesItemTask extends AsyncTask<Void, Void, LinearLayout> {

   String TAG = "ErroITEM";

    EquipesPresenterImp presenter;
    EquipesItemActivity itemActivity;

    public EquipesItemTask(EquipesItemActivity itemActivity,EquipesPresenterImp presenter){
        this.itemActivity      = itemActivity;
        this.presenter = presenter;
    }

    @Override
    protected LinearLayout doInBackground(Void... params) {
        try {
            return presenter.builderTabs();
        } catch (Exception e) {
            Log.d(TAG, e.toString());
            return null;
        }
    }

    @Override
    protected void onPostExecute(LinearLayout result) {
        itemActivity.loadView(result);
    }

}
