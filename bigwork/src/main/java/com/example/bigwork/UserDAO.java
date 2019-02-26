package com.example.bigwork;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class UserDAO {
    private DBOpenHelper dbOpenHelper;
    private SQLiteDatabase db;
    public UserDAO(Context context){
        dbOpenHelper=new DBOpenHelper(context);
        db=dbOpenHelper.getWritableDatabase();
    }
    public void add(User cc){
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",cc.getUsername());
        contentValues.put("password",cc.getPassword());
        db.insert("user",null,contentValues);

    }
    public ArrayList<User> getall(){
        ArrayList<User> list =new ArrayList<>();
        Cursor cursor=db.rawQuery("select * from user",null);
        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                User user=new User();
                user.setUsername(cursor.getString(cursor.getColumnIndex("username")));
                user.setPassword(cursor.getString(cursor.getColumnIndex("password")));
                list.add(user);
                cursor.moveToNext();
            }
        }
        return list;
    }


}
