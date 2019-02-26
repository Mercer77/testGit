package com.example.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.ProtectionDomain;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    protected ImageView img1=null;
    protected ImageView img2=null;
    protected ImageView img3=null;
    protected Button btn=null;
    protected TextView tv1=null;
    int[] s =new int[]{R.drawable.pic1,R.drawable.pic2,R.drawable.pic3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1=(ImageView)findViewById(R.id.img1);
        img2=(ImageView)findViewById(R.id.img2);
        img3=(ImageView)findViewById(R.id.img3);
        btn=(Button)findViewById(R.id.btn);
        tv1=(TextView)findViewById(R.id.tv1);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1.setImageResource(s[0]);

                if(s[0]==R.drawable.pic1){
                    tv1.setText("恭喜你！答对了");
                }
                else{
                    tv1.setText("您猜错了，继续努力");
                }
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                img2.setImageResource(s[1]);

                if(s[1]==R.drawable.pic1){
                    tv1.setText("恭喜你！答对了");
                }
                else{
                    tv1.setText("您猜错了，继续努力");
                }
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img3.setImageResource(s[2]);

                if(s[2]==R.drawable.pic1){
                    tv1.setText("恭喜你！答对了");
                }
                else{
                    tv1.setText("您猜错了，继续努力");
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r =new Random();
                tv1.setText("猜猜红桃A在哪？");
                img1.setImageResource(R.drawable.pic4);
                img2.setImageResource(R.drawable.pic4);
                img3.setImageResource(R.drawable.pic4);
                for(int i=0;i<3;i++){
                    int temp = s[i];
                    int rand = r.nextInt(3);
                    s[i]=s[rand];
                    s[rand]=temp;
                }
            }
        });
    }


}
