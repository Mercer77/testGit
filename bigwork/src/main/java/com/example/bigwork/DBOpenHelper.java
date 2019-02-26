package com.example.bigwork;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {
    private static  int VERSION=2;
    private  static final String DBNAME="user.db";
    public DBOpenHelper(Context context){
        super(context,DBNAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table collection(name varchar(20) primary key ,cheapprice varchar(20),price varchar(20),introduce varchar(100),phone varchar(20),zp varchar(100))");
        db.execSQL("create table user(username varchar(20) primary key ,password varchar(20))");
        db.execSQL("create table secondgoods(name varchar(20) primary key ,cheapprice varchar(20),price varchar(20),introduce varchar(100),phone varchar(20),zp varchar(100))");
        db.execSQL("create table news(title varchar(20) primary key ,content varchar(20),time varchar(20))");
        db.execSQL("create table changegoods(name varchar(20) primary key ,cheapprice varchar(20),goods varchar(20),introduce varchar(100),phone varchar(20),zp varchar(100))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
