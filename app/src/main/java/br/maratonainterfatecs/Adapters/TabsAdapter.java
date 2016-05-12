package br.maratonainterfatecs.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import br.maratonainterfatecs.R;
import br.maratonainterfatecs.fragments.ContactFragment;
import br.maratonainterfatecs.fragments.EdicaoFragment;
import br.maratonainterfatecs.fragments.SobreFragment;
import br.maratonainterfatecs.fragments.SponsorsFragment;

/**
 * Created by Luan on 07/04/2016.
 */
public class TabsAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private String[] titles = {"FORMATO & REGRAS","EDIÇÕES ANTERIORES","COMO SE PREPARAR"};

    public TabsAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag = null;

        if(position == 0){
            frag = SobreFragment.newInstance();
        }
        else if(position == 1){
            frag = EdicaoFragment.newInstance();
        }
        else if(position == 2){
            frag = new ContactFragment();
        }

        Bundle b = new Bundle();
        b.putInt("position", position);

        frag.setArguments(b);

        return frag;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return ( titles[position] );
    }
}
