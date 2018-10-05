package com.example.android.wok_feelsbook;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment {
    private String date;
    private String message;
    private String emoMessage;

    Comment(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd'T'hh:mm:ss");
        this.date = simpleDateFormat.format(new Date());
        this.message = "Default message";
        this.emoMessage ="Default emo message";
    }


    Comment(String message){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd'T'hh:mm:ss");
        this.date = simpleDateFormat.format(new Date());
        this.message = message;
        this.emoMessage = emoMessage;
    }


    public String getDate(){
        return this.date;
    }

    public String getMessage(){
        return message;
    }

    public String getEmoMessage(){return emoMessage;}

    public void setMessage(String message) throws TooLongMessageException {
        if (message.length()>100){
            throw new TooLongMessageException();
        }
        this.message = message;
    }

    public String setDate(String date){
        return this.date = date;
    }

    public void setEmoMessage(final String emo) {
        this.emoMessage = emo;
    }

    public String toString(){
        return this.emoMessage+"\n"+this.message + "\t (" + this.date+")";
    }
}


