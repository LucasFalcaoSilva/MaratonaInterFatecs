package br.maratonainterfatecs.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import br.maratonainterfatecs.Listener.ListenerMenu;
import br.maratonainterfatecs.View.MenuView;
import br.maratonainterfatecs.R;
import br.maratonainterfatecs.fragments.HomeFragment;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MenuActivity extends AppCompatActivity implements MenuView {

    @Bind(R.id.toolbar)       Toolbar        mToolbar;
    @Bind(R.id.drawer_layout) DrawerLayout   mDrawerMenu;
    @Bind(R.id.nav_view)      NavigationView mNavigationView;

    private ListenerMenu mListenerMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        mListenerMenu = new ListenerMenu(this);
        loadComponents();
    }

    @Override
    public void onBackPressed() {
        if (mDrawerMenu.isDrawerOpen(GravityCompat.START)) {
            closeMenu();
        } else {
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
        setTituloAba(getResources().getString(R.string.menu_home));
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
