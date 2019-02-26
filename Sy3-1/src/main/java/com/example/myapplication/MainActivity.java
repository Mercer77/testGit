package com.example.myapplication;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private RadioGroup rg;
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = (RadioGroup) findViewById(R.id.rg);
        btn = (Button) findViewById(R.id.eql);
        et = (EditText) findViewById(R.id.tall);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if(i==R.id.boy){
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            double sg =Double.parseDouble(et.getText().toString().trim());
                            double tz =(sg-80)*0.7;
                            AlertDialog.Builder builder =new AlertDialog.Builder(MainActivity.this);
                            builder.setMessage("你的性别是：男"+"\n"+"你的身高是："+sg+"厘米\n"+"你的标准体重是："+String.format("%.2f",tz)+"公斤");
                            builder.create().show();
                        }
                    });

                }
                else if(i==R.id.girl){
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            double sg =Double.parseDouble(et.getText().toString().trim());
                            double tz =(sg-70)*0.6;
                            AlertDialog.Builder builder =new AlertDialog.Builder(MainActivity.this);
                            builder.setMessage("你的性别是：女"+"\n"+"你的身高是："+sg+"厘米\n"+"你的标准体重是："+String.format("%.2f",tz)+"公斤");
                            builder.create().show();
                        }
                    });

                }
            }
        });

    }
}