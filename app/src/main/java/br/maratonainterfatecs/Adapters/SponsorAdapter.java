package br.maratonainterfatecs.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.maratonainterfatecs.Domain.Sponsor;
import br.maratonainterfatecs.Interfaces.RecyclerViewOnClickListenerHack;
import br.maratonainterfatecs.R;

/**
 * Created by Luan on 15/03/2016.
 */
public class SponsorAdapter extends RecyclerView.Adapter<SponsorAdapter.MyViewHolder> {

    private Context mContext;
    private List<Sponsor> mList;
    private LayoutInflater mLayoutInflater;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;
    private float scale;
    private int width;
    private int height;

    //Constructor
    public SponsorAdapter(Context c, List<Sponsor> l) {
        mContext = c;
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        scale = mContext.getResources().getDisplayMetrics().density;
        width = mContext.getResources().getDisplayMetrics().widthPixels - (int) (14 * scale + 0.5f);
        height = (width / 16) * 9;

    }

    //Somente quando é criado uma nova View
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_sponsor_card, viewGroup, false);
        MyViewHolder mvh = new MyViewHolder(v);
        return mvh;
    }


    /*Método chamado a todo momento que vincula os dados da lista com a View*/
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tvNome.setText(mList.get(position).getNome());
        holder.ivLogo.setImageResource(mList.get(position).getLogo());

    }

    //Tamanho da Lista de Patrocinadores
    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setRecyclerViewOnClickListenerHack(RecyclerViewOnClickListenerHack r){
        mRecyclerViewOnClickListenerHack = r;
    }


    public void addListItem(Sponsor s, int position){
        mList.add(s);
        notifyItemInserted(position);
    }


    public void removeListItem(int position){
        mList.remove(position);
        notifyItemRemoved(position);
    }

    //ViewHolder guarda a View para ser reutilizado
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView ivLogo;
        public TextView tvNome;

        public MyViewHolder(View itemView) {
            super(itemView);

            ivLogo = (ImageView) itemView.findViewById(R.id.iv_logo);
            tvNome = (TextView) itemView.findViewById(R.id.tv_nome);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if (mRecyclerViewOnClickListenerHack != null) {
                mRecyclerViewOnClickListenerHack.onClickListener(view, getLayoutPosition());
            }
        }
    }

}
