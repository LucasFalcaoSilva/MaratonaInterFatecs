package br.maratonainterfatecs.holder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.maratonainterfatecs.Domain.Problema;
import br.maratonainterfatecs.R;
import br.maratonainterfatecs.View.RankingView;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by CASA on 25/06/2016.
 */
public class RankingHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    @Bind(R.id.iv_logo) public ImageView ivLogo;
    @Bind(R.id.tv_nome) public TextView tvNome;
    @Bind(R.id.tv_tentativas) public TextView tvTentativas;
    @Bind(R.id.tv_acertos) public TextView tvAcertos;
    @Bind(R.id.tv_erros) public TextView tvErros;

    public Problema problema;
    RankingView rankingView;

    public RankingHolder(RankingView rankingView, View itemView){
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(this);
        this.rankingView = rankingView;
    }


    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("problema", problema);

        //Intent intent = new Intent(rankingView.getContext(), RankingActivity.class);
        //intent.putExtras(bundle);

        //rankingView.getContext().startActivity(intent);
    }


}
