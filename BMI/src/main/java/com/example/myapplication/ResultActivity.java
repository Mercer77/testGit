package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;



/**
 * Created by Mercer on 2018/5/3.
 */

public class ResultActivity extends AppCompatActivity {
    private TextView result;
    private String sex;
    private double height;
    private String weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //取得Intent中bundle对象
        Bundle data = this.getIntent().getExtras();   //获取bundle中的数据
        sex = data.getString("sex");
        height = data.getDouble("height");
        if (sex.equals("男")) {
            weight = String.format("%.2f",(height - 80) * 0.7);
        } else if (sex.equals("女")) {
            weight = String.format("%.2f",(height - 70) * 0.6);
        }
        //封装数据
        Bundle bundle = new Bundle();
        bundle.putString("weight", weight);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.setClass(ResultActivity.this, MainActivity.class);
        setResult(RESULT_OK, intent);
        finish();


    }
}