package com.example.myapplication;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements XListView.IXListViewListener {
    private XListView mListView;
    private SimpleAdapter mAdapter;
    private List<Map<String, String>> list = new ArrayList<Map<String, String>>();
    private Handler mHandler;
    private int start = 0;
    private static int refreshCnt = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        geneItems();
        mListView = (XListView) findViewById(R.id.xListView);
        mListView.setPullLoadEnable(true);
        mAdapter = new SimpleAdapter(this, list, R.layout.list_item, new String[]{"id", "name"}, new int[]{R.id.id, R.id.name});
        mListView.setAdapter(mAdapter);
        mListView.setXListViewListener(this);
        mHandler = new Handler();
    }

    private void geneItems() {
        for (int i = 0; i != 8; ++i) {
            Map<String, String> Item = new HashMap<String, String>();
            Item.put("id", (++start) + "");
            Item.put("name", "张小" + start);
            list.add(Item);
        }
    }

    @Override
    public void onRefresh() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                start = ++refreshCnt;
                list.clear();
                geneItems();// 生成下一批数据
                mAdapter = new SimpleAdapter(getApplicationContext(), list, R.layout.list_item, new String[]{"id", "name"}, new int[]{R.id.id, R.id.name});
                mListView.setAdapter(mAdapter);
                onLoad();
            }
        }, 2000);
    }

    @Override
    public void onLoadMore() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                geneItems();
                mAdapter.notifyDataSetChanged();
                onLoad();
            }
        }, 2000);
    }

    private void onLoad() {
        mListView.stopRefresh();
        mListView.stopLoadMore();
        mListView.setRefreshTime("刚刚");
    }
}
