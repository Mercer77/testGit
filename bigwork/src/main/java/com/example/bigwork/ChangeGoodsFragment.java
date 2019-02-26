package com.example.bigwork;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChangeGoodsFragment extends Fragment {
    SimpleAdapter simpleAdapter;
    ListView listView;
    ArrayList<Map<String,Object>> list;
    ChangeGoods changeGoods;
    ChangeGoodsDAO changeGoodsDAO;
    DBOpenHelper helper;
    SQLiteDatabase database;
    Context context;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_changegoods,container,false);
        listView=view.findViewById(R.id.Listview_changegoods);
        context=getActivity();
        //dbInit();
        changeGoodsDAO=new ChangeGoodsDAO(context);
        list=getList();
        simpleAdapter=new SimpleAdapter(context,list,R.layout.changegoods_list,new String[]{"zp","name","cheapprice","goods"},new int[]{R.id.img_goods,R.id.name_goods,R.id.text_cheapprice,R.id.text_goods});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView good = view.findViewById(R.id.name_goods);
                String goodsName = good.getText().toString();
                Intent intent = new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(context, ShowChangeGoods.class);
                bundle.putString("goodsName",goodsName);
                intent.putExtra("bundle", bundle);
                startActivity(intent);
            }
        });
        return view;
    }

    public ArrayList<Map<String, Object>> getList() {
        ArrayList<Map<String,Object>> list = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < changeGoodsDAO.getall().size(); i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", changeGoodsDAO.getall().get(i).getName());
            map.put("cheapprice", changeGoodsDAO.getall().get(i).getCheapprice());
            map.put("goods", changeGoodsDAO.getall().get(i).getChangegoods());
            map.put("introduce", changeGoodsDAO.getall().get(i).getIntroduce());
            map.put("phone", changeGoodsDAO.getall().get(i).getPhone());
            map.put("zp", changeGoodsDAO.getall().get(i).getZp());
            list.add(map);
        }
        return list;

    }
    public void dbInit() {
        helper = new DBOpenHelper(context);
        database = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", "吉他");
        contentValues.put("cheapprice", "20");
        contentValues.put("goods", "耳机");
        contentValues.put("zp", R.drawable.gitar);
        contentValues.put("phone", "12343433");
        contentValues.put("introduce", "大苏打实打实速度速度收到收到收到收到是滴是滴是滴是滴收到收到");
        database.insert("changegoods", null, contentValues);
        contentValues.put("name", "钢琴");
        contentValues.put("cheapprice", "40");
        contentValues.put("goods", "电脑");
        contentValues.put("zp", R.drawable.piano);
        contentValues.put("phone", "12343433");
        contentValues.put("introduce", "大苏打实打实速度速度收到收到收到收到是滴是滴是滴是滴收到收到");
        database.insert("changegoods", null, contentValues);
        contentValues.put("name", "鼓子");
        contentValues.put("cheapprice", "40");
        contentValues.put("goods", "苹果");
        contentValues.put("zp", R.drawable.gu);
        contentValues.put("phone", "12343433");
        contentValues.put("introduce", "大苏打实打实速度速度收到收到收到收到是滴是滴是滴是滴收到收到");
        database.insert("changegoods", null, contentValues);
    }
}
