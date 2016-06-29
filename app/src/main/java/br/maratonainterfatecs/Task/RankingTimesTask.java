package br.maratonainterfatecs.Task;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import br.maratonainterfatecs.Domain.Problema;
import br.maratonainterfatecs.Domain.Times;
import br.maratonainterfatecs.R;
import br.maratonainterfatecs.View.ClassificacaoView;
import br.maratonainterfatecs.util.JsonIO;

/**
 * Created by Lucas Falcao on 28/06/2016.
 */
public class RankingTimesTask extends AsyncTask<Void, Void, List<Times>> {


    ClassificacaoView classificacaoView;

    public RankingTimesTask(ClassificacaoView classificacaoView){this.classificacaoView = classificacaoView;}

    @Override
    protected List<Times> doInBackground(Void... params) {

        List<Times> listAux = new ArrayList<>();
        JSONArray json;
        String strJSON;

        try {
            strJSON = new JsonIO().readArquivo(classificacaoView.getContext(),"json/json_ranking_equipes.txt");
            json    = new JSONArray(strJSON);

            for (int i = 0; i < json.length(); i++) {

                JSONObject linha     = json.getJSONObject(i);
                String posicao       = linha.getString("posicao");
                String nome          = linha.getString("nome");
                String acertos       = linha.getString("baloes");
                String tempo         = "1000";//linha.getString("tempo");
                String fatec         = "São Paulo";//linha.getString("baloes");
                boolean classificado = false;//linha.getBoolean("clasificado");

                Times c = new Times(Integer.parseInt(posicao), nome,acertos,fatec,tempo,classificado);
                listAux.add(c);
            }

        }catch(Exception e){
            Log.d("", "Erro ao buscar JSON: " + e.toString());
        }
        return (listAux);
    }

    @Override
    protected void onPostExecute(List<Times> times) {
        classificacaoView.buildRecycler(times);
    }
}
