package br.maratonainterfatecs.typeface;


import android.content.Context;
import android.graphics.Typeface;

public class RobotoTypeFace  {

    public static final String ROBOTO_REGULAR = "roboto/Roboto-Regular.ttf";
    public static final String ROBOTO_BOLD    = "roboto/Roboto-Bold.ttf";
    public static final String ROBOTO_THIN    = "roboto/Roboto-Thin.ttf";

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
}
