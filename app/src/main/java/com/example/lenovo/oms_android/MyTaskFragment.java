package com.example.lenovo.oms_android;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by lenovo on 2018/4/19.
 */

public class MyTaskFragment extends Fragment {
    public MyTaskFragment(){}

    UserMainUiActivity userMainUiActivity;
    private ListView listView;
    ArrayAdapter<String> adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.project_all_list,container,false);
        listView=view.findViewById(R.id.list_room);
        String[] projects={"test","test1"};
        adapter = new ArrayAdapter<String>(userMainUiActivity, android.R.layout.simple_list_item_1, projects);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item=(String) adapter.getItem(i);
                Intent intent=new Intent(userMainUiActivity,ProjectInfoActivity.class);
                intent.putExtra("name",item);
                startActivity(intent);
            }
        });
        return view;
    }

    public void setActivity(UserMainUiActivity userMainUiActivity){
        this.userMainUiActivity=userMainUiActivity;
    }
}
