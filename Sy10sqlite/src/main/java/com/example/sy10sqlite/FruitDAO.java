package com.example.sy10sqlite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FruitDAO {
    Map<String, String> map1 = new HashMap<String, String>();
    Map<String, String> map2 = new HashMap<String, String>();
    Map<String, String> map3 = new HashMap<String, String>();
    Map<String, String> map4 = new HashMap<String, String>();

    ArrayList<Map<String, String>> fruits=new ArrayList<Map<String, String>>();



    public FruitDAO() {


        map1.put("id","1.0");
        map1.put("name","苹果");
        map1.put("price","20.0");
        map1.put("place","山东");
        fruits.add(map1);
        map2.put("id","2.0");
        map2.put("name","西瓜");
        map2.put("price","10.0");
        map2.put("place","湖南");
        fruits.add(map2);
        map3.put("id","3.0");
        map3.put("name","香蕉");
        map3.put("price","15.0");
        map3.put("place","广西");
        fruits.add(map3);
        map4.put("id","4.0");
        map4.put("name","香蕉");
        map4.put("price","25.0");
        map4.put("place","福建");
        fruits.add(map4);

       /* fruits.add(new Fruit(1, "苹果", "20", "山东"));
        fruits.add(new Fruit(2, "西瓜", "10", "海南"));
        fruits.add(new Fruit(3, "香蕉", "15", "广西"));
        fruits.add(new Fruit(4, "荔枝", "25", "福建"));*/

    }
    public ArrayList<Map<String, String>> getAllFruits(){
        return fruits;
    }

    public void removeFruit(int position){
            fruits.remove(position);
    }
    public void addFruits(Map<String,String> f){
        if(!fruits.contains(f)){
            fruits.add(f);
        }
    }



}
