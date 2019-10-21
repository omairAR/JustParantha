package com.example.omairar.hinditranslation;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceID;

    public WordAdapter(Activity context, ArrayList<Word> words, int mColorResourceID){
        super(context,0,words);
        this.mColorResourceID=mColorResourceID;

    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView==null){
            listItemView=LayoutInflater.from(getContext()).inflate(R.layout.list_layout,parent,false);
        }



        Word currentWord = getItem(position);

        TextView defaultTRANS= (TextView) listItemView.findViewById(R.id.defaultTRANS);

        defaultTRANS.setText(currentWord.getmDefaultTranslation());


        TextView hinidiTRANS= (TextView) listItemView.findViewById(R.id.hindi_TRANS);

        hinidiTRANS.setText(currentWord.getmHindiTranslation());

        int color = ContextCompat.getColor(getContext(),mColorResourceID);

        View textContainer = listItemView.findViewById(R.id.text_container);

        textContainer.setBackgroundColor(color);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.list_image);

        if(currentWord.hasImage()){
            imageView.setImageResource(currentWord.getmImageresourceID());
            imageView.setVisibility(View.VISIBLE);
        }else {
            imageView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
