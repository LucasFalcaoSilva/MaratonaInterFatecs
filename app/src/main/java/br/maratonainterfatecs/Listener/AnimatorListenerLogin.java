package br.maratonainterfatecs.Listener;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

public class AnimatorListenerLogin extends AnimatorListenerAdapter {

    private View    mViewAnimator;
    private Boolean mVisibility;
    private Boolean mInverse;

    public AnimatorListenerLogin(View view){
        this.mViewAnimator = view;
        this.mVisibility  = false;
        this.mInverse       = false;
    }

    public void setVisibility(Boolean visibility){
        this.mVisibility = visibility;
    }

    public void setInverse(Boolean inverse){ this.mInverse = inverse; }

    @Override
    public void onAnimationEnd(Animator animation) {
        if(this.mInverse){
            this.mViewAnimator.setVisibility(mVisibility ?  View.GONE : View.VISIBLE);
        }else{
            this.mViewAnimator.setVisibility(mVisibility ?  View.VISIBLE : View.GONE);
        }
    }
}
