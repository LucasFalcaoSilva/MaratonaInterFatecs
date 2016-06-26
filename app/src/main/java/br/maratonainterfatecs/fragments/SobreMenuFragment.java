package br.maratonainterfatecs.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.maratonainterfatecs.Adapters.TabsAdapter;
import br.maratonainterfatecs.Extras.SlidingTabLayout;
import br.maratonainterfatecs.R;
import butterknife.Bind;
import butterknife.ButterKnife;

public class SobreMenuFragment extends Fragment {

    @Bind(R.id.vp_tabs)  ViewPager mViewPager;
    @Bind(R.id.stl_tabs) SlidingTabLayout mSlidingTabLayout;

    public SobreMenuFragment() {}

    public static SobreMenuFragment newInstance( ) {
        SobreMenuFragment fragment = new SobreMenuFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sobre_menu, container, false);
        ButterKnife.bind(this, view);

        mViewPager.removeAllViewsInLayout();
        mViewPager.setAdapter(new TabsAdapter(getFragmentManager(), getActivity()));

        mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.primary));
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.accent));
        mSlidingTabLayout.setViewPager(mViewPager);

        return view;
    }
}
