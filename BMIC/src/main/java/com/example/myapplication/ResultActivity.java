package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


/**
 * Created by Mercer on 2018/5/3.
 */

public class ResultActivity extends AppCompatActivity {
    private TextView result;
    private double tz;
    private String sex;
    private double height;
    @Override
    protected void onCreate( Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        result =  (TextView) findViewById(R.id.result);
        //取得Intent中bundle对象
        Bundle data = this.getIntent().getExtras();   //获取bundle中的数据
        sex = data.getString("sex");
        height = data.getDouble("height");
        if(sex.equals("男")){
            tz=(height-80)*0.7;
            result.setText("你的性别是："+sex+"\n你的身高是："+height+"厘米\n"+"你的标准体重是："+String.format("%.2f",tz)+"公斤");
        }
        else if(sex.equals("女")){
            tz=(height-70)*0.6;
            result.setText("你的性别是："+sex+"\n你的身高是："+height+"厘米\n"+"你的标准体重是："+String.format("%.2f",tz)+"公斤");
        }


    }
}
