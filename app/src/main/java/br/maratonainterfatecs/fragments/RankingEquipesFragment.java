package br.maratonainterfatecs.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import br.maratonainterfatecs.Adapters.TimesAdapter;
import br.maratonainterfatecs.Domain.Times;
import br.maratonainterfatecs.R;
import br.maratonainterfatecs.Task.RankingTimesTask;
import br.maratonainterfatecs.View.ClassificacaoView;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Lucas Falcao on 28/06/2016.
 */
public class RankingEquipesFragment extends Fragment implements ClassificacaoView {

    @Bind(R.id.list)
    RecyclerView recyclerView;

    public static RankingEquipesFragment newInstance() {
        RankingEquipesFragment fragment = new RankingEquipesFragment();
        return fragment;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clasificao, container, false);
        ButterKnife.bind(this, view);

        loadComponents();

        new RankingTimesTask(this).execute();

        return view;
    }

    @Override
    public void loadComponents() {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

    }

    @Override
    public void buildRecycler(List<Times> mList) {
        TimesAdapter adapter = new TimesAdapter(getContext(),mList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public RecyclerView getRecycler() {
        return recyclerView;
    }

    @Override
    public Context getContext() {
        return getActivity();
    }
}
