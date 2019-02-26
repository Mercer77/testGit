package com.example.bigwork;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.app.Activity.RESULT_OK;

public class PublishGoodsFragment extends Fragment {

    Button btn;
    ImageView imageView;
    TextView pgname;
    TextView pgprice;
    TextView pgcheapprice;
    CheckBox pgchange;
    TextView pgchangegood;
    EditText pgintroduce;
    SecondGoods sg;
    SecondGoodsDAO sd;
    Object lj;
    TextView pgphone;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View publishGoodsLayout= inflater.inflate(R.layout.fragment_publishgoods,container,false);
        btn=publishGoodsLayout.findViewById(R.id.pg_btn);
        imageView=publishGoodsLayout.findViewById(R.id.pg_img);
        pgname=publishGoodsLayout.findViewById(R.id.pg_name);
        pgphone=publishGoodsLayout.findViewById(R.id.pg_phone);
        pgprice=publishGoodsLayout.findViewById(R.id.pg_price);
        pgcheapprice=publishGoodsLayout.findViewById(R.id.pg_cheapprice);
        pgchange=publishGoodsLayout.findViewById(R.id.pg_change);
        pgchangegood=publishGoodsLayout.findViewById(R.id.pg_changeGood);
        pgintroduce=publishGoodsLayout.findViewById(R.id.pg_introduce);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder =new AlertDialog.Builder(getActivity());
                builder.setTitle("请选择方式");
                builder.setPositiveButton("从本地选择", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_PICK, null);
                        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                                "image/*");
                        startActivityForResult(intent, 1);
                    }
                });
                builder.setNegativeButton("拍照", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(cameraIntent, 2);
                    }
                });

                builder.create().show();

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!IsLoginUtil.getIsLogin(getActivity()).equals("1")){
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                }
                else {
                    sg=new SecondGoods();
                    sg.setName(pgname.getText().toString());
                    sg.setPrice(pgprice.getText().toString());
                    sg.setCheapprice(pgcheapprice.getText().toString());
                    sg.setIntroduce(pgintroduce.getText().toString());
                    sg.setZp(imageView.getDrawable().toString());
                    sg.setPhone(pgphone.getText().toString());
                    sd=new SecondGoodsDAO(getActivity());
                    sd.add(sg);
                    Toast.makeText(getActivity(),"发布成功",Toast.LENGTH_SHORT).show();

                }
            }
        });
        return publishGoodsLayout;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        if (resultCode == RESULT_OK) {
            if (requestCode==1&&data != null) {
                imageView.setImageURI(data.getData());

            }
            if(requestCode==2&&data!=null){
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(photo);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }



 /*   public static String getRealFilePath(final Context context, final Uri uri ) {
        if ( null == uri ) return null;
        final String scheme = uri.getScheme();
        String data = null;
        if ( scheme == null )
            data = uri.getPath();
        else if ( ContentResolver.SCHEME_FILE.equals( scheme ) ) {
            data = uri.getPath();
        } else if ( ContentResolver.SCHEME_CONTENT.equals( scheme ) ) {
            Cursor cursor = context.getContentResolver().query( uri, new String[] { MediaStore.Images.ImageColumns.DATA }, null, null, null );
            if ( null != cursor ) {
                if ( cursor.moveToFirst() ) {
                    int index = cursor.getColumnIndex( MediaStore.Images.ImageColumns.DATA );
                    if ( index > -1 ) {
                        data = cursor.getString( index );
                    }
                }
                cursor.close();
            }
        }
        return data;
    }*/


}
