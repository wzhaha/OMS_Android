package com.example.lenovo.oms_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText id;
    private EditText pass;
    private Button login;
    private Button sign;
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login =(Button) findViewById(R.id.login);
        sign=findViewById(R.id.sign);
        id=(EditText) findViewById(R.id.id);
        pass=(EditText) findViewById(R.id.pass);
        spinner=findViewById(R.id.login_spinner);
        List<String> list = new ArrayList<String>();
        list.add("开发者");
        list.add("发布者");
        list.add("管理员");
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,list);
        spinner.setAdapter(adapter);
        //登录事件
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id.getText().toString().equals("haha")&&pass.getText().toString().equals("111")) {
                    Intent it = new Intent(MainActivity.this, UserMainUiActivity.class);
                    it.putExtra("userid", id.getText().toString());
                    it.putExtra("role",spinner.getSelectedItem().toString());
                    startActivityForResult(it, 1);
                }
                else
                    Toast.makeText(getApplicationContext(),"账号或密码错误", Toast.LENGTH_SHORT).show();
            }
        });
        //注册活动跳转
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(MainActivity.this,SignActivity.class);
                startActivityForResult(it,2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requrestCode ,int result,Intent data){
        switch (requrestCode){
            case 1:
                Log.v("MainActivity","从userMainUi返回,result="+result);
                id.setText(null);
                pass.setText(null);
                break;
            case 2:
                Log.v("MainActivity","从signActivity返回,result="+result);
                id.setText(data.getExtras().getString("id"));
                pass.setText(null);
                break;
        }
        super.onActivityResult(requrestCode,result,data);
    }
}
