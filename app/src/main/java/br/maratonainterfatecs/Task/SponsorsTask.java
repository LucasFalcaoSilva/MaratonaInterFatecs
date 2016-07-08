package br.maratonainterfatecs.Task;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import br.maratonainterfatecs.Domain.Sponsor;
import br.maratonainterfatecs.R;
import br.maratonainterfatecs.View.SponsorsView;
import br.maratonainterfatecs.util.JsonIO;

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

        List<Sponsor> listAux = new ArrayList<>();
        JSONArray json        = new JSONArray();
        String strJSON;

        try {
            strJSON = new JsonIO().readArquivo(sponsorsView.getContext(),"json/json_patrocinador.txt");
            json    = new JSONArray(strJSON);

            for (int i = 0;i < json.length(); i++) {

                JSONObject linha = json.getJSONObject(i);
                String nome      = linha.getString("nome");
                String imagem    = linha.getString("imagem");
                String url       = linha.getString("url");
                String description = linha.getString("description");

                Resources resources = sponsorsView.getContext().getResources();
                int resourceId = resources.getIdentifier(imagem, "drawable",sponsorsView.getContext().getPackageName());

                Sponsor c = new Sponsor(nome, resourceId,url,description);
                listAux.add(c);
            }

        }catch(Exception e){
            Log.d("","Erro ao buscar JSON: " + e.toString());
        }
        return (listAux);
    }

    @Override
    protected void onPostExecute(List<Sponsor> result) {
        sponsorsView.buildRecycler(result);
    }
}
