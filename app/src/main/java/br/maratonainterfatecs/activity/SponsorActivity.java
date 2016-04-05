package br.maratonainterfatecs.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.maratonainterfatecs.Domain.Sponsor;
import br.maratonainterfatecs.R;

public class SponsorActivity extends AppCompatActivity {

    private Sponsor sponsor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsor);

        /*if(savedInstanceState != null){
            sponsor = savedInstanceState.getParcelable("sponsor");
        }
        else {

            if (getIntent() == null){
                Toast.makeText(this, "getIntent null", Toast.LENGTH_LONG).show();
            }
            if (getIntent().getExtras() == null){
                Toast.makeText(this, "getExtras null", Toast.LENGTH_LONG).show();
            }
            if (getIntent().getExtras().getParcelable("sponsor") == null){
                Toast.makeText(this, "getParcelablenull", Toast.LENGTH_LONG).show();
            }

            if (getIntent() != null && getIntent().getExtras() != null && getIntent().getExtras().getParcelable("sponsor") != null) {
                sponsor = getIntent().getExtras().getParcelable("sponsor");
            } else {
                Toast.makeText(this, "Fail!", Toast.LENGTH_SHORT).show();
                finish();
            }
        }*/

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView ivLogo       = (ImageView) findViewById(R.id.iv_logo);
        TextView tvNome        = (TextView) findViewById( R.id.tv_nome);
        TextView tvDescription = (TextView) findViewById(R.id.tv_description);

        Bundle bundle = getIntent().getExtras();
        tvNome.setText(bundle.getString("nome"));



        //Toast.makeText(this, sponsor.getNome(), Toast.LENGTH_SHORT).show();

        //ivLogo.setImageResource(sponsor.getLogo());
        //tvNome.setText(sponsor.getNome());
        //tvDescription.setText(sponsor.getDescription());

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.putParcelable("sponsor", sponsor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home ){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
