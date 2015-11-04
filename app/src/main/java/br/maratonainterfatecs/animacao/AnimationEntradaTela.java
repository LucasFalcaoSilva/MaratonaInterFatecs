package br.maratonainterfatecs.animacao;

import android.view.animation.AlphaAnimation;


public class AnimationEntradaTela  {

    public static final int TIME = 1;

    //Entrada em segundos
    public AlphaAnimation getAnimation(){
        AlphaAnimation animation = new AlphaAnimation(0.0f , 1.0f ) ;
        animation.setFillAfter(true);
        animation.setDuration(TIME * 1000);
        return animation;
    }

}
