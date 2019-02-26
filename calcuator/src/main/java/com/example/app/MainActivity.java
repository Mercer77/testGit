package com.example.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        private EditText et_number;//数字输入框
        private int flag;//标记用户的操作
        private String number;//在点击加减乘除前储存第一个数
        private Button bt1;
        private Button bt2;
        private Button bt3;
        private Button bt4;
        private Button bt5;
        private Button bt6;
        private Button bt7;
        private Button bt8;
        private Button bt9;
        private Button bt0;
        private Button btadd;
        private Button btcan;
        private Button btmul;
        private Button btmol;
        private Button btc;
        private Button bteql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_number =(EditText)findViewById(R.id.et1);
        bt1=(Button)findViewById(R.id.bt1);
        bt2=(Button)findViewById(R.id.bt2);
        bt3=(Button)findViewById(R.id.bt3);
        bt4=(Button)findViewById(R.id.bt4);
        bt5=(Button)findViewById(R.id.bt5);
        bt6=(Button)findViewById(R.id.bt6);
        bt7=(Button)findViewById(R.id.bt7);
        bt8=(Button)findViewById(R.id.bt8);
        bt9=(Button)findViewById(R.id.bt9);
        bt0=(Button)findViewById(R.id.bt0);
        btadd=(Button)findViewById(R.id.btadd);
        btcan=(Button)findViewById(R.id.btcan);
        btmul=(Button)findViewById(R.id.btmul);
        btmol=(Button)findViewById(R.id.btmol);
        bteql=(Button)findViewById(R.id.bteql);
        btc=(Button)findViewById(R.id.btc);

        View.OnClickListener btlistener =new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=null;
                switch(v.getId()){
                    case R.id.bt0:
                        s=new String();
                        s=et_number.getText()+"0";
                        et_number.setText(s);
                             break;
                    case R.id.bt1:
                        s=new String();
                        s=et_number.getText()+"1";
                        et_number.setText(s);
                        break;
                    case R.id.bt2:
                        s=new String();
                        s=et_number.getText()+"2";
                        et_number.setText(s);
                        break;
                    case R.id.bt3:
                        s=new String();
                        s=et_number.getText()+"3";
                        et_number.setText(s);
                        break;
                    case R.id.bt4:
                        s=new String();
                        s=et_number.getText()+"4";
                        et_number.setText(s);
                        break;
                    case R.id.bt5:
                        s=new String();
                        s=et_number.getText()+"5";
                        et_number.setText(s);
                        break;
                    case R.id.bt6:
                        s=new String();
                        s=et_number.getText()+"6";
                        et_number.setText(s);
                        break;
                    case R.id.bt7:
                        s=new String();
                        s=et_number.getText()+"7";
                        et_number.setText(s);
                        break;
                    case R.id.bt8:
                        s=new String();
                        s=et_number.getText()+"8";
                        et_number.setText(s);
                        break;
                    case R.id.bt9:
                        s=new String();
                        s=et_number.getText()+"9";
                        et_number.setText(s);
                        break;
                    case R.id.btadd:
                        flag=1;
                        number=et_number.getText().toString();
                        et_number.setText("");
                        break;
                    case R.id.btcan:
                        flag=2;
                        number=et_number.getText().toString();
                        et_number.setText("");
                        break;
                    case R.id.btmul:
                        flag=3;
                        number=et_number.getText().toString();
                        et_number.setText("");
                        break;
                    case R.id.btmol:
                        flag=4;
                        number=et_number.getText().toString();
                        et_number.setText("");
                        break;
                    case R.id.btc:
                        flag=1;
                        et_number.setText("");
                        break;
                    case R.id.bteql:
                        if (flag==1){
                            float first=Float.parseFloat(number);
                            first=first+Float.parseFloat(et_number.getText().toString());
                            et_number.setText(String.valueOf(first));
                        }
                        if (flag==2){
                            float first=Float.parseFloat(number);
                            first=first-Float.parseFloat(et_number.getText().toString());
                            et_number.setText(String.valueOf(first));
                        }
                        if (flag==3){
                            float first=Float.parseFloat(number);
                            first=first*Float.parseFloat(et_number.getText().toString());
                            et_number.setText(String.valueOf(first));
                        }
                        if (flag==4){
                            float first=Float.parseFloat(number);
                            Float second =Float.parseFloat(et_number.getText().toString());
                            if(second==0){

                                Toast.makeText(getApplicationContext(),"除数不能为0",Toast.LENGTH_LONG).show();
                                et_number.setText("");
                            }else {
                                first = first/Float.parseFloat(et_number.getText().toString());
                                et_number.setText(String.valueOf(first));
                            }
                        }break;
                }
            }
        };
        bt0.setOnClickListener(btlistener);
        bt1.setOnClickListener(btlistener);
        bt2.setOnClickListener(btlistener);
        bt3.setOnClickListener(btlistener);
        bt4.setOnClickListener(btlistener);
        bt5.setOnClickListener(btlistener);
        bt6.setOnClickListener(btlistener);
        bt7.setOnClickListener(btlistener);
        bt8.setOnClickListener(btlistener);
        bt9.setOnClickListener(btlistener);
        btadd.setOnClickListener(btlistener);
        btcan.setOnClickListener(btlistener);
        btmul.setOnClickListener(btlistener);
        btmol.setOnClickListener(btlistener);
        btc.setOnClickListener(btlistener);
        bteql.setOnClickListener(btlistener);
    }

}
