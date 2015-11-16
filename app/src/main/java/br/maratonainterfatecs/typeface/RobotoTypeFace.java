package br.maratonainterfatecs.typeface;


import android.content.Context;
import android.graphics.Typeface;

public class RobotoTypeFace  {

    public static final String ROBOTO_REGULAR = "roboto/Roboto-Regular.ttf";
    public static final String ROBOTO_BOLD    = "roboto/Roboto-Bold.ttf";
    public static final String ROBOTO_THIN    = "roboto/Roboto-Thin.ttf";
    public static final String ROBOTO_LIGHT   = "roboto/Roboto-Light.ttf";
    public static final String ROBOTO_MEDIUM  = "roboto/Roboto-Medium.ttf";
    public static final String ROBOTO_BLACK   = "roboto/Roboto-Black.ttf";

    private Context mContext;

    public RobotoTypeFace(Context context){
        this.mContext = context;
    }

    public Typeface getRobotoRegular(){
        return Typeface.createFromAsset(mContext.getAssets(), ROBOTO_REGULAR);
    }

    public Typeface getRobotoBold(){
        return Typeface.createFromAsset(mContext.getAssets(), ROBOTO_BOLD);
    }

    public Typeface getRobotoThin(){
        return Typeface.createFromAsset(mContext.getAssets(), ROBOTO_THIN);
    }

    public Typeface getRobotoLight(){
        return Typeface.createFromAsset(mContext.getAssets(), ROBOTO_LIGHT);
    }

    public Typeface getRobotoMedium(){
        return Typeface.createFromAsset(mContext.getAssets(), ROBOTO_MEDIUM);
    }

    public Typeface getRobotoBlack(){
        return Typeface.createFromAsset(mContext.getAssets(), ROBOTO_BLACK);
    }
}
