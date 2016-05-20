package br.maratonainterfatecs.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import br.maratonainterfatecs.Domain.Unidades;

/**
 * Created by Falcao on 18/05/2016.
 */
public interface EquipesView {
    void loadComponents();
    void buildRecycler(List<Unidades> mList);
    RecyclerView getRecycler();
    Context getContext();

}

