package com.example.bigwork;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NewsFragment extends Fragment {
    ListView listView;
    SimpleAdapter simpleAdapter;
    Context context;
    ArrayList<Map<String,String>> list;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_news,container,false);
        listView=view.findViewById(R.id.lv_news);
        list =new ArrayList<>();
        context=getActivity();
        Init();
        simpleAdapter=new SimpleAdapter(context,list,R.layout.news_list,new String[]{"title","context","date"},new int[]{R.id.news_title,R.id.news_context,R.id.news_date});
        listView.setAdapter(simpleAdapter);
        return view;
    }
    public void Init(){
        Map<String,String> map= new HashMap<String,String>();
        Map<String,String> map1= new HashMap<String,String>();
        Map<String,String> map2= new HashMap<String,String>();
        Map<String,String> map3= new HashMap<String,String>();
        map.put("title","大扫除通知");
        map.put("context","各班班长负责分配同学们任务，清楚校园内的每一个死角，务必保持校园清洁。校园是我家，情节靠大家，希望大家相互配合，搞好学校的清洁工作。");
        map.put("date","2018年2月1日");
        list.add(map);
        map1.put("title","明天看电影");
        map1.put("context","在东校区，南湖电影院，观看最新高清电影，凡到场的同学，免费赠送一个3D眼镜，期待同学们的参与。");
        map1.put("date","2018年3月1日");
        list.add(map1);
        map2.put("title","招领启事");
        map2.put("context","有同学于10月25日在校篮球场拾取背包一个，里面有物品若干，请失主赶快赶到校广播站来领取。");
        map2.put("date","2018年4月1日");
        list.add(map2);
        map3.put("title","考试通知");
        map3.put("context","学校教务处既定于12月25日进行本学期的期末考试，希望同学们遵循考试的规章制度，禁止携带与考试有关的物品，互相监督，举报有奖。");
        map3.put("date","2018年6月1日");
        list.add(map3);
    }
}
