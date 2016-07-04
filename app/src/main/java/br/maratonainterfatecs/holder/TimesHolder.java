package br.maratonainterfatecs.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.maratonainterfatecs.R;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 40312939841 on 29/06/2016.
 */
public class TimesHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @Bind(R.id.textAcertos)      public TextView text_Acertos;
    @Bind(R.id.textEquipe)       public TextView text_Nome;
    @Bind(R.id.textClassificado) public TextView text_Classificao;
    @Bind(R.id.textPosicao)      public TextView text_Posicao;
    @Bind(R.id.textTempo)        public TextView text_Tempo;
    @Bind(R.id.textFatec)        public TextView text_Fatec;
    public TimesHolder(View itemView){
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

}
