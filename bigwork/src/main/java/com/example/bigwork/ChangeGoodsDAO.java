package com.example.bigwork;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ChangeGoodsDAO {
    private DBOpenHelper dbOpenHelper;
    private SQLiteDatabase db;
    public ChangeGoodsDAO(Context context){
        dbOpenHelper=new DBOpenHelper(context);
        db=dbOpenHelper.getWritableDatabase();
    }
    public void add(ChangeGoods cc){
        ContentValues contentValues=new ContentValues();
        contentValues.put("zp",cc.getZp());
        contentValues.put("name",cc.getName());
        contentValues.put("phone",cc.getPhone());
        contentValues.put("introduce",cc.getIntroduce());
        contentValues.put("cheapprice",cc.getCheapprice());
        contentValues.put("changegoods",cc.getChangegoods());
        db.insert("changegoods",null,contentValues);

    }
    public ArrayList<ChangeGoods> getall(){
        ArrayList<ChangeGoods> list =new ArrayList<>();
        Cursor cursor=db.rawQuery("select * from changegoods",null);
        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                ChangeGoods changeGoods=new ChangeGoods();
                changeGoods.setName(cursor.getString(cursor.getColumnIndex("name")));
                changeGoods.setCheapprice(cursor.getString(cursor.getColumnIndex("cheapprice")));
                changeGoods.setChangegoods(cursor.getString(cursor.getColumnIndex("goods")));
                changeGoods.setIntroduce(cursor.getString(cursor.getColumnIndex("introduce")));
                changeGoods.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
                changeGoods.setZp(cursor.getString(cursor.getColumnIndex("zp")));
                list.add(changeGoods);
                cursor.moveToNext();
            }
        }
        return list;
    }
    public void delete(String name){
        db.delete("changegoods","name=?",new String[]{name});

    }
    public ArrayList<ChangeGoods> getone(String name){
        ArrayList<ChangeGoods> list =new ArrayList<>();
        Cursor cursor=db.rawQuery("select * from changegoods where name='"+name+"'",null);
        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                ChangeGoods sg=new ChangeGoods();
                sg.setName(cursor.getString(cursor.getColumnIndex("name")));
                sg.setCheapprice(cursor.getString(cursor.getColumnIndex("cheapprice")));
                sg.setChangegoods(cursor.getString(cursor.getColumnIndex("goods")));
                sg.setIntroduce(cursor.getString(cursor.getColumnIndex("introduce")));
                sg.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
                sg.setZp(cursor.getString(cursor.getColumnIndex("zp")));
                list.add(sg);
                cursor.moveToNext();
            }
        }
        return list;
    }
}
