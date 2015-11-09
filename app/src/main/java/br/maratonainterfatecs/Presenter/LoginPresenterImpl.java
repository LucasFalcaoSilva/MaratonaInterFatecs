package br.maratonainterfatecs.Presenter;

import android.text.TextUtils;

import br.maratonainterfatecs.LoginActivity;
import br.maratonainterfatecs.R;
import br.maratonainterfatecs.View.LoginComponentsView;
import br.maratonainterfatecs.View.LoginView;

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView           mLoginView;
    private LoginComponentsView mLoginComponentsView;

    public LoginPresenterImpl(LoginActivity loginActivity){
        this.mLoginView            = loginActivity;
        this.mLoginComponentsView  = loginActivity;
    }

    public LoginPresenterImpl(LoginView loginView,LoginComponentsView loginComponentsView){
        this.mLoginView            = loginView;
        this.mLoginComponentsView  = loginComponentsView;
    }

    @Override
    public boolean isEmailValid(String email) { return email.contains("@"); }

    @Override
    public boolean isPasswordValid(String password) {
        return password.trim().length() > 4;
    }

    @Override
    public void validationLogin(String email, String password) {

        if (this.mLoginView.cleanView()) return;

        String  menssage = "";
        Integer tipo    = 0;

        if (TextUtils.isEmpty(email)) {

            tipo = this.mLoginView.USER;
            menssage = this.mLoginComponentsView.getContext().getString(R.string.error_field_required);

        } else if (!this.mLoginComponentsView.getPresenter().isEmailValid(email)) {

            tipo = this.mLoginView.PASSWORD;
            menssage = this.mLoginComponentsView.getContext().getString(R.string.error_invalid_email);

        }else if (!this.mLoginComponentsView.getPresenter().isPasswordValid(password)) {

            tipo = this.mLoginView.PASSWORD;
            menssage = this.mLoginComponentsView.getContext().getString(R.string.error_invalid_password);

        }

        if(!menssage.equals("")) {
            this.mLoginView.problemsValidation(tipo,menssage);
        }else{
            this.mLoginView.showProgress(true);
            this.mLoginView.initLogin();
        }
    }

}
