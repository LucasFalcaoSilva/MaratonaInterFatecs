package br.maratonainterfatecs.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.List;

import br.maratonainterfatecs.Domain.Times;

/**
 * Created by Lucas Falcao on 28/06/2016.
 */
public interface ClassificacaoView {
        void loadComponents();
        void buildRecycler(List<Times> mList);
        RecyclerView getRecycler();
        Context getContext();

}
