package com.soleimanian.mohsen.clock;

import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferencesMnager{

    private static MySharedPreferencesMnager mySharedPreferencesMnager = null;

    private SharedPreferences sharedPreferences = null ;
    private SharedPreferences.Editor editor = null ;

    private MySharedPreferencesMnager (Context context){
        sharedPreferences = context.getSharedPreferences("My_SharedPreferences" , Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static MySharedPreferencesMnager getInstance(Context context) {
        if (mySharedPreferencesMnager == null) {
            return new MySharedPreferencesMnager(context);
        }
        return mySharedPreferencesMnager;
    }
    public void putSwitchState(boolean state){
        editor.putBoolean("switch_state" , state );
        editor.apply();
    }
    public boolean getSwitchState(){
        return sharedPreferences.getBoolean("switch_state" , false );
    }
}
