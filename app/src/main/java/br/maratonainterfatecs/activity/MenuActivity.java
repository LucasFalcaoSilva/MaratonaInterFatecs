package br.maratonainterfatecs.activity;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.webkit.WebView;

import br.maratonainterfatecs.Listener.ListenerMenu;
import br.maratonainterfatecs.R;
import br.maratonainterfatecs.View.MenuView;
import br.maratonainterfatecs.fragments.HomeFragment;
import br.maratonainterfatecs.fragments.MapaFragment;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MenuActivity extends AppCompatActivity implements MenuView {

    @Bind(R.id.toolbar)       Toolbar        mToolbar;
    @Bind(R.id.drawer_layout) DrawerLayout   mDrawerMenu;
    @Bind(R.id.nav_view)      NavigationView mNavigationView;

    private ListenerMenu mListenerMenu;
    public static WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
        mListenerMenu = new ListenerMenu(this);
        setTituloAba(getResources().getString(R.string.menu_home));
        setSupportActionBar(mToolbar);
        loadComponents();
    }

    @Override
    public void onBackPressed() {
        if (mDrawerMenu.isDrawerOpen(GravityCompat.START)) {
            closeMenu();
        }else if(wv.canGoBack()){
         wv.goBack();
        }
        else {
            finish();
            overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
        }
    }

    @Override
    public void loadComponents() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerMenu, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerMenu.setDrawerListener(toggle);
        toggle.syncState();
        mNavigationView.setNavigationItemSelectedListener(mListenerMenu);
        transactionMenu(HomeFragment.newInstance());
    }

    @Override
    public void setTituloAba(String titulo) {
        mToolbar.setTitle(titulo);
    }

    @Override
    public void closeMenu(){
        mDrawerMenu.closeDrawer(GravityCompat.START);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void transactionMenu(Fragment fragment) {
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out);
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
