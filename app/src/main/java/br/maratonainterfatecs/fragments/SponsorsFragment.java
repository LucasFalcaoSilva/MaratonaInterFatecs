package br.maratonainterfatecs.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.maratonainterfatecs.Adapters.SponsorAdapter;
import br.maratonainterfatecs.Domain.Sponsor;
import br.maratonainterfatecs.Presenter.SponsorsPresenter;
import br.maratonainterfatecs.Presenter.SponsorsPresenterImp;
import br.maratonainterfatecs.R;
import br.maratonainterfatecs.Task.SponsorsTask;
import br.maratonainterfatecs.View.SponsorsView;
import br.maratonainterfatecs.activity.MenuActivity;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Luan on 15/03/2016.
 */
 public class SponsorsFragment extends Fragment implements SponsorsView {

    @Bind(R.id.rv_list) RecyclerView mRecyclerView;
    SponsorsPresenter presenter;
    List<Sponsor> mList;

    public static SponsorsFragment newInstance() {
        SponsorsFragment fragment = new SponsorsFragment();
        return fragment;
    }

    public SponsorsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sponsors, container, false);
        ButterKnife.bind(this, view);

        presenter = new SponsorsPresenterImp(this);

        loadComponents();

        new SponsorsTask(this).execute();

        return view;
    }

    @Override
    public void loadComponents() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(presenter.createLinear());
    }

    @Override
    public void buildRecycler(List<Sponsor>  mList ) {
        this.mList = mList;
        SponsorAdapter adapter = new SponsorAdapter(this, mList);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public RecyclerView getRecycler() {
        return mRecyclerView;
    }

}
