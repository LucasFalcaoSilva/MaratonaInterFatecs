package br.maratonainterfatecs.fragments;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;

import br.maratonainterfatecs.R;
import br.maratonainterfatecs.typeface.RobotoTypeFace;
import butterknife.Bind;
import butterknife.ButterKnife;

public class OrganizacaoFragment extends Fragment {

    @Bind(R.id.linear_organizacao)
    LinearLayout mLinearOrganizacao;

    private static final String TAG = "Organizacao";
    private View view;
    private RobotoTypeFace mRobotoTypeFace;

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

        mRobotoTypeFace = new RobotoTypeFace(view.getContext());

        new viewTask().execute();

        return view;
    }

    public LinearLayout.LayoutParams createParametrosLinear(int margin) {

        LinearLayout.LayoutParams lp;

        lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1);

        if (margin != -1)
            lp.setMargins(margin, margin, margin, margin);

        return lp;
    }

    private LinearLayout builderTabs() throws Exception {

        JSONArray jsonConfig = new JSONArray(rawResourceToString(getActivity()));
        LinearLayout linearPrincipal = new LinearLayout(getActivity());
        linearPrincipal.setOrientation(LinearLayout.VERTICAL);

        for (int i = 0, size = jsonConfig.length(); i < size; i++) {
            JSONObject myObject = jsonConfig.getJSONObject(i);

            LinearLayout linearLayout = new LinearLayout(getActivity());
            linearLayout.setOrientation(LinearLayout.VERTICAL);

            TextView txtTiulo = new TextView(getActivity());
            txtTiulo.setText(myObject.getString("titulo"));
            txtTiulo.setTypeface(mRobotoTypeFace.getRobotoBlack());

            linearLayout.addView(txtTiulo);

            JSONArray itensArray = myObject.getJSONArray("itens");

            for (int j = 0; j < itensArray.length(); j++) {

                LinearLayout linearNomes = new LinearLayout(getActivity());
                linearNomes.setOrientation(LinearLayout.VERTICAL);

                JSONObject item = itensArray.getJSONObject(j);

                TextView txtNome = new TextView(getActivity());
                txtNome.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                txtNome.setText(item.getString("nome"));
                txtNome.setTypeface(mRobotoTypeFace.getRobotoMedium());

                TextView txtFatec = new TextView(getActivity());
                txtNome.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                txtFatec.setText(item.getString("fatec"));
                txtFatec.setTypeface(mRobotoTypeFace.getRobotoMedium());

                linearNomes.addView(txtNome);
                linearNomes.addView(txtFatec);

                linearLayout.addView(linearNomes, createParametrosLinear(5));
            }

            linearPrincipal.addView(linearLayout, createParametrosLinear(-1));

        }
        return linearPrincipal;
    }

    public String rawResourceToString(Context context) {
        byte[] buffer = null;
        InputStream is = null;
        try {
            is = context.getAssets().open("json/json_organizacao.txt");

            buffer = new byte[is.available()];
            while (is.read(buffer) != -1) ;
        } catch (Exception e) {
            buffer = new byte[2];
        } finally {
            try {
                if (is == null) {
                    is.close();
                }
            } catch (Exception e) {
                Log.d(TAG, "Erro ao Fechar Sream: " + e.toString());
            }
        }

        return new String(buffer);

    }

    private class viewTask extends AsyncTask<Void, Void, LinearLayout> {

        @Override
        protected LinearLayout doInBackground(Void... params) {
            try {
                return builderTabs();
            } catch (Exception e) {
                Log.d(TAG, e.toString());
                return null;
            }
        }

        @Override
        protected void onPostExecute(LinearLayout result) {
            mLinearOrganizacao.addView(result, createParametrosLinear(-1));
        }
    }
}
