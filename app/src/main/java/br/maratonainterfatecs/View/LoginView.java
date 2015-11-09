package br.maratonainterfatecs.View;

public interface LoginView {

    Integer USER     = 1;
    Integer PASSWORD = 2;

    void initLogin();
    void outApplication();
    void actionApplication();
    void showProgress(Boolean resposta);
    void problemsValidation(Integer field,String text);
    boolean cleanView();
}
