package br.maratonainterfatecs.util;

import android.content.Context;
import android.util.Log;

import java.io.InputStream;

/**
 * Created by 40312939841 on 22/03/2016.
 */
public class JsonIO {

    public static String TAG = "Json_operation";

    public String readArquivo(Context context,String nomeArquivo){
        byte[] buffer = null;
        InputStream is = null;
        try {
            is = context.getAssets().open(nomeArquivo);

            buffer = new byte[is.available()];
            while (is.read(buffer) != -1) ;
        } catch (Exception e) {
            buffer = new byte[2];
        } finally {
            try {
                if (is == null) {
                    is.close();
                }
            } catch (Exception e) {
                Log.d(TAG, "Erro ao Fechar Sream: " + e.toString());
            }
        }

        return new String(buffer);

    }

}
