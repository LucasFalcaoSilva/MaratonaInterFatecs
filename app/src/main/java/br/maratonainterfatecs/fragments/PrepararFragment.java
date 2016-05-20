package br.maratonainterfatecs.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import br.maratonainterfatecs.Presenter.PrepararPresenterImp;
import br.maratonainterfatecs.R;
import br.maratonainterfatecs.Task.PrepararTask;
import br.maratonainterfatecs.View.PrepararView;
import br.maratonainterfatecs.typeface.RobotoTypeFace;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Luan on 20/05/2016.
 */
public class PrepararFragment extends Fragment implements PrepararView {

    @Bind(R.id.linear_preparar)
    LinearLayout mLinearPreparar;

    private View view;
    private RobotoTypeFace mRobotoTypeFace;
    private PrepararPresenterImp prepararPresenterImp;

    public static PrepararFragment newInstance() {
        PrepararFragment fragment = new PrepararFragment();
        return fragment;
    }

    public PrepararFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_preparar, container, false);

        ButterKnife.bind(this, view);

        mRobotoTypeFace      = new RobotoTypeFace(view.getContext());
        prepararPresenterImp = new PrepararPresenterImp(this,mRobotoTypeFace);

        new PrepararTask(this, prepararPresenterImp).execute();

        return view;

    }

    @Override
    public void loadView(View result) {
        mLinearPreparar.addView(result, prepararPresenterImp.createParametrosLinear(-1) );
    }

}
