package com.adrena.basearchitect.core.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.adrena.basearchitect.BaseArchitectApplication;

public class Preferences {

    private static final String TAG = "com.adrena.basearchitect";
    private static final String BUDGET_AVG = TAG + "_BUDGET_AVG";
    private final Context context;

    Preferences(Context ctx) {
        context = ctx;
    }

    //----------------------------- Set Preferences ---------------------------------------------

    public void setAVG(String data){
        setValue(context, BUDGET_AVG, data);
    }

    //----------------------------- Get Preferences ---------------------------------------------

    public String getAVG(){
        return getStringValue(context, BUDGET_AVG, "1");
    }

    /*---------------------------------------------------------------------------*/

    private static void setValue(Context ctx, String key, String value){
        SharedPreferences prefs = getPreferences(ctx);
        prefs.edit().putString(key, value).apply();
    }

    private static void setValue(Context ctx, String key, int value){
        SharedPreferences prefs = getPreferences(ctx);
        prefs.edit().putInt(key, value).apply();
    }

    private static String getStringValue(Context ctx, String key, String value){
        SharedPreferences prefs = getPreferences(ctx);
        return prefs.getString(key, value);
    }
    private static int getIntValue(Context ctx, String key, int value){
        SharedPreferences prefs = getPreferences(ctx);
        return prefs.getInt(key, value);
    }

    private static SharedPreferences getPreferences(Context ctx){
        return ctx.getSharedPreferences(TAG, Context.MODE_PRIVATE);
    }

}
