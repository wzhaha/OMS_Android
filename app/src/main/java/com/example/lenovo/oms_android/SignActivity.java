package com.example.lenovo.oms_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Entity.UserItem;
import Networks.RestClient;

/**
 * Created by lenovo on 2018/4/19.
 */

public class SignActivity extends AppCompatActivity {

    private Button sign;
    private EditText id;
    private EditText pass;
    private EditText ensurePass;
    private EditText email;
    private Spinner spinner;
    private Button back;
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.sign);

        sign=findViewById(R.id.sign_button);
        id=findViewById(R.id.sign_id);
        ensurePass=findViewById(R.id.sign_ensurepass);
        pass=findViewById(R.id.sign_pass);
        email=findViewById(R.id.sign_email);
        spinner=findViewById(R.id.sign_spinner);
        back=findViewById(R.id.sign_getback);
        List<String> list = new ArrayList<String>();
        list.add("开发者");
        list.add("发布者");
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,list);
        spinner.setAdapter(adapter);

        //点击注册的事件
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if(id.getText().toString().equals(""))
                            Toast.makeText(getApplicationContext(),"请输入用户名",Toast.LENGTH_SHORT).show();
                        else if(pass.getText().toString().equals(""))
                            Toast.makeText(getApplicationContext(),"请输入密码",Toast.LENGTH_SHORT).show();
                        else if (pass.getText().toString().equals(ensurePass.getText().toString())) {
                            String role=(String)spinner.getSelectedItem();
                            String userRole=null;
                            switch (role){
                                case "发布者":
                                    userRole="1";
                                    break;
                                case "开发者":
                                    userRole="2";
                                    break;
                            }
                            UserItem user=new UserItem(id.getText().toString(),pass.getText().toString(),userRole,"face");

                            RestClient.getInstance().signUp(user);
                            setResult(2, (new Intent()).putExtra("id", id.getText().toString()));
                            finish();
                        }
                        else
                            Toast.makeText(getApplicationContext(),"请输入相同密码",Toast.LENGTH_SHORT).show();
                    }
                }).start();
            }
        });
        //点击返回
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(2, (new Intent()).putExtra("id",""));
                finish();
            }
        });

    }
}



