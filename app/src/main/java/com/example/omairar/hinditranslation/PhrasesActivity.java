package com.example.omairar.hinditranslation;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

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

        words.add(new Word("Where are you going ?","tum kahaan ja rahe ho?",R.raw.phrases01));
        words.add(new Word("What is your name ?","tumhaara naam kya he?",R.raw.phrases02));
        words.add(new Word("My name is ..","mera naam hai...",R.raw.phrases03));
        words.add(new Word("How are you feeling ?","aap kaisa mahasoos kar rahe hain ?",R.raw.phrases04));
        words.add(new Word("I’m feeling good","main achchha mahasoos kar raha hoon",R.raw.phrases05));
        words.add(new Word("Are you comming ?","kya tum aa rahe ho?",R.raw.phrases06));
        words.add(new Word("Yes, I’m Comming","haan main aa raha hoon",R.raw.phrases07));
        words.add(new Word("I’m comming","main aa raha hoon",R.raw.phrases08));
        words.add(new Word("Let’s go","chalo chalate hain",R.raw.phrases09));
        words.add(new Word("Come here","yahaan aao",R.raw.phrases10));


        WordAdapter adapter = new WordAdapter(this,words,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();

                Word word = words.get(position);

                mediaPlayer=MediaPlayer.create(PhrasesActivity.this,word.getmRawResource());

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
