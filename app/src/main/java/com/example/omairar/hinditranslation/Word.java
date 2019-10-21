package com.example.omairar.hinditranslation;

public class Word {

    private String mDefaultTranslation;

    private String mHindiTranslation;

    private int mImageresourceID=NO_IMAGE_PROVIDED;

    private final static int NO_IMAGE_PROVIDED=-1;

    private int mRawResource;

    public Word(String mDefaultTranslation, String mHindiTranslation,int mRawResource){

        this.mDefaultTranslation=mDefaultTranslation;
        this.mHindiTranslation=mHindiTranslation;

        this.mRawResource=mRawResource;

    }

    public Word(String mDefaultTranslation, String mHindiTranslation, int mImageresourceID, int mRawResource){

        this.mDefaultTranslation=mDefaultTranslation;
        this.mHindiTranslation=mHindiTranslation;
        this.mImageresourceID=mImageresourceID;

        this.mRawResource=mRawResource;

    }

    public String getmDefaultTranslation(){ return mDefaultTranslation;}

    public String getmHindiTranslation(){return mHindiTranslation;}


    public int getmImageresourceID(){return mImageresourceID;}

    public boolean hasImage(){
        if(mImageresourceID!=-1){
            return true;
        }else {
            return false;
        }
    }

    public int getmRawResource(){return  mRawResource;}
}
