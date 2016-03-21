package br.maratonainterfatecs.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.maratonainterfatecs.Domain.Sponsor;
import br.maratonainterfatecs.Interfaces.RecyclerViewOnClickListenerHack;
import br.maratonainterfatecs.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Luan on 15/03/2016.
 */
public class SponsorAdapter extends RecyclerView.Adapter<SponsorAdapter.MyViewHolder> {

    List<Sponsor>  mList;
    LayoutInflater layout;

    public SponsorAdapter(Context context,List<Sponsor> l) {
        this.layout = LayoutInflater.from(context);
        this.mList  = l;
    }

    @Override
    public SponsorAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layout.inflate(R.layout.item_sponsor_card, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvNome.setText(mList.get(position).getNome());
        holder.ivLogo.setImageResource(mList.get(position).getLogo());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.iv_logo) public ImageView ivLogo;
        @Bind(R.id.tv_nome) public TextView tvNome;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }

    }

}
