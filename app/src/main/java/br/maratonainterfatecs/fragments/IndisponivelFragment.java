package br.maratonainterfatecs.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.maratonainterfatecs.R;

public class IndisponivelFragment extends Fragment {

    public IndisponivelFragment() {
    }

    public static IndisponivelFragment newInstance() {
        IndisponivelFragment fragment = new IndisponivelFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_indisponivel, container, false);
    }
}
