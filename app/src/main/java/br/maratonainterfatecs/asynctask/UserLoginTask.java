package br.maratonainterfatecs.asynctask;

import android.os.AsyncTask;

import br.maratonainterfatecs.LoginActivity;
import br.maratonainterfatecs.R;
import br.maratonainterfatecs.View.LoginComponentsView;
import br.maratonainterfatecs.View.LoginView;

public class UserLoginTask  extends AsyncTask<Void, Void, Boolean> {

    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "lucas@gmail.com:12345", "example@example.com:example"
    };

    private final String              mEmail;
    private final String              mPassword;
    private final LoginView           mLoginView;
    private final LoginComponentsView mLoginComponentsView;


    public UserLoginTask(LoginActivity loginActivity,String email, String password) {
        mLoginView           = loginActivity;
        mLoginComponentsView = loginActivity;
        mEmail               = email;
        mPassword            = password;
    }

    public UserLoginTask(LoginView presenter,LoginComponentsView loginComponentsView,String email, String password) {
        mLoginView           = presenter;
        mLoginComponentsView = loginComponentsView;
        mEmail               = email;
        mPassword            = password;
    }

    @Override
    protected Boolean doInBackground(Void... params) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (String credential : DUMMY_CREDENTIALS) {
            String[] pieces = credential.split(":");

            if (pieces[0].equals(mEmail) && pieces[1].equals(mPassword))
                return true;
        }

        return false;
    }

    @Override
    protected void onPostExecute(final Boolean success) {

        mLoginView.showProgress(false);

        if (success) {
            mLoginView.actionApplication();
        } else {
            mLoginView.problemsValidation(mLoginView.PASSWORD,mLoginComponentsView.getContext().getResources().getString(R.string.error_incorrect_password));
        }
    }

    @Override
    protected void onCancelled() {
        mLoginView.showProgress(false);
    }
}