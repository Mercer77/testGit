package com.example.bigwork;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class CollectionDAO {
    private DBOpenHelper dbOpenHelper;
    private SQLiteDatabase db;
    public CollectionDAO(Context context){
        dbOpenHelper=new DBOpenHelper(context);
        db=dbOpenHelper.getWritableDatabase();
    }
    public void add(Collection cc){
        ContentValues contentValues=new ContentValues();
        contentValues.put("zp",cc.getZp());
        contentValues.put("name",cc.getName());
        contentValues.put("phone",cc.getPhone());
        contentValues.put("introduce",cc.getIntroduce());
        contentValues.put("cheapprice",cc.getCheapprice());
        contentValues.put("price",cc.getPrice());
        db.insert("collection",null,contentValues);

    }
    public ArrayList<Collection> getall(){
        ArrayList<Collection> list =new ArrayList<>();
        Cursor cursor=db.rawQuery("select * from collection",null);
        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                Collection collection=new Collection();
                collection.setName(cursor.getString(cursor.getColumnIndex("name")));
                collection.setCheapprice(cursor.getString(cursor.getColumnIndex("cheapprice")));
                collection.setPrice(cursor.getString(cursor.getColumnIndex("price")));
                collection.setIntroduce(cursor.getString(cursor.getColumnIndex("introduce")));
                collection.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
                collection.setZp(cursor.getString(cursor.getColumnIndex("zp")));
                list.add(collection);
                cursor.moveToNext();
            }
        }
        return list;
    }
    public void delete(String name){
        db.delete("collection","name=?",new String[]{name});

    }
}
