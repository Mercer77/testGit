package com.example.sy9_1;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class FruitAddActivity extends AppCompatActivity {
    Button btn;
    EditText et_id;
    EditText et_name;
    EditText et_price;
    EditText et_place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        et_id=findViewById(R.id.ID);
        et_name=findViewById(R.id.name);
        et_place=findViewById(R.id.place);
        et_price=findViewById(R.id.price);
        btn=findViewById(R.id.add);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                Bundle bundle =new Bundle();
                bundle.putString("id",et_id.getText().toString());
                bundle.putString("name",et_name.getText().toString());
                bundle.putString("price",et_price.getText().toString());
                bundle.putString("place",et_place.getText().toString());
                intent.putExtras(bundle);
                intent.setClass(FruitAddActivity.this,MainActivity.class);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
