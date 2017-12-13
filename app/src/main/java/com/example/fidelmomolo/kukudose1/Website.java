package com.example.fidelmomolo.kukudose1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Website extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView=(ListView) findViewById(R.id.list_web);

        String[]description=getResources().getStringArray(R.array.web_description);
        Integer[] imgid={
                R.drawable.chelsea,
                R.drawable.chicken1,
                R.drawable.chicken1


        };


        ListAdapter lady=new CustomAdapter(this,description,imgid);

        listView.setAdapter(lady);


    }


    public void listeners(){
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            int item=parent.getPositionForView(view);
        }
    });

    }

}
