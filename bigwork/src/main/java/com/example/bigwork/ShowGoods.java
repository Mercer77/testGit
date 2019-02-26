package com.example.bigwork;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowGoods extends AppCompatActivity  {
    SecondGoodsDAO secondGoodsDAO;
    ImageView imgGoods;
    TextView textName;
    TextView textPrice;
    TextView textCheapPrice;
    TextView textIntroduce;
    TextView textPhone;
    Button button;
    ArrayList<SecondGoods> list;
    DBOpenHelper dbOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showgoods);
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("bundle");
        String goodsName=bundle.getString("goodsName");
        secondGoodsDAO=new SecondGoodsDAO(this);
        list=secondGoodsDAO.getone(goodsName);

        imgGoods=findViewById(R.id.imgGoods);
        textName=findViewById(R.id.name);
        textPrice=findViewById(R.id.price);
        textCheapPrice=findViewById(R.id.cheapprice);
        textIntroduce=findViewById(R.id.introduce);
        textPhone=findViewById(R.id.phone);
        button=findViewById(R.id.addCollection);
        imgGoods.setImageResource(Integer.parseInt(list.get(0).getZp()));
        textName.setText(list.get(0).getName());
        textPhone.setText(list.get(0).getPhone());
        textIntroduce.setText(list.get(0).getIntroduce());
        textCheapPrice.setText(list.get(0).getCheapprice());
        textPrice.setText(list.get(0).getPrice());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (IsLoginUtil.getIsLogin(ShowGoods.this).equals("")){
                    Toast.makeText(ShowGoods.this, "请先登录", Toast.LENGTH_SHORT).show();
                }
                else {
                    Collection collection = new Collection();
                    collection.setName(list.get(0).getName());
                    collection.setZp(list.get(0).getZp());
                    collection.setPhone(list.get(0).getPhone());
                    collection.setIntroduce(list.get(0).getIntroduce());
                    collection.setCheapprice(list.get(0).getCheapprice());
                    collection.setPrice(list.get(0).getPrice());
                    CollectionDAO cd = new CollectionDAO(ShowGoods.this);
                    cd.add(collection);
                    Toast.makeText(ShowGoods.this, "已添加至我的收藏", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
