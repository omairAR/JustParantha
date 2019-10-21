package com.example.omairar.hinditranslation;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    public void releaseMediaPlayer(){
        if(mediaPlayer!=null){
            mediaPlayer.release();

            mediaPlayer=null;
        }
    }


    private MediaPlayer.OnCompletionListener mOnCompletionListener=new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("red","laal",R.drawable.color_red,R.raw.colors01));
        words.add(new Word("yellow","peela",R.drawable.color_mustard_yellow,R.raw.colors02));
        words.add(new Word("dark yellow","gahara peela",R.drawable.color_dusty_yellow,R.raw.colors03));
        words.add(new Word("green","hara",R.drawable.color_green,R.raw.colors04));
        words.add(new Word("brown","bhoora",R.drawable.color_brown,R.raw.colors05));
        words.add(new Word("pink","gulaabee",R.drawable.color_pink,R.raw.colors06));
        words.add(new Word("black","kala",R.drawable.color_black,R.raw.colors07));
        words.add(new Word("white","saphed",R.drawable.color_white,R.raw.colors08));

        WordAdapter adapter = new WordAdapter(this,words,R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();

                Word word = words.get(position);

                mediaPlayer=MediaPlayer.create(ColorsActivity.this,word.getmRawResource());

                mediaPlayer.start();

                mediaPlayer.setOnCompletionListener(mOnCompletionListener);
            }
        });






    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}