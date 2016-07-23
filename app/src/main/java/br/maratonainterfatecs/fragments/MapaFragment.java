package br.maratonainterfatecs.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import br.maratonainterfatecs.R;
import br.maratonainterfatecs.activity.MenuActivity;
import br.maratonainterfatecs.activity.SponsorActivity;

/**
 * Created by Luan on 18/07/2016.
 */
public class MapaFragment extends Fragment {

    public MapaFragment(){
        //Intent intent = new Intent(getActivity(),SponsorActivity.class);
        //startActivity(intent);
    }

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

        //WebView wv = (WebView) view.findViewById(R.id.webMapa);
        MenuActivity.wv = (WebView) view.findViewById(R.id.webMapa);
        MenuActivity.wv.getSettings().setJavaScriptEnabled(true);
        MenuActivity.wv.getSettings().setSupportZoom(true);

        //wv.loadUrl("https://drive.google.com/open?id=0B3l6HVbtB8RMT3R1S0NQZnUzX0U");
        MenuActivity.wv.loadUrl("http://luvicantor.esy.es/");

        MenuActivity.wv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
        });

        return view;

    }



}
