package br.maratonainterfatecs.View;

import android.content.Context;

import br.maratonainterfatecs.Presenter.LoginPresenterImpl;

public interface LoginView {

    Integer USER     = 1;
    Integer PASSWORD = 2;

    void initLogin();
    void outApplication();
    void showProgress(Boolean resposta);
    void hideStatusBar();
    void problemsValidation(Integer field,String text);
    boolean cleanView();
    Context getContext();
    LoginPresenterImpl getPresenter();
    String getEmail();
    String getPassword();
}
