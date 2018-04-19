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
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Entity.ProjectItem;
import Networks.RestClient;

/**
 * Created by lenovo on 2018/4/19.
 */

public class AllTasksFragment extends Fragment {
    public AllTasksFragment(){}
    private ListView listView;
    List<ProjectItem>  projectItems =new ArrayList<ProjectItem>();;

    ArrayAdapter<String> adapter;
    UserMainUiActivity userMainUiActivity;
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.project_all_list,container,false);
        listView=view.findViewById(R.id.list_room);

//        List<String> projects=new ArrayList<String>();
//            for(int i=0;i<projectItems.size();i++)
//                projects.add(projectItems.get(i).getName());
        String[] projects={"test","test1","test2"};
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

    public void getProjects(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    projectItems=RestClient.getInstance().getProjects();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void setActivity(UserMainUiActivity userMainUiActivity){
        this.userMainUiActivity=userMainUiActivity;
    }
}
