package br.maratonainterfatecs.animacao;

import android.view.animation.AlphaAnimation;


public class AnimationEntradaTela  {

    //Entrada em segundos
    public AlphaAnimation getAnimation(int time){
        AlphaAnimation animation = new AlphaAnimation(0.0f , 1.0f ) ;
        animation.setFillAfter(true);
        animation.setDuration(time * 1000);
        return animation;
    }

}
