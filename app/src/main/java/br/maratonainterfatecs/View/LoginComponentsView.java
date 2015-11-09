package br.maratonainterfatecs.View;

import android.content.Context;

import br.maratonainterfatecs.Presenter.LoginPresenterImpl;

public interface LoginComponentsView {
    String             getEmail();
    String             getPassword();
    Context            getContext();
    LoginPresenterImpl getPresenter();
}
