package com.example.bigwork;

import android.app.ActivityOptions;
import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.transition.Explode;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private Button btlogin;
    private FloatingActionButton fab;
    private DBOpenHelper helper;
    private  UserDAO ud;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        setListener();

    }

    private void initView() {
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btlogin = findViewById(R.id.bt_login);
        fab = findViewById(R.id.fab);
        ud=new UserDAO(LoginActivity.this);
        helper=new DBOpenHelper(this);
        helper.getWritableDatabase();

    }

    private void setListener() {
        btlogin.setOnClickListener(new View.OnClickListener() {
            boolean c=false;
            @Override
            public void onClick(View view) {
                for(int i=0;i<ud.getall().size();i++){
                    if ((etUsername.getText().toString().equals(ud.getall().get(i).getUsername()))&&(etPassword.getText().toString().equals(ud.getall().get(i).getPassword()))){
                        c=true;
                    }
                }
                if(etUsername.getText().toString().equals("")){
                    AlertDialog.Builder builder =new AlertDialog.Builder(LoginActivity.this);
                    builder.setTitle("提示");
                    builder.setMessage("用户名不能为空");
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.create().show();

                }
                else if (c==false){
                    AlertDialog.Builder builder =new AlertDialog.Builder(LoginActivity.this);
                    builder.setTitle("提示");
                    builder.setMessage("用户名或密码错误");
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.create().show();
                }
               else {
                    Explode explode = new Explode();
                    explode.setDuration(500);
                    getWindow().setExitTransition(explode);
                    getWindow().setEnterTransition(explode);
                    Intent i2 = getIntent();
                    setResult(1, i2);
                    finish();
                }


            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWindow().setExitTransition(null);
                getWindow().setEnterTransition(null);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, fab, fab.getTransitionName());
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class), options.toBundle());
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        fab.setVisibility(View.GONE);
    }
    @Override
    protected void onStart() {
        super.onStart();
        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    @Override
    protected void onResume() {
        super.onResume();
        fab.setVisibility(View.VISIBLE);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
