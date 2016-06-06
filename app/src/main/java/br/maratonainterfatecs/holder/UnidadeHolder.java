package br.maratonainterfatecs.holder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.maratonainterfatecs.Domain.Unidades;
import br.maratonainterfatecs.R;
import br.maratonainterfatecs.View.EquipesView;
import br.maratonainterfatecs.activity.EquipesItemActivity;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Falcao on 20/05/2016.
 */
public class UnidadeHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {

    @Bind(R.id.iv_logo) public ImageView ivLogo;
    @Bind(R.id.tv_nome) public TextView tvNome;

    public Unidades unidades;
    EquipesView equipesView;

    public UnidadeHolder(EquipesView equipesView,View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(this);

        tvNome.setVisibility(View.GONE);

        this.equipesView = equipesView;
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(equipesView.getContext(), EquipesItemActivity.Instance(unidades));

        equipesView.getContext().startActivity(intent);

    }
}
