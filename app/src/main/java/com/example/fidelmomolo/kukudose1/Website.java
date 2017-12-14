package com.example.fidelmomolo.kukudose1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
                R.drawable.fresheggs,
                R.drawable.poultrysite,
                R.drawable.paapak,
                R.drawable.smallholder,
                R.drawable.backyard,
                R.drawable.reddit,
                R.drawable.poultryworld,
                R.drawable.poultryhub_logo


        };


        ListAdapter lady=new Custom_RecyclerAdapter(this,description,imgid);

        listView.setAdapter(lady);
        listeners();


    }


    public void listeners(){
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            int item=parent.getPositionForView(view);



             if (item==7) {


                String url = "http://www.poultryhub.org";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
           else if (item==0) {


                String url = "http://fresheggsdaily.com/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }

            else if (item==1) {


                String url = "http://www.thepoultrysite.com/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
            else if (item==2) {


                String url = "http://papaak.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
            else if (item==3) {


                String url = "http://www.smallholder.co.uk/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
            else if (item==4) {

                Toast.makeText(Website.this, "You hav " + item, Toast.LENGTH_LONG).show();
                String url = "https://www.backyardchickens.com/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
            else if (item==5) {


                String url = "https://www.reddit.com/r/poultry/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
            else if (item==6) {


                String url = "http://www.poultryworld.net/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }



        }
    });

    }

}
