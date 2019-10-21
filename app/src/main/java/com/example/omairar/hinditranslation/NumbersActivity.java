package com.example.omairar.hinditranslation;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

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

        words.add(new Word("one","ek",R.drawable.number_one,R.raw.numbers01));
        words.add(new Word("two","do",R.drawable.number_two,R.raw.numbers02));
        words.add(new Word("three","teen",R.drawable.number_three,R.raw.numbers03));
        words.add(new Word("four","chaar",R.drawable.number_four,R.raw.numbers04));
        words.add(new Word("five","paanch",R.drawable.number_five,R.raw.numbers05));
        words.add(new Word("six","chhah",R.drawable.number_six,R.raw.numbers06));
        words.add(new Word("seven","saat",R.drawable.number_seven,R.raw.numbers07));
        words.add(new Word("eight","aath",R.drawable.number_eight,R.raw.numbers08));
        words.add(new Word("nine","nau",R.drawable.number_nine,R.raw.numbers09));
        words.add(new Word("ten","das",R.drawable.number_ten,R.raw.numbers10));


        WordAdapter adapter = new WordAdapter(this,words,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               releaseMediaPlayer();

                Word word = words.get(position);

                mediaPlayer=MediaPlayer.create(NumbersActivity.this,word.getmRawResource());

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
