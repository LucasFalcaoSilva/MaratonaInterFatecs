package br.maratonainterfatecs.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.maratonainterfatecs.Domain.Sponsor;
import br.maratonainterfatecs.R;

public class SponsorActivity extends AppCompatActivity {

    private Sponsor sponsor;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("sponsor", sponsor);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsor);

        if(savedInstanceState != null){
            sponsor = savedInstanceState.getParcelable("sponsor");
        }
        else {
            if (getIntent() != null && getIntent().getExtras() != null && getIntent().getExtras().getParcelable("sponsor") != null) {
                sponsor = getIntent().getExtras().getParcelable("sponsor");
            } else {
                Toast.makeText(this, "Fail!", Toast.LENGTH_SHORT).show();
                finish();
            }
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView ivLogo       = (ImageView) findViewById(R.id.iv_logo);
        TextView tvNome        = (TextView) findViewById( R.id.tv_nome);
        TextView tvDescription = (TextView) findViewById(R.id.tv_description);

        ivLogo.setImageResource(sponsor.getLogo());
        tvNome.setText(sponsor.getNome());
        tvDescription.setText(sponsor.getDescription());



        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

}
