package com.example.lenovo.oms_android;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lenovo on 2018/4/19.
 */

public class UserInfoFragment extends Fragment {

    private  String id=null;
    private  String role=null;
    public UserInfoFragment(){
    }

    //个人中心
    private TextView user_id;
    private TextView user_name;
    private TextView user_role;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_info,container,false);
        user_id=view.findViewById(R.id.tv_userID);
        user_name=view.findViewById(R.id.tv_userName);
        user_role=view.findViewById(R.id.user_info_role);

        //set user info
        user_id.setText(id);
        user_role.setText(role);
        user_name.setText("haha");

        return view;
    }
}
