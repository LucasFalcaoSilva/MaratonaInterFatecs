package br.maratonainterfatecs.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.maratonainterfatecs.Domain.Sponsor;
import br.maratonainterfatecs.R;
import br.maratonainterfatecs.View.SponsorsView;
import br.maratonainterfatecs.holder.PatrocinadorHolder;

/**
 * Created by Luan on 15/03/2016.
 */
public class SponsorAdapter extends RecyclerView.Adapter<PatrocinadorHolder> {

    List<Sponsor>  mList;
    LayoutInflater layout;
    SponsorsView sponsorsView;

    public SponsorAdapter(SponsorsView view,List<Sponsor> l) {
        this.sponsorsView = view;
        this.layout       = LayoutInflater.from(view.getContext());
        this.mList        = l;
    }

    @Override
    public PatrocinadorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layout.inflate(R.layout.item_sponsor_card, parent, false);
        return new PatrocinadorHolder(sponsorsView,view);
    }

    @Override
    public void onBindViewHolder(PatrocinadorHolder holder, int position) {
        holder.tvNome.setText(mList.get(position).getNome());
        holder.ivLogo.setImageResource(mList.get(position).getLogo());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
