package br.maratonainterfatecs.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import br.maratonainterfatecs.Presenter.OrganizacaoPresenterImp;
import br.maratonainterfatecs.R;
import br.maratonainterfatecs.Task.OrganizacaoTask;
import br.maratonainterfatecs.View.OrganizacaoView;
import br.maratonainterfatecs.typeface.RobotoTypeFace;
import butterknife.Bind;
import butterknife.ButterKnife;

public class OrganizacaoFragment extends Fragment implements OrganizacaoView {

    @Bind(R.id.linear_organizacao)
    LinearLayout mLinearOrganizacao;

    private View view;
    private RobotoTypeFace mRobotoTypeFace;
    private OrganizacaoPresenterImp organizacaoPresenter;

    public static OrganizacaoFragment newInstance() {
        OrganizacaoFragment fragment = new OrganizacaoFragment();
        return fragment;
    }

    public OrganizacaoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_organizacao, container, false);

        ButterKnife.bind(this, view);

        mRobotoTypeFace      = new RobotoTypeFace(view.getContext());
        organizacaoPresenter = new OrganizacaoPresenterImp(this,mRobotoTypeFace);

        new OrganizacaoTask(this,organizacaoPresenter).execute();

        return view;
    }


    @Override
    public void loadView(View result) {
        mLinearOrganizacao.addView(result, organizacaoPresenter.createParametrosLinear(-1));
    }

    @Override
    public Context getContext() {
        return getActivity();
    }
}
