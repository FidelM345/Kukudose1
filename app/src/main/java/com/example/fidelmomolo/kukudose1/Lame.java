package com.example.fidelmomolo.kukudose1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Lame extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lame);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView=(ListView) findViewById(R.id.list_lame);

        String[]description=getResources().getStringArray(R.array.lame_diseases);

        Integer[] imgid={
                R.drawable.fresheggs,
                R.drawable.avian_influenza,
                R.drawable.infectious_bronchitis,
                R.drawable.laryngotracheitis

        };

        ListAdapter lady=new CustomAdapter(this,description,imgid);

        listView.setAdapter(lady);
    }

}
