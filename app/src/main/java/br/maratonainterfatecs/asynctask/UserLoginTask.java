package br.maratonainterfatecs.asynctask;

import android.content.Context;
import android.os.AsyncTask;

import java.util.Timer;
import java.util.TimerTask;

import br.maratonainterfatecs.R;
import br.maratonainterfatecs.View.LoginView;

public class UserLoginTask  extends AsyncTask<Void, Void, Boolean> {

    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "lucas@gmail.com:12345", "example@example.com:example"
    };

    private final String    mEmail;
    private final String    mPassword;
    private final LoginView mLoginView;

    public UserLoginTask(LoginView presenter,String email, String password) {
        mLoginView = presenter;
        mEmail     = email;
        mPassword  = password;
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
            mLoginView.outApplication();
        } else {
            mLoginView.problemsValidation(mLoginView.PASSWORD,mLoginView.getContext().getResources().getString(R.string.error_incorrect_password));
        }
    }

    @Override
    protected void onCancelled() {
        mLoginView.showProgress(false);
    }
}