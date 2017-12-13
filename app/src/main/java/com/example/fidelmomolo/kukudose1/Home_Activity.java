package com.example.fidelmomolo.kukudose1;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Html;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.Locale;

public class Home_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,TextToSpeech.OnInitListener  {
    MaterialSearchView searchView;
    TextToSpeech engine;
    float pitchRate=1f,speedRate=1f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Kuku Dose");
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        search_code();// calling search view to act

        engine=new TextToSpeech(this,this);//initiallizing the TTS engine




    }

    private void search_code() {
        searchView=(MaterialSearchView)findViewById(R.id.search_view);
        searchView.setSuggestions(getResources().getStringArray(R.array.clubs));

        searchView.setHint("Quick disease search");

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
           @Override
           public boolean onQueryTextSubmit(String query) {


               return false;
           }

           @Override
           public boolean onQueryTextChange(String newText) {
               return false;
           }
       });



       searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
           @Override
           public void onSearchViewShown() {

           }

           @Override
           public void onSearchViewClosed() {

           }
       });


       searchView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               String query=String.valueOf(parent.getItemAtPosition(position)).toUpperCase();


               if(query.equals("CHELSEA")){

                   Toast.makeText(Home_Activity.this,"You have clicked"+query,Toast.LENGTH_LONG).show();

                   return;

               }



           }
       });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if(searchView.isSearchOpen()){

            searchView.closeSearch();
        }



        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_, menu);

        MenuItem item= menu.findItem(R.id.action_search255);
        searchView.setMenuItem(item);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_TTS) {
            Toast.makeText(Home_Activity.this,"You have selected TTS",Toast.LENGTH_LONG).show();
            speak();
            return true;
        }
       else if (id == R.id.action_settings) {
            Toast.makeText(Home_Activity.this,"You have selected settings",Toast.LENGTH_LONG).show();
            return true;
        }

        else {
        return super.onOptionsItemSelected(item);}
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_contacts) {

        } else if (id == R.id.nav_videos) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_organism) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    @Override
    public void onInit(int status) {
    //It hosts the tts engine

        if(status==TextToSpeech.SUCCESS){

            engine.setLanguage(Locale.UK);
        }


    }


    private void speak() {
        engine.setPitch(pitchRate);
        engine.setSpeechRate(speedRate);

        String man="am the beast";
        String lady="practise makes perfect";

        String[]clubs=new String[]{

                "The categories of poultry diseases discussed in the app include:",
                "1. Respiratory diseases",
                "2. Behavioural diseases",
                "3. Intestinal diseases"


        };

        for (int i=0;i<clubs.length;i++){

            engine.speak(clubs[i]+"\n",TextToSpeech.QUEUE_ADD,null,null);}

    }


}
