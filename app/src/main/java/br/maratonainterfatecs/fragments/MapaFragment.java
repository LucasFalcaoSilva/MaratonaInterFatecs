package br.maratonainterfatecs.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import br.maratonainterfatecs.R;

/**
 * Created by Luan on 18/07/2016.
 */
public class MapaFragment extends Fragment {

    public MapaFragment(){}

    public static MapaFragment newInstance(){
        MapaFragment fragment = new MapaFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_mapa, container, false);

        WebView wv = (WebView) view.findViewById(R.id.webMapa);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setSupportZoom(false);

        wv.loadUrl("https://drive.google.com/open?id=0B3l6HVbtB8RMT3R1S0NQZnUzX0U");

        return view;

    }

}
