package br.maratonainterfatecs.Task;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import br.maratonainterfatecs.Domain.Sponsor;
import br.maratonainterfatecs.R;
import br.maratonainterfatecs.View.SponsorsView;

/**
 * Created by 40312939841 on 18/03/2016.
 */
public class SponsorsTask extends AsyncTask<Void, Void, List<Sponsor>> {

    SponsorsView sponsorsView;

    public SponsorsTask(SponsorsView view){
        this.sponsorsView = view;
    }

    @Override
    protected List<Sponsor> doInBackground(Void... params) {
        return getSetCarList(10);
    }

    private List<Sponsor> getSetCarList(int qtd) {

        String[] nomes = new String[]{"Cengage Learning", "Ciee", "IBM"};
        int[] logos = new int[]{R.drawable.logo_cengage_learning, R.drawable.logo_ciee, R.drawable.ibm_logo};
        List<Sponsor> listAux = new ArrayList<>();

        for (int i = 0; i < qtd; i++) {
            Sponsor c = new Sponsor(nomes[i % nomes.length], logos[i % nomes.length]);
            listAux.add(c);
        }
        return (listAux);
    }

    @Override
    protected void onPostExecute(List<Sponsor> result) {
        sponsorsView.buildRecycler(result);
    }
}
