package com.example.bigwork;

import android.content.Context;

import android.content.SharedPreferences;


public class IsLoginUtil {

    public static void setIsLogin(Context context){
        SharedPreferences sp=context.getSharedPreferences("User", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("islogin","1");
        edit.commit();

    }
    public static String getIsLogin(Context context){
        SharedPreferences sp=context.getSharedPreferences("User", Context.MODE_PRIVATE);
        return sp.getString("islogin","");
    }
    public static void exit(Context context){
        SharedPreferences sp=context.getSharedPreferences("User", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("islogin","2");
        edit.commit();
    }
}
