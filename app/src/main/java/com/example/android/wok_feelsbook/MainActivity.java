package com.example.android.wok_feelsbook;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
/*
 *Name: Ian Seng Wok
 *
 */
public class MainActivity extends Activity {

    private static final String FILENAME = "file.sav";
    private ListView listView;
    private EditText editText;
    Button loveButton;
    Button joyButton;
    Button surpriseButton;
    Button angryButton;
    Button sadButton;
    Button fearButton;
    Button saveButton;
    ArrayAdapter<Comment> adapter;
    ArrayList<Comment> ListCommentArrayList;
    Comment comment;


    /*
     *This class is to create button
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loveButton = (Button) findViewById(R.id.Love);
        joyButton = (Button) findViewById(R.id.Joy);
        surpriseButton = (Button) findViewById(R.id.Surprise);
        angryButton = (Button) findViewById(R.id.Angry);
        sadButton = (Button) findViewById(R.id.Sad);
        fearButton = (Button) findViewById(R.id.Fear);
        listView = (ListView) findViewById(R.id.oldComment);
        editText = (EditText) findViewById(R.id.commontText);
        saveButton = (Button) findViewById(R.id.save);
        ListCommentArrayList = new ArrayList<Comment>();
        //adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,ListCommentArrayList);
        //adapter = new ArrayAdapter<Comment>(MainActivity.this, android.R.layout.simple_list_item_1, ListCommentArrayList);
        //listView.setAdapter(adapter);
        final String text = editText.getText().toString();
        saveButton.setEnabled(false);



        loveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               try{
                   Toast.makeText(getApplicationContext(),"Saved Love",Toast.LENGTH_LONG).show();
                   comment = new Love();
                   comment.setMessage(text);
                   ListCommentArrayList.add(comment);
                   adapter.notifyDataSetChanged();
                   counter();
                   saveButton.setEnabled(true);
                   sortList();
                   saveInFile();
               }catch (TooLongMessageException e) {
                   e.printStackTrace();
                   Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();

               }

            }
        });

        joyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                try{
                    Toast.makeText(getApplicationContext(),"Saved Joy",Toast.LENGTH_LONG).show();
                    comment = new Joy();
                    comment.setMessage(text);
                    ListCommentArrayList.add(comment);
                    adapter.notifyDataSetChanged();
                    counter();
                    saveButton.setEnabled(true);
                    sortList();
                    saveInFile();
                } catch (TooLongMessageException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();

                }

            }
        });
        surpriseButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                try{
                    Toast.makeText(getApplicationContext(),"Saved Surprise",Toast.LENGTH_LONG).show();
                    comment = new Surprise();
                    comment.setMessage(text);
                    ListCommentArrayList.add(comment);
                    adapter.notifyDataSetChanged();
                    counter();
                    saveButton.setEnabled(true);
                    sortList();
                    saveInFile();
                } catch (TooLongMessageException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }

            }
        });
        angryButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                try{
                    Toast.makeText(getApplicationContext(),"Saved Angry",Toast.LENGTH_LONG).show();
                    comment = new Angry();
                    comment.setMessage(text);
                    ListCommentArrayList.add(comment);
                    adapter.notifyDataSetChanged();
                    counter();
                    saveButton.setEnabled(true);
                    sortList();
                    saveInFile();
                }catch (TooLongMessageException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }

            }
        });

        /*
         *This class is to
         */
        sadButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                try{
                    Toast.makeText(getApplicationContext(),"Saved Sad",Toast.LENGTH_LONG).show();
                    comment = new Sad();
                    comment.setMessage(text);
                    ListCommentArrayList.add(comment);
                    adapter.notifyDataSetChanged();
                    counter();
                    saveButton.setEnabled(true);
                    sortList();
                    saveInFile();
                }catch (TooLongMessageException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }

            }
        });
        fearButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                try {
                    Toast.makeText(getApplicationContext(),"Saved Fear",Toast.LENGTH_LONG).show();
                    comment = new Fear();
                    comment.setMessage(text);
                    ListCommentArrayList.add(comment);
                    adapter.notifyDataSetChanged();
                    counter();
                    saveButton.setEnabled(true);
                    sortList();
                    saveInFile();
                }catch (TooLongMessageException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }

            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try{
                    String text = editText.getText().toString();
                    ListCommentArrayList.get(ListCommentArrayList.size()-1).setMessage(text);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_LONG).show();
                    saveButton.setEnabled(false);
                    sortList();
                    saveInFile();
                }catch (TooLongMessageException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }

            }
        });
        registerForContextMenu(listView);

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list, menu);
        menu.setHeaderTitle("Select The Action");
    }



    public boolean onContextItemSelected(MenuItem item){

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if(item.getItemId()==R.id.edit2){
            int Position = info.position;
            String comment = ListCommentArrayList.get(Position).toString();
            showInputBox(comment,Position);
            Toast.makeText(getApplicationContext(),"Edit",Toast.LENGTH_LONG).show();
            return true;
         } else if(item.getItemId()==R.id.delete){
                final Comment comment = ListCommentArrayList.get(info.position);
                /*final String emoTest = comment.getEmoMessage();

                if (emoTest == "Love"){
                    loveCounter--;
                    loveButton.setText("Love"+" ("+loveCounter+")");

                }else if (emoTest == "Joy"){
                    joyCounter--;
                    joyButton.setText("Joy"+" ("+joyCounter+")");

                }else if (emoTest == "Surprise"){
                    surpriseCounter--;
                    surpriseButton.setText("Surprise"+" ("+surpriseCounter+")");

                }else if (emoTest == "Angry"){
                    angryCounter--;
                    angryButton.setText("Angry"+" ("+angryCounter+")");

                }else if (emoTest == "Sad"){
                    sadCounter--;
                    sadButton.setText("Sad"+" ("+sadCounter+")");

                }else if (emoTest == "Fear"){
                    fearCounter++;
                    sadButton.setText("Sad"+" ("+fearCounter+")");

                } */
                ListCommentArrayList.remove(info.position);
                adapter.notifyDataSetChanged();
                counter();
                saveInFile();
                Toast.makeText(getApplicationContext(),"Delete",Toast.LENGTH_LONG).show();
                return true;
        }
        return false;
    }

    public void showInputBox (String oldIteam, final int index){

        final Dialog dialog = new Dialog(MainActivity.this);
        //dialog.setTitle("Edit Box");
        dialog.setContentView(R.layout.edit_box);


        final Comment comment = ListCommentArrayList.get(index);
        final String oldComment = comment.getMessage();
        final EditText newComment = dialog.findViewById(R.id.newCommentInput);
        newComment.setText(oldComment.toString());

        //TextView textMessage = (TextView) dialog.findViewById(R.id.textInput);
        //textMessage.setText("Update item");

        final String oldTime = comment.getDate();
        final EditText newTime = dialog.findViewById(R.id.newTimeInput);
        newTime.setText(oldTime.toString());
        /*final EditText editText2 = (EditText)dialog.findViewById(R.id.textInput);
        editText2.setText((CharSequence) oldIteam);*/
        Button editButton= (Button) dialog.findViewById(R.id.edit);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ListCommentArrayList.get(index).setMessage(newComment.getText().toString());
                } catch (TooLongMessageException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"Delete",Toast.LENGTH_LONG).show();
                }
                ListCommentArrayList.get(index).setDate(newTime.getText().toString());
                dialog.dismiss();
                adapter.notifyDataSetChanged();
                sortList();
                saveInFile();
            }
        });
        dialog.show();
    }

    public void sortList(){
        Collections.sort(ListCommentArrayList, new Comparator<Comment>() {
            @Override
            public int compare(Comment o1, Comment o2) {
                return o1.getDate().compareToIgnoreCase(o2.getDate());
            }
        });
    }


    protected void onStart() {
            // TODO Auto-generated method stub
            super.onStart();
            loadFromFile();
            counter();
            adapter = new ArrayAdapter<Comment>(this, android.R.layout.simple_list_item_1, ListCommentArrayList);
            listView.setAdapter(adapter);


    }

    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);

            Gson gson = new Gson();
            Type typeListTweets = new TypeToken<ArrayList<Comment>>() {
            }.getType();
            ListCommentArrayList = gson.fromJson(reader, typeListTweets);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    0);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter writer = new BufferedWriter(osw);

            Gson gson = new Gson();
            gson.toJson(ListCommentArrayList,osw);
            writer.flush();
            writer.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void counter(){
        int loveCounter = 0;
        int joyCounter = 0;
        int surpriseCounter = 0;
        int angryCounter = 0;
        int sadCounter = 0;
        int fearCounter = 0;
        for (Comment c: ListCommentArrayList){
            String cmt = c.getEmoMessage();

            if (cmt.equals("Love")){
                loveCounter++;

            }else if (cmt.equals("Joy")){
                joyCounter++;

            }else if (cmt.equals("Surprise")){
                surpriseCounter++;

            }else if (cmt.equals("Angry")){
                angryCounter++;

            }else if (cmt.equals("Sad")){
                sadCounter++;

            }else if (cmt.equals("Fear")){
                fearCounter++;
            }

        }
        loveButton.setText("Love"+"("+loveCounter+")");
        joyButton.setText("Joy"+" ("+joyCounter+")");
        surpriseButton.setText("Surprise"+" ("+surpriseCounter+")");
        angryButton.setText("Angry"+" ("+angryCounter+")");
        sadButton.setText("Sad"+" ("+sadCounter+")");
        fearButton.setText("Fear"+" ("+fearCounter+")");


    }


}
