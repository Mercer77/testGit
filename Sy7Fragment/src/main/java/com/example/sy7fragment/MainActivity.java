package com.example.sy7fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private MessageFragment messageFragment;
    private ContactsFragment contactsFragment;
    private SettingFragment settingFragment;
    // 3个布局
    private View messageLayout;
    private View contactsLayout;
    private View settingLayout;
    // 3个布局所在的图片和文本
    private ImageView messageImage;
    private ImageView contactsImage;
    private ImageView settingImage;
    private TextView messageText;
    private TextView contactsText;
    private TextView settingText;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageLayout=findViewById(R.id.message_layout);
        contactsLayout=findViewById(R.id.contacts_layout);
        settingLayout=findViewById(R.id.setting_layout);
        messageImage=findViewById(R.id.message_image);
        contactsImage=findViewById(R.id.contacts_image);
        settingImage=findViewById(R.id.setting_Image);
        messageText=findViewById(R.id.messageText);
        contactsText=findViewById(R.id.contactsText);
        settingText=findViewById(R.id.settingText);
        messageLayout.setOnClickListener(this);
        contactsLayout.setOnClickListener(this);
        settingLayout.setOnClickListener(this);
        fragmentManager = getFragmentManager();
        setTabSelection(0);
    }

    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.message_layout:
            setTabSelection(0);
            break;
        case R.id.contacts_layout:
            setTabSelection(1);
            break;
        case R.id.setting_layout:
            setTabSelection(2);
            break;

    }
    }
    public void setTabSelection(int index){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        clearSelection();
        switch (index){
            case 0:
                messageImage.setImageResource(R.drawable.message1);
                messageText.setTextColor(Color.WHITE);
                if(messageFragment==null){
                    messageFragment =new MessageFragment();
                    transaction.add(R.id.content,messageFragment);
                }
                else{
                    transaction.show(messageFragment);
                }
                break;
            case 1:
                contactsImage.setImageResource(R.drawable.contacts1);
                contactsText.setTextColor(Color.WHITE);
                if(contactsFragment==null){
                    contactsFragment =new ContactsFragment();
                    transaction.add(R.id.content,contactsFragment);
                }
                else{
                    transaction.show(contactsFragment);
                }
                break;
            case 2:
                settingImage.setImageResource(R.drawable.setting1);
                settingText.setTextColor(Color.WHITE);
                if(settingFragment==null){
                    settingFragment =new SettingFragment();
                    transaction.add(R.id.content,settingFragment);
                }
                else{
                    transaction.show(settingFragment);
                }
                break;
        }
        transaction.commit();

    }
    public void hideFragments(FragmentTransaction fragmentTransaction){
        if(messageFragment!=null){
            fragmentTransaction.hide(messageFragment);
        }
        if(contactsFragment!=null){
            fragmentTransaction.hide(contactsFragment);
        }
        if(settingFragment!=null){
            fragmentTransaction.hide(settingFragment);
        }
    }
    public void clearSelection(){
        messageImage.setImageResource(R.drawable.message);
        messageText.setTextColor(Color.parseColor("#A9A9A9"));
        contactsImage.setImageResource(R.drawable.contacts);
        contactsText.setTextColor(Color.parseColor("#A9A9A9"));
       settingImage.setImageResource(R.drawable.setting);
        settingText.setTextColor(Color.parseColor("#A9A9A9"));
    }


}
