package br.maratonainterfatecs.Listener;

import android.support.design.widget.NavigationView;
import android.view.MenuItem;

import br.maratonainterfatecs.View.MenuView;
import br.maratonainterfatecs.R;
import br.maratonainterfatecs.fragments.ContactFragment;
import br.maratonainterfatecs.fragments.EdicaoFragment;
import br.maratonainterfatecs.fragments.EquipesFragment;
import br.maratonainterfatecs.fragments.HomeFragment;
import br.maratonainterfatecs.fragments.IndisponivelFragment;
import br.maratonainterfatecs.fragments.OrganizacaoFragment;
import br.maratonainterfatecs.fragments.PrepararFragment;
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
                mMenuView.transactionMenu(IndisponivelFragment.newInstance());

                break;
            case R.id.nav_equipes:

                mMenuView.setTituloAba(mMenuView.getContext().getResources().getString(R.string.menu_team));
                mMenuView.transactionMenu(EquipesFragment.newInstance());
                break;
            case R.id.nav_sobre:

                mMenuView.setTituloAba(mMenuView.getContext().getResources().getString(R.string.sobre_formato_regras));
                mMenuView.transactionMenu(SobreFragment.newInstance());

                break;

            case R.id.nav_edicao:

                mMenuView.setTituloAba(mMenuView.getContext().getResources().getString(R.string.sobre_edicoes_anteriores));
                mMenuView.transactionMenu(EdicaoFragment.newInstance());

                break;

            case R.id.nav_preparar:

                mMenuView.setTituloAba(mMenuView.getContext().getResources().getString(R.string.sobre_como_se_preparar));
                mMenuView.transactionMenu(PrepararFragment.newInstance());

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
                mMenuView.setTituloAba("Indisponivel");
                mMenuView.transactionMenu(IndisponivelFragment.newInstance());
        }

        return true;
    }
}
