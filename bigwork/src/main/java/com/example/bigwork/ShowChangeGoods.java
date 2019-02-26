package com.example.bigwork;

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

public class ShowChangeGoods extends AppCompatActivity  {
    ChangeGoodsDAO changeGoodsDAO;
    ImageView imgGoods;
    TextView textName;
    TextView textChangeGoods;
    TextView textCheapPrice;
    TextView textIntroduce;
    TextView textPhone;
    Button button;
    ArrayList<ChangeGoods> list;
    DBOpenHelper dbOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showchangegoods);
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("bundle");
        String goodsName=bundle.getString("goodsName");
        changeGoodsDAO=new ChangeGoodsDAO(this);
        list=changeGoodsDAO.getone(goodsName);

        imgGoods=findViewById(R.id.imgGoods);
        textName=findViewById(R.id.name);
        textChangeGoods=findViewById(R.id.changegoods);
        textCheapPrice=findViewById(R.id.cheapprice);
        textIntroduce=findViewById(R.id.introduce);
        textPhone=findViewById(R.id.phone);
        button=findViewById(R.id.addCollection);
        imgGoods.setImageResource(Integer.parseInt(list.get(0).getZp()));
        textName.setText(list.get(0).getName());
        textPhone.setText(list.get(0).getPhone());
        textIntroduce.setText(list.get(0).getIntroduce());
        textCheapPrice.setText(list.get(0).getCheapprice());
        textChangeGoods.setText(list.get(0).getChangegoods());

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
