package com.example.bigwork;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //tab导航

    //三个顶部导航栏 fragment

    //三个底部导航栏fragment
     TopFragment topFragment;
     SettingFragment settingFragment;
     NewsFragment newsFragment;
    //三个导航栏布局
     View Actionbar1layout;
     View Actionbar2layout;
     View Actionbar3layout;
    //三个布局所在图片文本
     ImageView img1;
     ImageView img2;
     ImageView img3;
     TextView text1;
     TextView text2;
     TextView text3;
    FragmentManager fragmentManager;
     DBOpenHelper helper;
    @Override
    protected void onDestroy() {
        super.onDestroy();
        IsLoginUtil.exit(MainActivity.this);
    }
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom);
        helper=new DBOpenHelper(MainActivity.this);
        helper.getWritableDatabase();
        bottomInit();
        setTabSelection(0);

    }
    /*public void topInit(){
        LayoutInflater layoutInflater=LayoutInflater.from(MainActivity.this);
        final View Topview=layoutInflater.inflate(R.layout.top,null);
        tabLayout=Topview.findViewById(R.id.tab_layout);
        viewPager=Topview.findViewById(R.id.viewpage_layout);
        fragments=new ArrayList<>();
        title=new ArrayList<>();
        fragments.add(new SecondGoodsFragment());
        fragments.add(new SecondGoodsFragment());
        fragments.add(new SecondGoodsFragment());
        title.add("交易中心");
        title.add("物品交换");
        title.add("发布物品");
        fragmentManager=getSupportFragmentManager();
        myAdapter=new MyAdapter(fragmentManager,fragments,title);
        viewPager.setAdapter(myAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).select();
    }*/

    public void bottomInit(){
        Actionbar1layout=findViewById(R.id.actionbar1_layout);
        Actionbar2layout=findViewById(R.id.actionbar2_layout);
        Actionbar3layout=findViewById(R.id.actionbar3_layout);
        Actionbar1layout.setOnClickListener(this);
        Actionbar2layout.setOnClickListener(this);
        Actionbar3layout.setOnClickListener(this);
        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);
        img3=findViewById(R.id.img3);
        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);
        text3=findViewById(R.id.text3);
        fragmentManager=getSupportFragmentManager();
        }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.actionbar1_layout:
                setTabSelection(0);
                break;
            case R.id.actionbar2_layout:
                setTabSelection(1);
                break;
            case R.id.actionbar3_layout:
                setTabSelection(2);
                break;
        }
    }
    public void setTabSelection(int index){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        ActionBar actionBar=getSupportActionBar();
        hideFragment(transaction);
        clearSelection();
        switch (index){
            case 0:
                img1.setImageResource(R.drawable.contacts1);
                actionBar.setTitle("交易中心");
                if(topFragment==null){
                    topFragment=new TopFragment();
                    transaction.add(R.id.content,topFragment);
                }
                else{
                    transaction.show(topFragment);
                }
                break;
            case 1:
                img2.setImageResource(R.drawable.message1);
                actionBar.setTitle("校园新闻");
                if (newsFragment==null){
                    newsFragment=new NewsFragment();
                    transaction.add(R.id.content,newsFragment);

                }
                else{
                    transaction.show(newsFragment);
                }


                break;
            case 2:
                img3.setImageResource(R.drawable.setting1);
                actionBar.setTitle("个人中心");
                if (settingFragment==null) {
                    settingFragment = new SettingFragment();
                    transaction.add(R.id.content, settingFragment);
                }
                else {
                    transaction.show(settingFragment);
                }
        }
        transaction.commit();
    }
    public void hideFragment(FragmentTransaction fragmentTransaction){
        if(topFragment!=null){
            fragmentTransaction.hide(topFragment);
        }
        if (settingFragment!=null){
            fragmentTransaction.hide(settingFragment);
        }
        if(newsFragment!=null){
            fragmentTransaction.hide(newsFragment);
        }
    }
    public void clearSelection(){
        img1.setImageResource(R.drawable.contacts);
        img2.setImageResource(R.drawable.message);
        img3.setImageResource(R.drawable.setting);
    }

}
