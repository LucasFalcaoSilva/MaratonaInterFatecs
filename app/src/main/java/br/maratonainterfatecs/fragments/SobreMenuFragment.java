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

public class SobreMenuFragment extends Fragment {
    //private OnFragmentInteractionListener mListener;

    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;

    public SobreMenuFragment() {
        // Required empty public constructor
    }

    public static SobreMenuFragment newInstance( ) {
        SobreMenuFragment fragment = new SobreMenuFragment();
        /*Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);*/
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_sobre_menu, container, false);

        //return inflater.inflate(R.layout.fragment_sobre_menu, container, false);

        //TAB
        mViewPager = (ViewPager) view.findViewById(R.id.vp_tabs);
        mViewPager.setAdapter( new TabsAdapter( getFragmentManager(),getActivity() ));
        mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.stl_tabs);
        mSlidingTabLayout.setBackgroundColor( getResources().getColor( R.color.primary ));
        mSlidingTabLayout.setSelectedIndicatorColors( getResources().getColor( R.color.accent ));
        mSlidingTabLayout.setViewPager( mViewPager );

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        } */
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }

}
