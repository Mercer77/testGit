package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RadioButton boy;
    private RadioButton girl;
    private EditText etHeight;
    public String sex;
    public double height;
    Button bt;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etHeight =findViewById(R.id.tall);
        girl =findViewById(R.id.girl);
        boy=findViewById(R.id.boy);
        bt =findViewById(R.id.eql);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(boy.isChecked()){
                    sex ="男";
                }else if(girl.isChecked()){
                    sex="女";
                }
                height =Double.parseDouble(etHeight.getText().toString().trim());
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ResultActivity.class);
                Bundle  data = new Bundle();
                data.putString("sex", sex);
                data.putDouble("height", height);
                intent.putExtras(data);
                startActivityForResult(intent, 0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        tv=findViewById(R.id.tv);
        switch (requestCode) {
            case 0:
                if(resultCode==RESULT_OK){
                    Bundle bundle = data.getExtras();
                    String weight = bundle.getString("weight");     //设置输出结果
                    tv.setText("你的性别是:"+sex+"\n你的身高是："+height+"厘 米\n你的标准体重是"+weight+"公斤");
                }
                break;
            default:
                break;
        }
    }
}