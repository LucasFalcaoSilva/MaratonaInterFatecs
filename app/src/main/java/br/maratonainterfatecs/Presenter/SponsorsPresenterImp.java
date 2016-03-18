package br.maratonainterfatecs.Presenter;

import android.support.v7.widget.LinearLayoutManager;

import br.maratonainterfatecs.View.SponsorsView;

/**
 * Created by 40312939841 on 18/03/2016.
 */
public class SponsorsPresenterImp implements SponsorsPresenter {

    SponsorsView sponsorsView;

    public SponsorsPresenterImp(SponsorsView view){
        this.sponsorsView = view;
    }

    @Override
    public LinearLayoutManager createLinear() {
        LinearLayoutManager llm = new LinearLayoutManager(sponsorsView.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        return llm;
    }
}
