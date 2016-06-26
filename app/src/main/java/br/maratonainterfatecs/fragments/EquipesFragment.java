package br.maratonainterfatecs.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.maratonainterfatecs.Adapters.UnidadesAdapter;
import br.maratonainterfatecs.Domain.Unidades;
import br.maratonainterfatecs.Presenter.SponsorsPresenter;
import br.maratonainterfatecs.Presenter.SponsorsPresenterImp;
import br.maratonainterfatecs.R;
import br.maratonainterfatecs.Task.EquipesTask;
import br.maratonainterfatecs.View.EquipesView;
import butterknife.Bind;
import butterknife.ButterKnife;


public class EquipesFragment extends Fragment implements EquipesView {

    @Bind(R.id.rv_list) RecyclerView mRecyclerView;

    SponsorsPresenter presenter;

    public static EquipesFragment newInstance() {
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
        ButterKnife.bind(this, layout);

        presenter = new SponsorsPresenterImp(this);

        loadComponents();

        new EquipesTask(this).execute();

        return layout;
    }

    @Override
    public void loadComponents() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(presenter.createLinear());
    }

    @Override
    public void buildRecycler(List<Unidades> mList) {
        UnidadesAdapter adapter = new UnidadesAdapter(this, mList);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public RecyclerView getRecycler() {
        return mRecyclerView;
    }

    @Override
    public Context getContext() {
        return getActivity();
    }
}
