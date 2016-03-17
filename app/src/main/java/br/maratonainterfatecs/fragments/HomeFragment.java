package br.maratonainterfatecs.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.maratonainterfatecs.R;
import br.maratonainterfatecs.typeface.RobotoTypeFace;
import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment {

    @Bind(R.id.text_home)  TextView  mText_home;
    //@Bind(R.id.image_home) ImageView mImage_home;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    public HomeFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) { }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        mText_home.setTypeface(new RobotoTypeFace(view.getContext()).getRobotoMedium());
        return view;
    }

  }
