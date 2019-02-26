package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SaveActivity extends AppCompatActivity {
    private EditText et_num;
    private EditText et_name;
    private Button btn;
    //SharedPreferences sp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save);
        et_name=findViewById(R.id.name);
        et_num=findViewById(R.id.num);
        btn=findViewById(R.id.check);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               SharedPreferences sp =getSharedPreferences("accounts",MODE_PRIVATE);
                if((sp.getString("num","00").equals(et_num.getText().toString()))&&(sp.getString("name","00").equals(et_name.getText().toString()))){
                    Toast.makeText(SaveActivity.this,"欢迎您！",Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(SaveActivity.this,"学号或者姓名错误！",Toast.LENGTH_LONG).show();

            }
        });

    }
}
