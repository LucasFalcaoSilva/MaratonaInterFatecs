package br.maratonainterfatecs.Task;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.maratonainterfatecs.Domain.Equipes;
import br.maratonainterfatecs.Domain.Integrantes;
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

        List<Unidades>    listUnidades    = new ArrayList<>();
        List<Equipes>     listEquipes     = new ArrayList<>();
        List<Integrantes> listIntegrantes = new ArrayList<>();

        try {
            String strJSON = new JsonIO().readArquivo(equipesView.getContext(), "json/json_equipes.txt");
            JSONArray json = new JSONArray(strJSON);

            for (int i = 0; i < json.length(); i++) {

                JSONObject linha = json.getJSONObject(i);
                String     nome  = linha.getString("nome");
                JSONArray equi   = linha.getJSONArray("equipes");


                listEquipes     = new ArrayList<>();

                for (int j = 0; j < equi.length(); j++) {

                    JSONObject linhaE  = equi.getJSONObject(j);
                    String     coach   = linhaE.getString("coach");
                    String nome_equipe = linhaE.getString("nome_equipe");
                    JSONArray integra  = linhaE.getJSONArray("integrantes");

                    listIntegrantes = new ArrayList<>();

                    for (int k = 0; k < integra.length(); k++) {

                        Integrantes in = new Integrantes(integra.get(k).toString());

                        listIntegrantes.add(in);

                    }

                    Equipes e = new Equipes(nome_equipe,coach,listIntegrantes);
                    listEquipes.add(e);
                }

                Unidades u = new Unidades(nome,listEquipes);
                listUnidades.add(u);
            }
            //Unidades[] unidades =  new Gson().fromJson(strJSON, Unidades[].class);
            //listAux = Arrays.asList(unidades);
        }catch(Exception e){
            Log.d("", "Erro ao buscar JSON: " + e.toString());
        }

        return listUnidades;
    }

    @Override
    protected void onPostExecute(List<Unidades> result) {
        equipesView.buildRecycler(result);
    }

}
