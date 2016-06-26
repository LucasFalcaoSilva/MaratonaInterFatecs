package br.maratonainterfatecs.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.maratonainterfatecs.Adapters.RankingAdapter;
import br.maratonainterfatecs.Domain.Problema;
import br.maratonainterfatecs.Presenter.RankingPresenter;
import br.maratonainterfatecs.Presenter.RankingPresenterImp;
import br.maratonainterfatecs.R;
import br.maratonainterfatecs.Task.ProblemaTask;
import br.maratonainterfatecs.View.RankingView;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by CASA on 25/06/2016.
 */
public class RankingProblemaFragment extends Fragment implements RankingView{

    @Bind(R.id.rv_list)
    RecyclerView mRecyclerView;
    RankingPresenter presenter;
    List<Problema> mList;

    public static RankingProblemaFragment newInstance() {
        RankingProblemaFragment fragment = new RankingProblemaFragment();
        return fragment;
    }

    public RankingProblemaFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ranking, container, false);
        ButterKnife.bind(this, view);

        presenter = new RankingPresenterImp(this);

        loadComponents();

        new ProblemaTask(this).execute();

        return view;
    }

    @Override
    public void loadComponents() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(presenter.createLinear());
    }

    @Override
    public void buildRecycler(List<Problema> mList) {
        this.mList = mList;
        RankingAdapter adapter = new RankingAdapter(this, mList);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public RecyclerView getRecycler() {
        return mRecyclerView;
    }
}
