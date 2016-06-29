package br.maratonainterfatecs.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.maratonainterfatecs.Domain.Times;
import br.maratonainterfatecs.R;

/**
 * Created by Lucas Falcao on 28/06/2016.
 */
public class TimesAdapter extends BaseAdapter {

    private List<Times> times;
    private LayoutInflater mInflater;

    public TimesAdapter(Context context, List<Times> times){
       this.times = times;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return times.size();
    }

    @Override
    public Times getItem(int position) {
        return times.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ItemSuporte itemHolder;
        if (view == null) {
            view = mInflater.inflate(R.layout.item_list, null);

            itemHolder = new ItemSuporte();
            itemHolder.text_Acertos     = ((TextView) view.findViewById(R.id.textAcertos));
            itemHolder.text_Classificao = ((TextView) view.findViewById(R.id.textClassificado));
            itemHolder.text_Nome        = ((TextView) view.findViewById(R.id.textEquipe));
            itemHolder.text_Posicao     = ((TextView) view.findViewById(R.id.textPosicao));
            itemHolder.text_Tempo       = ((TextView) view.findViewById(R.id.textTempo));

            view.setTag(itemHolder);
        } else {
            itemHolder = (ItemSuporte) view.getTag();
        }

        Times item = times.get(position);
        itemHolder.text_Nome.setText(item.getNomeEquipe());
        itemHolder.text_Acertos.setText(String.valueOf(item.getProblemasAcertados().split(",").length));
        itemHolder.text_Tempo.setText(item.getTempo());
        itemHolder.text_Posicao.setText(item.getPosicaoEquipe().toString());
        //itemHolder.text_Classificao.setText(item.isClassificado()? "SIM": "NÃO");

        return view;
    }
    private class ItemSuporte {
        TextView  text_Posicao;
        TextView  text_Nome;
        TextView  text_Acertos;
        TextView  text_Tempo;
        TextView  text_Classificao;
        ImageView image_detalhes;
    }
}
