package br.maratonainterfatecs.Listener;

import android.support.design.widget.NavigationView;
import android.view.MenuItem;

import br.maratonainterfatecs.View.MenuView;
import br.maratonainterfatecs.R;
import br.maratonainterfatecs.fragments.ContactFragment;
import br.maratonainterfatecs.fragments.HomeFragment;
import br.maratonainterfatecs.fragments.OrganizacaoFragment;
import br.maratonainterfatecs.fragments.SobreFragment;
import br.maratonainterfatecs.fragments.SponsorsFragment;

/**
 * Created by 40312939841 on 29/02/2016.
 */
public class ListenerMenu implements NavigationView.OnNavigationItemSelectedListener  {

    private MenuView mMenuView;

    public ListenerMenu(MenuView menuView){
        this.mMenuView = menuView;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        item.setChecked(true);

        mMenuView.closeMenu();

        switch (item.getItemId()){
            case R.id.nav_home:

                mMenuView.setTituloAba(mMenuView.getContext().getResources().getString(R.string.menu_home));
                mMenuView.transactionMenu(HomeFragment.newInstance());

                break;
            case R.id.nav_mapa:

                mMenuView.setTituloAba(mMenuView.getContext().getResources().getString(R.string.menu_map_event));

                break;
            case R.id.nav_equipes:

                mMenuView.setTituloAba(mMenuView.getContext().getResources().getString(R.string.menu_team));

                break;
            case R.id.nav_evento:

                mMenuView.setTituloAba(mMenuView.getContext().getResources().getString(R.string.menu_sobre));
                mMenuView.transactionMenu(SobreFragment.newInstance());

                break;
            case R.id.nav_patrocinador:

                mMenuView.setTituloAba(mMenuView.getContext().getResources().getString(R.string.menu_patroci));
                mMenuView.transactionMenu(SponsorsFragment.newInstance());

                break;
            case R.id.nav_organizacao:

                mMenuView.setTituloAba(mMenuView.getContext().getResources().getString(R.string.menu_organizacao));
                mMenuView.transactionMenu(OrganizacaoFragment.newInstance());

                break;
            case R.id.nav_contato:

                mMenuView.setTituloAba(mMenuView.getContext().getResources().getString(R.string.menu_contato));
                mMenuView.transactionMenu(ContactFragment.newInstance());

                break;
            default:
        }

        return true;
    }
}
