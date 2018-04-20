package com.example.lenovo.oms_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by lenovo on 2018/4/20.
 */

public class ModifyActivity extends AppCompatActivity {

    private EditText old_pass;
    private EditText new_pass;
    private EditText ensure_new_pass;
    private Button ensure;
    private Button back;
    @Override
    public void onCreate(Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.modify_pass);

        old_pass=findViewById(R.id.old_pass);
        new_pass=findViewById(R.id.new_pass);
        ensure_new_pass=findViewById(R.id.ensure_new_pass);
        ensure=findViewById(R.id.modify_ensure);
        back=findViewById(R.id.modify_query);


        //返回
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                finish();
            }
        });

        //确认
        ensure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String old_pas=old_pass.getText().toString();
                String new_pas=new_pass.getText().toString();
                String ensure_pas=ensure_new_pass.getText().toString();
                if(new_pass.getText().length()<6)
                    Toast.makeText(getApplicationContext(),"密码长度应大于6位", Toast.LENGTH_LONG).show();
                else if(new_pas.equals(ensure_pas)==false)
                    Toast.makeText(getApplicationContext(),"请输入相同的密码", Toast.LENGTH_LONG).show();
                else{
                    Intent intent=new Intent(ModifyActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
