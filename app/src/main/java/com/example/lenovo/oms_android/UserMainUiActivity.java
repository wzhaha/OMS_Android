package com.example.lenovo.oms_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by lenovo on 2018/4/19.
 */

public class UserMainUiActivity extends AppCompatActivity {

    private TextView userId;
    private TextView name;
    private TextView userRole;
    private Button btn_logout;
    @Override
    protected void onCreate(Bundle saved){
        setContentView(R.layout.user_info);
        super.onCreate(saved);
        name=findViewById(R.id.tv_userName);
        userId=findViewById(R.id.tv_userID);
        userRole=findViewById(R.id.user_info_role);

        btn_logout=findViewById(R.id.btn_logOut);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(1,new Intent());
                finish();
            }
        });
        Intent it=this.getIntent();
        Bundle bundle=it.getExtras();
        String userid=bundle.getString("userid");
        userId.setText(userid);
        userRole.setText(bundle.getString("role"));
        name.setText("wangzhi");
    }


}
