package br.maratonainterfatecs.Listener;

import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import br.maratonainterfatecs.R;
import br.maratonainterfatecs.View.LoginComponentsView;
import br.maratonainterfatecs.View.LoginView;

public class EditListener implements EditText.OnEditorActionListener {

    private final LoginComponentsView mLoginComponentsView;

    public EditListener(LoginComponentsView loginComponentsView){
        this.mLoginComponentsView = loginComponentsView;
    }

    @Override
    public boolean onEditorAction(TextView v, int id, KeyEvent event) {
        if (id == R.id.login || id == EditorInfo.IME_NULL) {
            mLoginComponentsView.getPresenter().validationLogin(mLoginComponentsView.getEmail(),mLoginComponentsView.getPassword());
            return true;
        }
        return false;
    }
}
