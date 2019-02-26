package com.example.intentlxgouwu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;
    private String name;
    private String word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username =findViewById(R.id.username);
        password =findViewById(R.id.username);
        login =findViewById(R.id.login);
        name=username.getText().toString().trim();
        word=password.getText().toString().trim();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent =new Intent(MainActivity.this,SecondActivity.class);
               Bundle data =new Bundle();
               data.putString("name",name);
               data.putString("word",word);
               intent.putExtras(data);
               startActivityForResult(intent,0);
            }
        });
    }
}
