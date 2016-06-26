package br.maratonainterfatecs.Task;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.maratonainterfatecs.Domain.Problema;
import br.maratonainterfatecs.R;
import br.maratonainterfatecs.View.RankingView;
import br.maratonainterfatecs.util.JsonIO;

/**
 * Created by CASA on 25/06/2016.
 */
public class ProblemaTask extends AsyncTask<Void, Void, List<Problema>> {

    RankingView rankingView;

    public ProblemaTask(RankingView rankingView){this.rankingView = rankingView;}

    @Override
    protected List<Problema> doInBackground(Void... params) {
        return getSetProblemaList(10);
    }

    private List<Problema> getSetProblemaList(int qtd) {

        List<Problema> listAux = new ArrayList<>();
        JSONArray json         = new JSONArray();
        String strJSON;

        try {
            strJSON = new JsonIO().readArquivo(rankingView.getContext(),"json/json_ranking_problemas.txt");
            json    = new JSONArray(strJSON);

            for (int i = 0; i < json.length(); i++) {

                JSONObject linha  = json.getJSONObject(i);
                String nome       = linha.getString("problema");
                String imagem     = "problema_" + nome;
                imagem = imagem.toLowerCase();
                String tentativas = linha.getString("tentativas");
                String acertos    = linha.getString("acertos");
                String erros      = rankingView.getContext().getResources().getString(R.string.erros) + " ";

                //Obtem a imagem do balão
                Resources resources = rankingView.getContext().getResources();
                int resourceId = resources.getIdentifier(imagem, "drawable",rankingView.getContext().getPackageName());

                //Obtem o numero de erros
                try{

                    int intErro = Integer.parseInt(tentativas) - Integer.parseInt(acertos);
                    erros = erros + Integer.toString(intErro);

                }catch (NumberFormatException e){

                }

                nome = rankingView.getContext().getResources().getString(R.string.problema) + " " + nome;
                tentativas = rankingView.getContext().getResources().getString(R.string.tentativas) + " " + tentativas;
                acertos = rankingView.getContext().getResources().getString(R.string.acertos) + " " + acertos;

                Problema c = new Problema(nome, resourceId,tentativas,acertos,erros);
                listAux.add(c);
            }

        }catch(Exception e){
            Log.d("", "Erro ao buscar JSON: " + e.toString());
        }
        return (listAux);
    }

    @Override
    protected void onPostExecute(List<Problema> problemas) {
        rankingView.buildRecycler(problemas);
    }
}
