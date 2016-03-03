package br.maratonainterfatecs.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.maratonainterfatecs.R;
import br.maratonainterfatecs.typeface.RobotoTypeFace;
import butterknife.Bind;
import butterknife.ButterKnife;

public class OrganizacaoFragment extends Fragment {

    @Bind(R.id.text_coordenacao) TextView mTextCoordenacao;

    public static OrganizacaoFragment newInstance() {
        OrganizacaoFragment fragment = new OrganizacaoFragment();
        return fragment;
    }

    public OrganizacaoFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_organizacao, container, false);
        ButterKnife.bind(this,view);

        mTextCoordenacao.setTypeface(new RobotoTypeFace(view.getContext()).getRobotoMedium());

        return view;
    }

}
