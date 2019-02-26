package com.example.bigwork;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class SecondGoodsDAO {
    private DBOpenHelper dbOpenHelper;
    private SQLiteDatabase db;
    public SecondGoodsDAO(Context context){
        dbOpenHelper=new DBOpenHelper(context);
        db=dbOpenHelper.getWritableDatabase();
    }
    public void add(SecondGoods cc){
        ContentValues contentValues=new ContentValues();
        contentValues.put("zp",cc.getZp());
        contentValues.put("name",cc.getName());
        contentValues.put("phone",cc.getPhone());
        contentValues.put("introduce",cc.getIntroduce());
        contentValues.put("cheapprice",cc.getCheapprice());
        contentValues.put("price",cc.getPrice());
        db.insert("secondgoods",null,contentValues);

    }
    public ArrayList<SecondGoods> getall(){
        ArrayList<SecondGoods> list =new ArrayList<>();
        Cursor cursor=db.rawQuery("select * from secondgoods",null);
        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                SecondGoods secondGoods=new SecondGoods();
                secondGoods.setName(cursor.getString(cursor.getColumnIndex("name")));
                secondGoods.setCheapprice(cursor.getString(cursor.getColumnIndex("cheapprice")));
                secondGoods.setPrice(cursor.getString(cursor.getColumnIndex("price")));
                secondGoods.setIntroduce(cursor.getString(cursor.getColumnIndex("introduce")));
                secondGoods.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
                secondGoods.setZp(cursor.getString(cursor.getColumnIndex("zp")));
                list.add(secondGoods);
                cursor.moveToNext();
            }
        }
        return list;
    }
    public ArrayList<SecondGoods> getone(String name){
        ArrayList<SecondGoods> list =new ArrayList<>();
        Cursor cursor=db.rawQuery("select * from secondgoods where name='"+name+"'",null);
        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                SecondGoods secondGoods=new SecondGoods();
                secondGoods.setName(cursor.getString(cursor.getColumnIndex("name")));
                secondGoods.setCheapprice(cursor.getString(cursor.getColumnIndex("cheapprice")));
                secondGoods.setPrice(cursor.getString(cursor.getColumnIndex("price")));
                secondGoods.setIntroduce(cursor.getString(cursor.getColumnIndex("introduce")));
                secondGoods.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
                secondGoods.setZp(cursor.getString(cursor.getColumnIndex("zp")));
                list.add(secondGoods);
                cursor.moveToNext();
            }
        }
        return list;
    }
    public void delete(String name){
        db.delete("secondgoods","name=?",new String[]{name});

    }
}
