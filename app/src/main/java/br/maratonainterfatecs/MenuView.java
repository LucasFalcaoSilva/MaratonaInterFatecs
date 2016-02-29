package br.maratonainterfatecs;

import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by 40312939841 on 29/02/2016.
 */
public interface MenuView {
   void loadComponents();
   void setTituloAba(String titulo);
   void transactionMenu(Fragment fragment);
   void closeMenu();

    Context getContext();
}
