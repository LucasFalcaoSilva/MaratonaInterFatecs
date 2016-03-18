package br.maratonainterfatecs.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import br.maratonainterfatecs.Domain.Sponsor;

/**
 * Created by 40312939841 on 17/03/2016.
 */
public interface SponsorsView {
    void loadComponents();
    void buildRecycler(List<Sponsor> mList);
    RecyclerView getRecycler();
    Context getContext();
}
