package br.maratonainterfatecs;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;

import br.maratonainterfatecs.Listener.AnimatorListenerLogin;
import br.maratonainterfatecs.Listener.EditListener;
import br.maratonainterfatecs.Presenter.LoginPresenterImpl;
import br.maratonainterfatecs.View.LoginComponentsView;
import br.maratonainterfatecs.View.LoginView;
import br.maratonainterfatecs.animacao.AnimationEntradaTela;
import br.maratonainterfatecs.asynctask.UserLoginTask;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity  implements LoginComponentsView,LoginView {

    private LoginPresenterImpl mPresenter     = null;
    private UserLoginTask      mUserLoginTask = null;
    private EditListener       mEditListener  = null;

    @Bind(R.id.email)                AutoCompleteTextView mEmailView;
    @Bind(R.id.password)             EditText mPasswordView;
    @Bind(R.id.login_progress)       View mProgressView;
    @Bind(R.id.login_form)           View mLoginFormView;
    @Bind(R.id.lin_principal)        LinearLayout mLinearPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        mPresenter    = new LoginPresenterImpl(this);
        mEditListener = new EditListener(this);

        mPasswordView.setOnEditorActionListener(mEditListener);

        mLinearPrincipal.startAnimation(new AnimationEntradaTela().getAnimation());

    }

    @Override
    public void initLogin(){
        mUserLoginTask = new UserLoginTask(this,getEmail(),getPassword());
        mUserLoginTask.execute();
    }

    @Override
        public boolean cleanView() {
        mEmailView.setError(null);
        mPasswordView.setError(null);
        return mUserLoginTask != null;
    }

    @Override
    public void outApplication() {
        finish();
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
    }

    @Override
    public void actionApplication() {

        mEmailView.setText("");
        mPasswordView.setText("");

        startActivity(new Intent(this, MenuActivity.class));
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    @Override
    public void showProgress(final Boolean resposta) {

        mUserLoginTask = null;

        mLoginFormView.setVisibility(resposta ? View.GONE : View.VISIBLE);
        mProgressView.setVisibility(resposta ? View.VISIBLE : View.GONE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            AnimatorListenerLogin animatorListenerLogin = new AnimatorListenerLogin(mLoginFormView);
            animatorListenerLogin.setInverse(true);
            animatorListenerLogin.setVisibility(resposta);

            AnimatorListenerLogin animatorListenerLoginProgress = new AnimatorListenerLogin(mLoginFormView);
            animatorListenerLogin.setInverse(false);
            animatorListenerLogin.setVisibility(resposta);

            mLoginFormView.animate().setDuration(shortAnimTime).alpha(resposta ? 0 : 1).setListener(animatorListenerLogin);
            mProgressView.animate().setDuration(shortAnimTime).alpha(resposta ? 1 : 0).setListener(animatorListenerLoginProgress);

        }
    }

    @Override
    public void problemsValidation(Integer field,String text) {
        if (field == USER) {
            mEmailView.setError(text);
            mEmailView.requestFocus();
        }else if (field == PASSWORD) {
            mPasswordView.setError(text);
            mPasswordView.requestFocus();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        outApplication();
    }

    @OnClick(R.id.email_sign_in_button)
    public void submit(View v) {
        mPresenter.validationLogin(getEmail(), getPassword());
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public LoginPresenterImpl getPresenter(){
        return mPresenter;
    }

    @Override
    public String getEmail() {
        return mEmailView.getText().toString();
    }

    @Override
    public String getPassword() {
        return mPasswordView.getText().toString();
    }
}

