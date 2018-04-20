package com.example.lenovo.oms_android;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by lenovo on 2018/4/19.
 */

public class UserInfoFragment extends Fragment {

    private  String id=null;
    private  String role=null;
    private Button logout;
    private Button modpwd;
    UserMainUiActivity userMainUiActivity;
    public UserInfoFragment(){
    }

    //个人中心
    private TextView user_id;
    private TextView user_name;
    private TextView user_role;
    private TextView email;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_info,container,false);
        user_id=view.findViewById(R.id.tv_userID);
        user_name=view.findViewById(R.id.tv_userName);
        user_role=view.findViewById(R.id.user_info_role);
        email=view.findViewById(R.id.tv_email);
        logout=view.findViewById(R.id.btn_logOut);
        modpwd=view.findViewById(R.id.btn_modPwd);
        //退出登录事件
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(userMainUiActivity,MainActivity.class);
                startActivity(intent);
            }
        });

        //修改密码事件
        modpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(userMainUiActivity,ModifyActivity.class);
                startActivity(intent);
            }
        });

        //set user info
        user_id.setText(id);
        user_role.setText(role);
        user_name.setText("haha");
        email.setText("haha@qq.com");
        return view;
    }
    public void setBundle(Bundle bundle){
        id=bundle.getString("id");
        role=bundle.getString("role");
    }
    public void setActivity(UserMainUiActivity userMainUiActivity){
        this.userMainUiActivity=userMainUiActivity;
    }

}
