package br.maratonainterfatecs.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import br.maratonainterfatecs.Presenter.EdicaoPresenterImp;
import br.maratonainterfatecs.R;
import br.maratonainterfatecs.Task.EdicaoTask;
import br.maratonainterfatecs.View.EdicaoView;
import br.maratonainterfatecs.typeface.RobotoTypeFace;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Falcao on 10/05/2016.
 */
public class EdicaoFragment extends Fragment implements EdicaoView {

    @Bind(R.id.linear_edicao)
    LinearLayout mLinearEdicao;

    private RobotoTypeFace     mRobotoTypeFace;
    private EdicaoPresenterImp mEdicaoPresenterImp;

    private View view;

    public static EdicaoFragment newInstance() {
        EdicaoFragment fragment = new EdicaoFragment();
        return fragment;
    }

    public EdicaoFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_edicao, container, false);

        ButterKnife.bind(this, view);

        mRobotoTypeFace      = new RobotoTypeFace(view.getContext());
        mEdicaoPresenterImp  = new EdicaoPresenterImp(this,mRobotoTypeFace);

        new EdicaoTask(this,mEdicaoPresenterImp).execute();

        return view;

    }

    @Override
    public void loadView(View result) {
        mLinearEdicao.addView(result, mEdicaoPresenterImp.createParametrosLinear(-1));
    }

    @Override
    public Context getContext() {
        return getActivity();
    }
}
