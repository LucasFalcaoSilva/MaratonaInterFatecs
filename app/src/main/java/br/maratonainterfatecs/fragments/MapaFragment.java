package br.maratonainterfatecs.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
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

        final ProgressDialog pd = ProgressDialog.show(view.getContext(),"","Loading",true);

        MenuActivity.wv = (WebView) view.findViewById(R.id.webMapa);

        MenuActivity.wv.loadUrl("http://luvicantor.esy.es/");

        MenuActivity.wv.getSettings().setJavaScriptEnabled(true);
        MenuActivity.wv.getSettings().setSupportZoom(true);
        MenuActivity.wv.getSettings().setBuiltInZoomControls(true);

        MenuActivity.wv.setWebChromeClient(new WebChromeClient());

        MenuActivity.wv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                if(pd!=null && pd.isShowing())
                {
                    pd.dismiss();
                }
            }
        });

        return view;

    }



}
