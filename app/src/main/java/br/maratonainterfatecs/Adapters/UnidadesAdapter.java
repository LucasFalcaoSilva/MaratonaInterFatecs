package br.maratonainterfatecs.Adapters;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.maratonainterfatecs.Domain.Unidades;
import br.maratonainterfatecs.R;
import br.maratonainterfatecs.View.EquipesView;
import br.maratonainterfatecs.holder.UnidadeHolder;

/**
 * Created by Falcao on 20/05/2016.
 */
public class UnidadesAdapter extends RecyclerView.Adapter<UnidadeHolder> {

    List<Unidades> mList;
    LayoutInflater layout;
    EquipesView equipesView;

    public UnidadesAdapter(EquipesView view,List<Unidades> l) {
        this.equipesView = view;
        this.layout      = LayoutInflater.from(view.getContext());
        this.mList       = l;
    }

    @Override
    public UnidadeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layout.inflate(R.layout.item_sponsor_card, parent, false);
        return new UnidadeHolder(equipesView,view);
    }

    @Override
    public void onBindViewHolder(UnidadeHolder holder, int position) {
        holder.unidades = mList.get(position);
        holder.tvNome.setText(holder.unidades.getNameFatec());

        String imagem = holder.unidades.getNameFatec();

        imagem = imagem.substring(imagem.indexOf(".") + 1,imagem.length());

        Resources resources = equipesView.getContext().getResources();
        int resourceId = resources.getIdentifier(imagem, "drawable",equipesView.getContext().getPackageName());

        holder.ivLogo.setImageResource(resourceId);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}

