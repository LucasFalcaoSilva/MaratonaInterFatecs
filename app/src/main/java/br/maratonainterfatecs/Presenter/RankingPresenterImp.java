package br.maratonainterfatecs.Presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import br.maratonainterfatecs.View.RankingView;

/**
 * Created by CASA on 25/06/2016.
 */
public class RankingPresenterImp implements RankingPresenter{

    RankingView rankingView;

    public RankingPresenterImp(RankingView rankingView){
        this.rankingView = rankingView;
    }

    @Override
    public LinearLayoutManager createLinear() {
        Context context = rankingView.getContext();
        LinearLayoutManager llm = new LinearLayoutManager(context);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        return llm;
    }
}
