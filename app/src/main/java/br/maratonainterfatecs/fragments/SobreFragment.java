package br.maratonainterfatecs.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import br.maratonainterfatecs.Presenter.SobrePresenterImp;
import br.maratonainterfatecs.R;
import br.maratonainterfatecs.Task.SobreTask;
import br.maratonainterfatecs.View.SobreView;
import br.maratonainterfatecs.typeface.RobotoTypeFace;
import butterknife.Bind;
import butterknife.ButterKnife;

public class SobreFragment extends Fragment implements SobreView{

    @Bind(R.id.linear_sobre)
    LinearLayout mLinearSobre;

    private View view;
    private RobotoTypeFace mRobotoTypeFace;
    private SobrePresenterImp sobrePresenter;

    public static SobreFragment newInstance() {
        SobreFragment fragment = new SobreFragment();
        return fragment;
    }

    public SobreFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sobre, container, false);

        ButterKnife.bind(this, view);

        mRobotoTypeFace      = new RobotoTypeFace(view.getContext());
        sobrePresenter       = new SobrePresenterImp(this, mRobotoTypeFace);

        new SobreTask(this,sobrePresenter).execute();

        return view;

    }

    @Override
    public void loadView(View result) {
        mLinearSobre.addView(result, sobrePresenter.createParametrosLinear(-1));
    }

}
