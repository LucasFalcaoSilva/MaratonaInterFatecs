package br.maratonainterfatecs.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.maratonainterfatecs.R;


public class EquipesFragment extends Fragment {

    public EquipesFragment() {}

    public static EquipesFragment newInstance(String param1, String param2) {
        EquipesFragment fragment = new EquipesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_equipes, container, false);
        return layout;
    }
}
