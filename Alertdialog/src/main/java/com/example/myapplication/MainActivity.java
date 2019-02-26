package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Runnable {
    private static final int MAX_PROGRESS = 100;

    final String[] items = {"红色", "黄色", "蓝色"};
    private ProgressDialog pd=null;
   private AlertDialog.Builder builder=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button AD = findViewById(R.id.AD);
        Button LD = findViewById(R.id.LD);
        Button PD = findViewById(R.id.PD);
        Button CD = findViewById(R.id.CD);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.AD:
                        final AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
                        alert.setIcon(R.drawable.ic_launcher_background);
                        alert.setTitle("sds");
                        alert.setMessage("你确定要退出本软件吗？");
                        alert.setButton(DialogInterface.BUTTON_NEGATIVE, "否", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                alert.dismiss();
                            }
                        });
                        alert.setButton(DialogInterface.BUTTON_POSITIVE, "是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                MainActivity.this.finish();
                            }
                        });
                        alert.show();
                        break;
                    case R.id.LD:
                        builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("请选择一种颜色");
                        builder.setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                Toast.makeText(MainActivity.this, items[which], Toast.LENGTH_LONG).show();

                            }
                        });
                        builder.create().show();
                        break;
                    case R.id.PD:
                        pd=new ProgressDialog(MainActivity.this);
                        pd.setTitle("进度条");
                        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                        pd.setMax(MAX_PROGRESS);
                        pd.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }

                        });
                        pd.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        pd.show();
                        new Thread(MainActivity.this).start();
                        return;
                    case R.id.CD:
                        final AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                        builder1.setIcon(R.drawable.ic_launcher_background);
                        builder1.setTitle("自定义对话框");
                        View view = getLayoutInflater().inflate(R.layout.customalertdialog, null);
                        final EditText etname = (EditText) view.findViewById(R.id.et_username);
                        final EditText etword = (EditText) view.findViewById(R.id.et_password);
                        final TextView tvname = (TextView) view.findViewById(R.id.tv1);
                        final TextView tvword = (TextView) view.findViewById(R.id.tv2);
                        builder1.setView(view);
                        builder1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String name = etname.getText().toString().trim();
                                String word = etword.getText().toString().trim();
                                Toast.makeText(MainActivity.this, "您的姓名：" + name + "\n" + "您的密码：" + word, Toast.LENGTH_LONG).show();
                            }
                        });
                        builder1.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                builder1.create().dismiss();
                            }
                        });
                        builder1.create().show();
                        break;

                }
            }
        };
        AD.setOnClickListener(listener);
        LD.setOnClickListener(listener);
        PD.setOnClickListener(listener);
        CD.setOnClickListener(listener);

    }

    @Override
    public void run() {
            int progress=0;
        while (progress < MAX_PROGRESS) {
            try {
                Thread.sleep(100);
                progress++;
                pd.incrementProgressBy(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
}