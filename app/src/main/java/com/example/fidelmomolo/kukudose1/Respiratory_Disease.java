package com.example.fidelmomolo.kukudose1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Respiratory_Disease extends AppCompatActivity {
ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respiratory__disease);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView=(ListView) findViewById(R.id.list_res);

        String[]description=getResources().getStringArray(R.array.Respiratory_diseases);

        Integer[] imgid={
                R.drawable.fresheggs,
                R.drawable.avian_influenza,
                R.drawable.infectious_bronchitis,
                R.drawable.laryngotracheitis

        };

        ListAdapter lady=new CustomAdapter(this,description,imgid);

        listView.setAdapter(lady);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int number=parent.getPositionForView(view);

                if(number==0){

                    Intent i=new Intent(Respiratory_Disease.this,NewCastleActivity.class);
                    startActivity(i);
                }

               else if(number==1){

                    Intent i=new Intent(Respiratory_Disease.this,AvianInfluenzaActivity.class);
                    startActivity(i);
                }
               else if(number==2){

                    Intent i=new Intent(Respiratory_Disease.this,InfectiousBronchitiesActivity.class);
                    startActivity(i);
                }
                else if(number==3){

                    Intent i=new Intent(Respiratory_Disease.this,LaryngotracheitisActivity.class);
                    startActivity(i);
                }

            }
        });



    }

}
