package com.example.bigwork;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SettingFragment extends Fragment {
    Button button;
    Context context;
    TextView myCollection;
    ImageView imageView;
    SharedPreferences sp;
    Button exit;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view =inflater.inflate(R.layout.fragment_setting,container,false);
        context=getActivity();
        button=view.findViewById(R.id.fs_btn);
        imageView=view.findViewById(R.id.fs_tx);
        exit=view.findViewById(R.id.exit_btn);
        myCollection=view.findViewById(R.id.myCollection);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    IsLoginUtil.exit(context);
                    imageView.setImageResource(R.drawable.ic_launcher_foreground);
                    button.setText("立 即 登 录");
                    button.setClickable(true);
                    Toast.makeText(context, "您已退出登录", Toast.LENGTH_SHORT).show();


            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent();
                intent.setClass(context,LoginActivity.class);
                startActivityForResult(intent,1);
            }
        });
        myCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (IsLoginUtil.getIsLogin(context).equals("2")){
                    Toast.makeText(context, "请先登录", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent();
                    intent.setClass(context, ShowCollection.class);
                    startActivity(intent);
                }
            }

        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==1){
            IsLoginUtil.setIsLogin(context);
            imageView.setImageResource(R.drawable.tx);
            button.setText("已登录");
            button.setClickable(false);


        }
    }

}
