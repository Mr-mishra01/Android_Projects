package com.example.recyclerviewex;

import android.graphics.Bitmap;

public class ContactModel {
    Bitmap img;
    String contName , contNum ;

    public ContactModel (Bitmap image , String contName,String contNum ){

        this.img = image;
        this.contName = contName;
        this.contNum = contNum;


    }
    public ContactModel (String name , String number){
      this.contNum = number;
      this.contName = name;
    }







}
