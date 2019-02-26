package com.example.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText et_num;
    private EditText et_name;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name=findViewById(R.id.name);
        et_num=findViewById(R.id.num);
        btn=findViewById(R.id.save);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor =getSharedPreferences("accounts",MODE_PRIVATE).edit();
                editor.putString("num",et_num.getText().toString());
                editor.putString("name",et_name.getText().toString());
                editor.commit();
                Intent intent =new Intent();
                intent.setClass(MainActivity.this,SaveActivity.class);
                startActivity(intent);
            }
        });

    }
}
