package br.maratonainterfatecs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import br.maratonainterfatecs.View.LoginView;
import br.maratonainterfatecs.animacao.AnimationEntradaTela;
import br.maratonainterfatecs.asynctask.UserLoginTask;
import br.maratonainterfatecs.progressComponent.WaveLoadingView;
import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity  implements LoginView {

    private UserLoginTask mUserLoginTask;
    private boolean       mInicia;

    @Bind(R.id.login_progress)  WaveLoadingView mProgressView;
    @Bind(R.id.lin_principal)   LinearLayout mLinearPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        mLinearPrincipal.startAnimation(new AnimationEntradaTela().getAnimation());

        mProgressView.setTextoExibicao("INTERFATECS");

        mInicia = true;

    }

    @Override
    public void initLogin() {
        mUserLoginTask = new UserLoginTask(this);
        mUserLoginTask.execute();
    }

    @Override
    public void outApplication() {
        mInicia = false;
        finish();
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
        //android.os.Process.killProcess(android.os.Process.myPid());
    }

    @Override
    public void actionApplication() {
        if (mInicia) {
            startActivity(new Intent(this, MenuActivity.class));
            overridePendingTransition(R.anim.abc_slide_out_top, R.anim.abc_slide_in_top);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        outApplication();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initLogin();
    }

}

