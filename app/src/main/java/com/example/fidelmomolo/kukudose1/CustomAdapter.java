package com.example.fidelmomolo.kukudose1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by amisa on 12/12/17.
 */

public class CustomAdapter extends ArrayAdapter<String>{

    private final String[]description;
    private final Integer[]imgid;

    public CustomAdapter(@NonNull Context context, int resource, String[] description, String[] food, Integer[] imgid) {
        super(context, resource);
        this.description = description;
        this.imgid = imgid;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //the code represents a single row on the list view widget
        LayoutInflater layoutInflater=LayoutInflater.from(getContext());
        View customView=layoutInflater.inflate(R.layout.activity_types,parent,false);


        //code for getting each single text item on the list
        // String getfooditem=getItem(position);

        TextView textView1=(TextView)customView.findViewById(R.id.text125);
        TextView textView=(TextView)customView.findViewById(R.id.text1);
        ImageView imageView34=(ImageView)customView.findViewById(R.id.image65);


        textView1.setText(description[position]);

        imageView34.setImageResource(imgid[position]);


        return customView;


    }

}
