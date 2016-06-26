package br.maratonainterfatecs.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import br.maratonainterfatecs.Domain.Problema;

/**
 * Created by CASA on 25/06/2016.
 */
public interface RankingView {
    void loadComponents();
    void buildRecycler(List<Problema> mList);
    RecyclerView getRecycler();
    Context getContext();
}
