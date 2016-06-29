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

import br.maratonainterfatecs.Domain.Times;
import br.maratonainterfatecs.R;
import br.maratonainterfatecs.holder.RankingHolder;
import br.maratonainterfatecs.holder.TimesHolder;
import br.maratonainterfatecs.typeface.RobotoTypeFace;
import butterknife.Bind;

/**
 * Created by Lucas Falcao on 28/06/2016.
 */
public class TimesAdapter extends  RecyclerView.Adapter<TimesHolder> {

    private List<Times> times;
    private Context context;
    private LayoutInflater mInflater;

    public TimesAdapter(Context context, List<Times> times){
       this.times     = times;
       this.context   = context;
       this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public TimesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_list, parent, false);
        return new TimesHolder(view);
    }

    @Override
    public void onBindViewHolder(TimesHolder itemHolder, int position) {
        Times item = times.get(position);
        itemHolder.text_Nome.setText(item.getNomeEquipe());
        itemHolder.text_Nome.setTypeface(new RobotoTypeFace(context).getRobotoBold());
        itemHolder.text_Acertos.setText(String.valueOf(item.getProblemasAcertados().split(",").length));
        itemHolder.text_Acertos.setTypeface(new RobotoTypeFace(context).getRobotoMedium());
        itemHolder.text_Tempo.setText(item.getTempo().toString());
        itemHolder.text_Tempo.setTypeface(new RobotoTypeFace(context).getRobotoMedium());
        itemHolder.text_Posicao.setText(item.getPosicaoEquipe().toString());
        itemHolder.text_Posicao.setTypeface(new RobotoTypeFace(context).getRobotoMedium());
        itemHolder.text_Classificao.setText(item.isClassificado() ? "Sim" : "Não");
        itemHolder.text_Classificao.setTypeface(new RobotoTypeFace(context).getRobotoMedium());
        itemHolder.text_Fatec.setText(item.getNomeFatec());
        itemHolder.text_Fatec.setTypeface(new RobotoTypeFace(context).getRobotoMedium());
    }

    @Override
    public int getItemCount() {
        return times.size();
    }

}
