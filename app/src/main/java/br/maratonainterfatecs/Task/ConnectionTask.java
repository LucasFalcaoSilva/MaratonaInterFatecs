package br.maratonainterfatecs.Task;

import android.content.Context;
import android.os.AsyncTask;

import br.maratonainterfatecs.rest.ConnectionClient;

/**
 * Created by Falcao on 10/05/2016.
 */
public class ConnectionTask extends AsyncTask<Void,Void,String> {

    private Context context;
    private String url;
    private ConnectionClient.Metodo metodo;

    public ConnectionTask(Context context,String url,ConnectionClient.Metodo metodo){
        this.context = context;
        this.url     = url;
        this.metodo  = metodo;
    }

    @Override
    protected String doInBackground(Void... params) {

        String resultado = "{}";

        if (metodo == ConnectionClient.Metodo.GET){
           resultado = ConnectionClient.GET(ConnectionClient.URL_EQUIPES);
        }else if (metodo == ConnectionClient.Metodo.POST){

        }

        return resultado;
    }

    @Override
    protected void onPostExecute(String result) {

    }

}
