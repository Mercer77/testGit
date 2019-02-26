package com.example.bigwork;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowCollection extends AppCompatActivity {
    ListView listView;
    SimpleAdapter simpleAdapter;
    ArrayList<Map<String,String>> list;
    CollectionDAO cd;
    SearchView searchView;

    public ShowCollection() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showcollection);
        listView=findViewById(R.id.lv_collction);
        searchView=findViewById(R.id.search);
        cd=new CollectionDAO(ShowCollection.this);
        list=getCollection();
        simpleAdapter=new SimpleAdapter(ShowCollection.this,list,R.layout.secondgoods_list,new String[]{"zp", "name", "cheapprice", "price"}, new int[]{R.id.img_goods, R.id.name_goods, R.id.text_cheapprice, R.id.text_price});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView good = view.findViewById(R.id.name_goods);
                String goodsName = good.getText().toString();
                Intent intent = new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(ShowCollection.this, ShowCollectionXx.class);
                bundle.putString("goodsName",goodsName);
                intent.putExtra("bundle", bundle);
                startActivity(intent);
            }
        });
        registerForContextMenu(listView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(TextUtils.isEmpty(query))
                {
                    listView.setAdapter(simpleAdapter);
                }
                else
                {

                    String goodsName = query;
                    Intent intent = new Intent();
                    Bundle bundle=new Bundle();
                    intent.setClass(ShowCollection.this, ShowCollectionXx.class);
                    bundle.putString("goodsName",goodsName);
                    intent.putExtra("bundle", bundle);
                    startActivity(intent);
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {


                return false;
            }
        });


    }
    public ArrayList<Map<String, String>> getCollection() {

        ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();

        for (int i = 0; i < cd.getall().size(); i++) {
            Map<String, String> map = new HashMap<>();
            map.put("name", cd.getall().get(i).getName());
            map.put("cheapprice", cd.getall().get(i).getCheapprice());
            map.put("price", cd.getall().get(i).getPrice());
            map.put("introduce", cd.getall().get(i).getIntroduce());
            map.put("phone", cd.getall().get(i).getPhone());
            map.put("zp", cd.getall().get(i).getZp());
            list.add(map);
        }
        return list;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("操作");
        menu.add(0,1,1,"移除");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = ( AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch (item.getItemId()){
            case 1:
               cd.delete(list.get(menuInfo.position).get("name"));
                list.remove(menuInfo.position);
                break;
        }

        simpleAdapter.notifyDataSetChanged();
        return super.onContextItemSelected(item);

    }

    @Override
    protected void onStart() {
        super.onStart();
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

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
