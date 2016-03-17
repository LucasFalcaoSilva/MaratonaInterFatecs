package br.maratonainterfatecs.View;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by 40312939841 on 16/03/2016.
 */
public interface ContactView {
    void loadComponents();
    void BuildMap();
    void loadFragment();
    LatLng pontoCentralFatec();
}
