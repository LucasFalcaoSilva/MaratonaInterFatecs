package br.maratonainterfatecs.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import br.maratonainterfatecs.R;
import br.maratonainterfatecs.View.ContactView;
import br.maratonainterfatecs.Constants.ConstantsMenus;
import br.maratonainterfatecs.typeface.RobotoTypeFace;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Luan on 08/03/2016.
 */
public class ContactFragment extends Fragment implements ContactView {

    @Bind(R.id.text_contato_email_h) TextView mTextEmail;
    @Bind(R.id.text_contato_tel_h) TextView mTextTel;

    private GoogleMap map;
    private SupportMapFragment fragment;
    private RobotoTypeFace mRobotoTypeFace;

    public static ContactFragment newInstance() {
        ContactFragment fragment = new ContactFragment();
        return fragment;
    }

    public ContactFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
        }

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (fragment == null) {
            loadFragment();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (map == null) {
            BuildMap();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        ButterKnife.bind(this, view);

        mRobotoTypeFace = new RobotoTypeFace(view.getContext());

        loadComponents();

        return view;
    }

    @Override
    public void loadComponents() {
        //Altera os textos do cabeçalho
        mTextEmail.setTypeface(mRobotoTypeFace.getRobotoBold());
        mTextTel.setTypeface(mRobotoTypeFace.getRobotoBold());
    }

    @Override
    public void BuildMap() {
        map = fragment.getMap();
        map.addMarker(new MarkerOptions().position(pontoCentralFatec()).title(ConstantsMenus.TITULO_PONTO));
        map.moveCamera(CameraUpdateFactory.newLatLng(pontoCentralFatec()));
        map.animateCamera(CameraUpdateFactory.zoomTo(15));
    }

    @Override
    public void loadFragment() {
        //Cria um Fragmento para o MAPA e seta no container criado no xml
        FragmentManager fm = getChildFragmentManager();
        fragment = SupportMapFragment.newInstance();
        fm.beginTransaction().replace(R.id.map_container, fragment).commit();
    }

    @Override
    public LatLng pontoCentralFatec() {
        return new LatLng(ConstantsMenus.LATITUDE, ConstantsMenus.LONGITUDE);
    }
}