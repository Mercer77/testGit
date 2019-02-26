package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioGroup rg1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg1=(RadioGroup)findViewById(R.id.rg1);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if(i==R.id.rb1){
                    Toast.makeText(MainActivity.this,"你是男孩",Toast.LENGTH_LONG).show();
                }
                else if(i==R.id.rb2){
                    Toast.makeText(MainActivity.this,"你是女孩",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
