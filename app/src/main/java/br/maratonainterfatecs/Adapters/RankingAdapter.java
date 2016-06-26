package br.maratonainterfatecs.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.maratonainterfatecs.Domain.Problema;
import br.maratonainterfatecs.R;
import br.maratonainterfatecs.View.RankingView;
import br.maratonainterfatecs.holder.RankingHolder;

/**
 * Created by CASA on 25/06/2016.
 */
public class RankingAdapter extends RecyclerView.Adapter<RankingHolder>{

    List<Problema> mList;
    LayoutInflater layout;
    RankingView rankingView;

    public RankingAdapter(RankingView view,List<Problema> l) {
        this.rankingView = view;
        this.layout       = LayoutInflater.from(view.getContext());
        this.mList        = l;
    }

    @Override
    public RankingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layout.inflate(R.layout.item_problema_card, parent, false);
        return new RankingHolder(rankingView,view);
    }

    @Override
    public void onBindViewHolder(RankingHolder holder, int position) {
        holder.problema = mList.get(position);
        holder.tvNome.setText(holder.problema.getNome());
        holder.ivLogo.setImageResource(holder.problema.getLogo());
        holder.tvTentativas.setText(holder.problema.getTentativas());
        holder.tvAcertos.setText(holder.problema.getAcertos());
        holder.tvErros.setText(holder.problema.getErros());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
