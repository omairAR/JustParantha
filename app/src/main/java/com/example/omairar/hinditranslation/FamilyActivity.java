package com.example.omairar.hinditranslation;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

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

        words.add(new Word("father","pita",R.drawable.family_father,R.raw.family01));
        words.add(new Word("mother","maan",R.drawable.family_mother,R.raw.family02));
        words.add(new Word("son","beta",R.drawable.family_son,R.raw.family03));
        words.add(new Word("daughter","betee",R.drawable.family_daughter,R.raw.family04));
        words.add(new Word("older brother","bada bhaee",R.drawable.family_older_brother,R.raw.family05));
        words.add(new Word("younger brother","chhota bhaee",R.drawable.family_younger_brother,R.raw.family06));
        words.add(new Word("older sister","badi bahan",R.drawable.family_older_sister,R.raw.family07));
        words.add(new Word("younger sister","chootee bahan",R.drawable.family_younger_sister,R.raw.family08));
        words.add(new Word("grandmother","daadee ma",R.drawable.family_grandmother,R.raw.family09));
        words.add(new Word("grandfather","daada",R.drawable.family_grandfather,R.raw.family10));


        WordAdapter adapter = new WordAdapter(this,words,R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();

                Word word = words.get(position);

                mediaPlayer=MediaPlayer.create(FamilyActivity.this,word.getmRawResource());

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