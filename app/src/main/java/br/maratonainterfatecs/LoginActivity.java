package br.maratonainterfatecs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import br.maratonainterfatecs.Listener.EditListener;
import br.maratonainterfatecs.Presenter.LoginPresenterImpl;
import br.maratonainterfatecs.View.LoginView;
import br.maratonainterfatecs.animacao.AnimationEntradaTela;
import br.maratonainterfatecs.asynctask.UserLoginTask;
import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity  implements LoginView,View.OnClickListener {

    private LoginPresenterImpl mPresenter     = null;
    private UserLoginTask      mUserLoginTask = null;
    private EditListener       mEditListener  = null;

    @Bind(R.id.email_sign_in_button) Button mEmailSignInButton;
    @Bind(R.id.email)                AutoCompleteTextView mEmailView;
    @Bind(R.id.password)             EditText mPasswordView;
    @Bind(R.id.login_progress)       View mProgressView;
    @Bind(R.id.login_form)           View mLoginFormView;
    @Bind(R.id.lin_principal)        LinearLayout mLinearPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        hideStatusBar();

        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        mPresenter    = new LoginPresenterImpl(this);

        mEditListener = new EditListener(this);

        mPasswordView.setOnEditorActionListener(mEditListener);

        mEmailSignInButton.setOnClickListener(this);

        mLinearPrincipal.startAnimation(new AnimationEntradaTela().getAnimation(2));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        outApplication();
    }

    @Override
    public boolean cleanView() {
        mEmailView.setError(null);
        mPasswordView.setError(null);
        return mUserLoginTask != null;
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

    @Override
    public void outApplication() {
        finish();
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    @Override
    public void showProgress(final Boolean resposta) {

        mUserLoginTask = null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(resposta ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(resposta ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(resposta ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(resposta ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(resposta ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(resposta ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            mProgressView.setVisibility(resposta ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(resposta ? View.GONE : View.VISIBLE);
        }
    }

    @Override
    public void hideStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrincipal));
        }else {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
    public void onClick(View v) {
        mPresenter.validationLogin(getEmail(),getPassword());
    }

    @Override
    public void initLogin(){
        mUserLoginTask = new UserLoginTask(this,getEmail(),getPassword());
        mUserLoginTask.execute();
    }
}

