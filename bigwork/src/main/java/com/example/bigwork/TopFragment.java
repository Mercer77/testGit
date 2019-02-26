package com.example.bigwork;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TopFragment extends Fragment {
    TabLayout tabLayout;
    FragmentManager fragmentManager;
    SecondGoodsFragment secondGoodsFragment;
    PublishGoodsFragment publishGoodsFragment;
    ChangeGoodsFragment changeGoodsFragment;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View secondLayout = inflater.inflate(R.layout.top, container, false);
        tabLayout=secondLayout.findViewById(R.id.tab_layout);
        fragmentManager=getChildFragmentManager();
        tabLayoutSelected(0);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        tabLayoutSelected(0);
                        break;
                    case 1:
                        tabLayoutSelected(1);
                        break;
                    case 2:
                        tabLayoutSelected(2);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                    switch (tab.getPosition()){
                        case 0:
                            hideFragment(0);
                            break;
                        case 1:
                            hideFragment(1);
                            break;
                        case 2:
                            hideFragment(2);
                            break;
                    }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return secondLayout;
    }
    public void tabLayoutSelected(int index){

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (index){
            case 0:

                    secondGoodsFragment=new SecondGoodsFragment();
                    transaction.add(R.id.top_content,secondGoodsFragment).addToBackStack(null);

                break;
            case 1:
                if (changeGoodsFragment==null){
                    changeGoodsFragment=new ChangeGoodsFragment();
                    transaction.add(R.id.top_content,changeGoodsFragment).addToBackStack(null);
                }
                else{
                    transaction.show(changeGoodsFragment).addToBackStack(null);
                }
                break;
            case 2:
                if(publishGoodsFragment==null){
                    publishGoodsFragment=new PublishGoodsFragment();
                    transaction.add(R.id.top_content,publishGoodsFragment).addToBackStack(null);
                }
                else {
                    transaction.show(publishGoodsFragment).addToBackStack(null);
                }
                break;
        }
        transaction.commit();
    }
    public void hideFragment(int index){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (index){
            case 0:transaction.hide(secondGoodsFragment);

                break;
            case 1:transaction.hide(changeGoodsFragment);

                break;
            case 2:transaction.hide(publishGoodsFragment);

                break;

        }
       transaction.commit();


    }
}
