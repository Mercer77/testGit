package com.example.bigwork;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SecondGoodsFragment extends Fragment {
    ListView listView;
    SimpleAdapter simpleAdapter;
    SecondGoodsDAO sd;
    Context context;
    ArrayList<Map<String, String>> secondgoods;
    DBOpenHelper helper;
    SQLiteDatabase db;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View secondGoodsLayout = inflater.inflate(R.layout.fragment_secondgoods, container, false);
        listView = secondGoodsLayout.findViewById(R.id.Listview_secondgoods);
        context = getActivity();
        sd = new SecondGoodsDAO(context);
         //dbInit();
        secondgoods = getSecondGood();
        simpleAdapter = new SimpleAdapter(context, secondgoods, R.layout.secondgoods_list, new String[]{"zp", "name", "cheapprice", "price"}, new int[]{R.id.img_goods, R.id.name_goods, R.id.text_cheapprice, R.id.text_price});
        listView.setAdapter(simpleAdapter);
   /*    simpleAdapter.setViewBinder(new SimpleAdapter.ViewBinder() {

            public boolean setViewValue(View view, Object data,
                                        String textRepresentation) {
                //判断是否为我们要处理的对象
                if(view instanceof ImageView && data instanceof Object){
                    ImageView iv = (ImageView) view;
                    String s=Environment.getExternalStorageDirectory().getAbsolutePath()+data.toString();
                    iv.setImageURI(Uri.fromFile(new File(s)));
                    return true;
                }else
                    return false;
            }
        });*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (!IsLoginUtil.getIsLogin(context).equals("1")){
                    Toast.makeText(context, "请先登录", Toast.LENGTH_SHORT).show();
                }
                else{
                TextView good = view.findViewById(R.id.name_goods);
                String goodsName = good.getText().toString();
                Intent intent = new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(context, ShowGoods.class);
                bundle.putString("goodsName",goodsName);
                intent.putExtra("bundle", bundle);
                startActivity(intent);
            }
            }

        });
        registerForContextMenu(listView);

        return secondGoodsLayout;
    }

    public ArrayList<Map<String, String>> getSecondGood() {

        ArrayList<Map<String,String>> list = new ArrayList<Map<String, String>>();

        for (int i = 0; i < sd.getall().size(); i++) {
            Map<String, String> map = new HashMap<>();
            map.put("name", sd.getall().get(i).getName());
            map.put("cheapprice", sd.getall().get(i).getCheapprice());
            map.put("price", sd.getall().get(i).getPrice());
            map.put("introduce", sd.getall().get(i).getIntroduce());
            map.put("phone", sd.getall().get(i).getPhone());
            map.put("zp", sd.getall().get(i).getZp());
            list.add(map);
        }
        return list;
    }

   public void dbInit() {
        helper = new DBOpenHelper(context);
        db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", "吉他");
        contentValues.put("cheapprice", "20");
        contentValues.put("price", "70");
        contentValues.put("zp", R.drawable.gitar);
        contentValues.put("phone", "12343433");
        contentValues.put("introduce", "大苏打实打实速度速度收到收到收到收到是滴是滴是滴是滴收到收到");
        db.insert("secondgoods", null, contentValues);
        contentValues.put("name", "钢琴");
        contentValues.put("cheapprice", "40");
        contentValues.put("price", "123");
        contentValues.put("zp", R.drawable.piano);
        contentValues.put("phone", "12343433");
        contentValues.put("introduce", "大苏打实打实速度速度收到收到收到收到是滴是滴是滴是滴收到收到");
        db.insert("secondgoods", null, contentValues);
        contentValues.put("name", "鼓子");
        contentValues.put("cheapprice", "40");
        contentValues.put("price", "223");
        contentValues.put("zp", R.drawable.gu);
        contentValues.put("phone", "12343433");
        contentValues.put("introduce", "大苏打实打实速度速度收到收到收到收到是滴是滴是滴是滴收到收到");
        db.insert("secondgoods", null, contentValues);
       contentValues.put("name", "乐器");
       contentValues.put("cheapprice", "40");
       contentValues.put("price", "223");
       contentValues.put("zp", R.drawable.yueqi);
       contentValues.put("phone", "12343433");
       contentValues.put("introduce", "大苏打实撒大苏打实打实收到收到");
       db.insert("secondgoods", null, contentValues);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("操作");
        menu.add(0,1,1,"不感兴趣");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = ( AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch (item.getItemId()){
            case 1:
                sd.delete(secondgoods.get(menuInfo.position).get("name"));
                secondgoods.remove(menuInfo.position);
                break;
        }

        simpleAdapter.notifyDataSetChanged();
        return super.onContextItemSelected(item);

    }


}
