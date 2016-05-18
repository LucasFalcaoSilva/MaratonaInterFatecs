package br.maratonainterfatecs.Presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import br.maratonainterfatecs.View.EquipesView;
import br.maratonainterfatecs.View.SponsorsView;

/**
 * Created by 40312939841 on 18/03/2016.
 */
public class SponsorsPresenterImp implements SponsorsPresenter {

    SponsorsView sponsorsView;
    EquipesView  equipesView;

    public SponsorsPresenterImp(SponsorsView view){
        this.sponsorsView = view;
        this.equipesView  = null;
    }

    public SponsorsPresenterImp(EquipesView view){
        this.equipesView  = view;
        this.sponsorsView = null;
    }

    @Override
    public LinearLayoutManager createLinear() {
        Context context = sponsorsView == null ? equipesView.getContext() : sponsorsView.getContext();
        LinearLayoutManager llm = new LinearLayoutManager(context);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        return llm;
    }
}
