package com.example.android.wok_feelsbook;

import java.util.Date;

public abstract class Emotion {
    private Date date;
    private String message;

    public Emotion (){
        this.message = "Default message";
    }

    public String getMessage(){
        return this.message = message;
    }

    public String toString(){
        return this.message + " " + this.date;
    }
}
