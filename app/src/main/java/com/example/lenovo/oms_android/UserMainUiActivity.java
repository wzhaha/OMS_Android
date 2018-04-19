package com.example.lenovo.oms_android;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


/**
 * Created by lenovo on 2018/4/19.
 */

public class UserMainUiActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    private RadioGroup rpTab;
    private RadioButton all_tasks,my_task,my_info;
    private UserInfoFragment fg3;
    private AllTasksFragment fg1;
    private MyTaskFragment  fg2;
    private TextView textView;

    String id;
    String role;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_main);
        rpTab = findViewById(R.id.rd_group);
        all_tasks = (RadioButton)findViewById(R.id.all_tasks_menu);
        my_task = (RadioButton)findViewById(R.id.my_task_menu);
        my_info = (RadioButton)findViewById(R.id.my_info_menu);
        textView=findViewById(R.id.txt_topbar);


        bindView();
    }

    private void bindView() {
        rpTab.setOnCheckedChangeListener(this);
        my_info.setChecked(true);
    }

    public void hideAllFragment(FragmentTransaction transaction){
        if(fg1!=null){
            transaction.hide(fg1);
        }
        if(fg2!=null){
            transaction.hide(fg2);
        }
        if(fg3!=null){
            transaction.hide(fg3);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        switch (checkedId){
            case R.id.all_tasks_menu:
                if(fg1==null){
                    fg1 = new AllTasksFragment();
                    transaction.add(R.id.fragment_container,fg1);
                }else{
                    transaction.show(fg1);
                }
                textView.setText("全部任务");
                break;
            case R.id.my_task_menu:
                if(fg2==null){
                    fg2 = new MyTaskFragment();
                    transaction.add(R.id.fragment_container,fg2);
                }else{
                    transaction.show(fg2);
                }
                textView.setText("我的任务");
                break;
            case R.id.my_info_menu:
                if(fg3==null){
                    fg3 = new UserInfoFragment();
                    transaction.add(R.id.fragment_container,fg3);
                }else{
                    transaction.show(fg3);
                }
                textView.setText("个人中心");

                break;
        }
        transaction.commit();
    }

}
