package com.example.sy9_1;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    FruitDAO dao;
    SimpleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.lvfruit);
        dao =new FruitDAO();
        ArrayList<Map<String, String>> fruits =dao.getAllFruits();
        adapter=new SimpleAdapter(this,fruits,R.layout.list_items,new String[]{"id","name","price","place"},new int[]{R.id.ID,R.id.name,R.id.price,R.id.place});
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"你点击了它",Toast.LENGTH_SHORT).show();
            }
        });
        registerForContextMenu(lv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("操作");
        menu.add(0,1,1,"详情");
        menu.add(0,2,2,"删除");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = ( AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch (item.getItemId()){
            case 1:
                AlertDialog.Builder builder =new AlertDialog.Builder(this);
                builder.setMessage("ID:"+dao.getAllFruits().get(menuInfo.position).get("id")+"\n"+
                        "姓名:"+dao.getAllFruits().get(menuInfo.position).get("name")+"\n"+
                        "价格:"+dao.getAllFruits().get(menuInfo.position).get("price")+"\n"+
                        "产地:"+dao.getAllFruits().get(menuInfo.position).get("place")+"\n");
                builder.create().show();
                break;
            case 2: dao.removeFruit(menuInfo.position);
                    adapter.notifyDataSetChanged();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =new MenuInflater(this);
        inflater.inflate(R.menu.menu_items,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.addf:
                Intent intent =new Intent(MainActivity.this,FruitAddActivity.class);
                startActivityForResult(intent,0);
                break;
            case R.id.exit:
                System.exit(0);
                break;


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 0:if(resultCode==RESULT_OK){
                Bundle bundle = data.getExtras();
                Map<String,String> map=new HashMap<String, String>();
                map.put("id",bundle.getString("id"));
                map.put("name",bundle.getString("name"));
                map.put("price",bundle.getString("price"));
                map.put("place",bundle.getString("place"));
                dao.addFruits(map);
                adapter.notifyDataSetChanged();
            }
            break;
            default:
                break;
        }
    }
}
