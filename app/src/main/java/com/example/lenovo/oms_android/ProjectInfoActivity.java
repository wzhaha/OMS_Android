package com.example.lenovo.oms_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by lenovo on 2018/4/20.
 */

public class ProjectInfoActivity extends AppCompatActivity {
    private TextView name;
    private TextView id;
    private TextView intro;
    private TextView start;
    private TextView end;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_info);
        Intent intent=this.getIntent();
        Bundle bundle=intent.getExtras();

        name=findViewById(R.id.project_name);
        id=findViewById(R.id.project_id);
        intro=findViewById(R.id.project_intro);
        start=findViewById(R.id.project_start);
        end=findViewById(R.id.project_end);


        name.setText(bundle.getString("name"));
        id.setText(bundle.getString("name"));
        intro.setText(bundle.getString("name"));
        start.setText("2018-03-17");
        end.setText("2018-10-31");
    }
}
