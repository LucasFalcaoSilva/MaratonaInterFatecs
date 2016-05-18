package br.maratonainterfatecs.Task;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.maratonainterfatecs.Domain.Sponsor;
import br.maratonainterfatecs.Domain.Unidades;
import br.maratonainterfatecs.View.EquipesView;
import br.maratonainterfatecs.util.JsonIO;

/**
 * Created by Falcao on 18/05/2016.
 */
public class EquipesTask extends AsyncTask<Void, Void, List<Unidades>> {

    EquipesView equipesView;

    public EquipesTask(EquipesView view){
        this.equipesView = view;
    }

    @Override
    protected List<Unidades> doInBackground(Void... params) {

        List<Unidades> listAux = new ArrayList<>();

        try {
            String strJSON = new JsonIO().readArquivo(equipesView.getContext(),"json/json_equipes.txt");

            Unidades[] unidades =  new Gson().fromJson(strJSON, Unidades[].class);

            listAux = Arrays.asList(unidades);

        }catch(Exception e){
            Log.d("", "Erro ao buscar JSON: " + e.toString());
        }

        return listAux;
    }

    @Override
    protected void onPostExecute(List<Unidades> result) {
        equipesView.buildRecycler(result);
    }

}
