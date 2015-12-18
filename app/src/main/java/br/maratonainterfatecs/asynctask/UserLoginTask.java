package br.maratonainterfatecs.asynctask;

import android.os.AsyncTask;

import br.maratonainterfatecs.LoginActivity;
import br.maratonainterfatecs.View.LoginView;

public class UserLoginTask  extends AsyncTask<Void, Void, Boolean> {

    private final LoginView mLoginView;

    public UserLoginTask(LoginActivity loginActivity) {
        mLoginView = loginActivity;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    protected void onPostExecute(final Boolean success) {

        mLoginView.actionApplication();

    }
}