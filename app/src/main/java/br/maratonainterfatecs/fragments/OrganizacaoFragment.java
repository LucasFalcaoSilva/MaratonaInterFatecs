package br.maratonainterfatecs.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.maratonainterfatecs.R;


public class OrganizacaoFragment extends Fragment {

    public static OrganizacaoFragment newInstance() {
        OrganizacaoFragment fragment = new OrganizacaoFragment();
        return fragment;
    }

    public OrganizacaoFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_organizacao, container, false);
    }

}
