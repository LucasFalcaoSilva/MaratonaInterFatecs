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
import br.maratonainterfatecs.typeface.RobotoTypeFace;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Luan on 08/03/2016.
 */
public class ContactFragment extends Fragment {

    @Bind(R.id.text_contato_email_h) TextView mTextEmail;
    @Bind(R.id.text_contato_tel_h) TextView mTextTel;

    private GoogleMap map;
    private SupportMapFragment fragment;

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

        //Cria um Fragmento para o MAPA e seta no container criado no xml
        FragmentManager fm = getChildFragmentManager();
        if (fragment == null) {
            fragment = SupportMapFragment.newInstance();
            fm.beginTransaction().replace(R.id.map_container, fragment).commit();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (map == null) {

            //Ajusta o mapa para a posição da FATEC SP
            LatLng fatec = new LatLng(-23.5296773, -46.6345405);

            map = fragment.getMap();
            map.addMarker(new MarkerOptions().position(fatec).title("Marker in Fatec"));
            map.moveCamera(CameraUpdateFactory.newLatLng(fatec));
            map.animateCamera(CameraUpdateFactory.zoomTo(15));
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        ButterKnife.bind(this, view);

        //Altera os textos do cabeçalho
        mTextEmail.setTypeface(new RobotoTypeFace(view.getContext()).getRobotoBold());
        mTextTel.setTypeface(new RobotoTypeFace(view.getContext()).getRobotoBold());

        return view;
    }

}