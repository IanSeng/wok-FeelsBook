package com.example.android.wok_feelsbook;

public class TooLongMessageException extends Exception {
    public TooLongMessageException() {
        super("Please make sure it is less than 100 Characters");
    }
}
