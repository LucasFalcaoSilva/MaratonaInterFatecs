package br.maratonainterfatecs.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.maratonainterfatecs.Domain.Sponsor;
import br.maratonainterfatecs.R;
import butterknife.Bind;
import butterknife.ButterKnife;

public class SponsorActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)        Toolbar   mToolbar;
    @Bind(R.id.iv_logo)        ImageView ivLogo;
    @Bind(R.id.tv_description) TextView  tvDescription;
    @Bind(R.id.btn_site)       Button    btnSite;

    Sponsor sponsor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sponsor);
        ButterKnife.bind(this);

        sponsor = getIntent().getExtras().getParcelable("patrocinador");

        mToolbar.setTitle(sponsor.getNome());
        ivLogo.setImageResource(sponsor.getLogo());
        tvDescription.setText(sponsor.getDescription());

        setSupportActionBar(mToolbar);

        btnSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(sponsor.getUrl()));
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


}
