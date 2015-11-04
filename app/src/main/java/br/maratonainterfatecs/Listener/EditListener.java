package br.maratonainterfatecs.Listener;

import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import br.maratonainterfatecs.R;
import br.maratonainterfatecs.View.LoginView;


public class EditListener implements EditText.OnEditorActionListener {

    private final LoginView mLoginView;

    public EditListener(LoginView loginView){
        this.mLoginView = loginView;
    }

    @Override
    public boolean onEditorAction(TextView v, int id, KeyEvent event) {
        if (id == R.id.login || id == EditorInfo.IME_NULL) {
            mLoginView.getPresenter().validationLogin(mLoginView.getEmail(),mLoginView.getPassword());
            return true;
        }
        return false;
    }
}
