package br.maratonainterfatecs.Presenter;

import android.text.TextUtils;

import br.maratonainterfatecs.R;
import br.maratonainterfatecs.View.LoginView;

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView mLoginView;

    public LoginPresenterImpl(LoginView loginView){ this.mLoginView = loginView; }

    @Override
    public boolean isEmailValid(String email) { return email.contains("@"); }

    @Override
    public boolean isPasswordValid(String password) {
        return password.trim().length() > 4;
    }

    @Override
    public void validationLogin(String email, String password) {

        if (this.mLoginView.cleanView()) return;

        if (TextUtils.isEmpty(email)) {

            this.mLoginView.problemsValidation(this.mLoginView.USER, this.mLoginView.getContext().getString(R.string.error_field_required));

        } else if (!this.mLoginView.getPresenter().isEmailValid(email)) {

            this.mLoginView.problemsValidation(this.mLoginView.PASSWORD,this.mLoginView.getContext().getString(R.string.error_invalid_email));

        }else if (!this.mLoginView.getPresenter().isPasswordValid(password)) {

            this.mLoginView.problemsValidation(this.mLoginView.PASSWORD,this.mLoginView.getContext().getString(R.string.error_invalid_password));
        }else{
            this.mLoginView.showProgress(true);

            this.mLoginView.initLogin();
        }
    }


}
