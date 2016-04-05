package br.maratonainterfatecs.holder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.maratonainterfatecs.Domain.Sponsor;
import br.maratonainterfatecs.R;
import br.maratonainterfatecs.View.SponsorsView;
import br.maratonainterfatecs.activity.SponsorActivity;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 40312939841 on 22/03/2016.
 */
public class PatrocinadorHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @Bind(R.id.iv_logo) public ImageView ivLogo;
    @Bind(R.id.tv_nome) public TextView tvNome;

    SponsorsView sponsorsView;

    public PatrocinadorHolder(SponsorsView sponsorsView,View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);

        itemView.setOnClickListener(this);

        this.sponsorsView = sponsorsView;
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(sponsorsView.getContext(), SponsorActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("nome", (String) tvNome.getText());
        intent.putExtras(bundle);
        sponsorsView.getContext().startActivity(intent);

        /*Toast.makeText(sponsorsView.getContext(), "CLick no item: " + tvNome.getText(), Toast.LENGTH_LONG).show();*/
    }

}
