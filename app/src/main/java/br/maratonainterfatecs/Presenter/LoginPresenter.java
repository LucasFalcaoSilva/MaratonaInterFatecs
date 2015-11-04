package br.maratonainterfatecs.Presenter;

public interface LoginPresenter  {
    boolean isPasswordValid(String password);
    boolean isEmailValid(String email);
    void validationLogin(String email,String password);
}
