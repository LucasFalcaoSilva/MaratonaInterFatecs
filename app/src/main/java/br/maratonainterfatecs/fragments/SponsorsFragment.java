package br.maratonainterfatecs.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import br.maratonainterfatecs.R;
import java.util.ArrayList;
import java.util.List;

import br.maratonainterfatecs.Adapters.SponsorAdapter;
import br.maratonainterfatecs.Domain.Sponsor;
import br.maratonainterfatecs.Interfaces.RecyclerViewOnClickListenerHack;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Luan on 15/03/2016.
 */
 public class SponsorsFragment extends Fragment implements RecyclerViewOnClickListenerHack {

    private RecyclerView mRecyclerView;
    private List<Sponsor> mList;

    public static SponsorsFragment newInstance() {
        SponsorsFragment fragment = new SponsorsFragment();
        return fragment;
    }

    public SponsorsFragment() {
    }

    @Override
    public void onClickListener(View view, int position) {

    }

    @Override
    public void onLongPressClickListener(View view, int position) {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
        }

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sponsors, container, false);
        ButterKnife.bind(this, view);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
        //Otimiza - informando que o tamanho do RecyclerView não vai ser alterado
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                /*

                LinearLayoutManager llm = (LinearLayoutManager) mRecyclerView.getLayoutManager();

                SponsorAdapter adapter = (SponsorAdapter) mRecyclerView.getAdapter();

                //Lógica para buscar mais patrocinadores depois que exibir os 3
                if (mList.size() == llm.findLastCompletelyVisibleItemPosition() + 1) {
                    List<Sponsor> listAux = getSetCarList(3);

                    for (int i = 0; i < listAux.size(); i++) {
                        adapter.addListItem(listAux.get(i), mList.size());
                    }

                }*/

            }
        });

        mRecyclerView.addOnScrollListener(new RecyclerViewTouchListener(container.getContext(), mRecyclerView, this));

        // Cria LayouManager
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //Seta LayoutManager dentro do RecyclerView
        mRecyclerView.setLayoutManager(llm);

        mList = getSetCarList(10);
        SponsorAdapter adapter = new SponsorAdapter(getActivity(), mList);

        //Seta o Adapter no Recycler View
        mRecyclerView.setAdapter( adapter );

        //Altera os textos do cabeçalho
        //mTextEmail.setTypeface(new RobotoTypeFace(view.getContext()).getRobotoBold());
        //mTextTel.setTypeface(new RobotoTypeFace(view.getContext()).getRobotoBold());

        return view;
    }

    private List<Sponsor> getSetCarList(int qtd) {

        String[] nomes = new String[]{"Cengage Learning", "Ciee", "IBM"};
        int[] logos = new int[]{R.drawable.logo_cengage_learning, R.drawable.logo_ciee, R.drawable.ibm_logo};
        List<Sponsor> listAux = new ArrayList<>();

        for (int i = 0; i < qtd; i++) {
            Sponsor c = new Sponsor(nomes[i % nomes.length], logos[i % nomes.length]);
            listAux.add(c);
        }
        return (listAux);
    }

    private static class RecyclerViewTouchListener extends RecyclerView.OnScrollListener implements RecyclerView.OnItemTouchListener {
        private Context mContext;
        private GestureDetector mGestureDetector;
        private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;

        public RecyclerViewTouchListener(Context c, final RecyclerView rv, RecyclerViewOnClickListenerHack rvoclh) {
            mContext = c;
            mRecyclerViewOnClickListenerHack = rvoclh;

            mGestureDetector = new GestureDetector(mContext, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public void onLongPress(MotionEvent e) {
                    super.onLongPress(e);

                    View cv = rv.findChildViewUnder(e.getX(), e.getY());

                    if (cv != null && mRecyclerViewOnClickListenerHack != null) {
                        mRecyclerViewOnClickListenerHack.onLongPressClickListener(cv,
                                rv.getChildAdapterPosition(cv));
                    }
                }

                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    View cv = rv.findChildViewUnder(e.getX(), e.getY());

                    if (cv != null && mRecyclerViewOnClickListenerHack != null) {
                        mRecyclerViewOnClickListenerHack.onClickListener(cv,
                                rv.getChildAdapterPosition(cv));
                    }

                    return (true);
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
