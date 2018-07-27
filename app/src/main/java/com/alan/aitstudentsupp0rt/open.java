package com.alan.aitstudentsupp0rt;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class open extends AppCompatActivity {
    public int choice =0;
    private SQLiteDatabase db;
    private Cursor c;
    private TextView message;
    private EditText rep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
        try{
            rep=(EditText)findViewById(R.id.editText);
            message = (TextView) findViewById(R.id.textView);
            db=this.openOrCreateDatabase("AITstudent",MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR,passordBool INT(1) DEFAULT 0,password varchar ,logtime timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL)");
            try{
                db.execSQL("DELETE FROM users");
            }catch(Exception e){

            }
            message.setText("Hi enter your name");
            rep.setText("");
            choice = 2;
            Log.i("GG", "Choice = 2");


        }catch (Exception e){
            Toast.makeText(this , "on create error" , Toast.LENGTH_LONG);
            Log.i("GG", "exception ran");
        }

    }

    protected void next(View view){
        Log.i("GG", Integer.toString(choice) );

        switch (choice){
            case 1:
                    Toast.makeText(this , "already in database" , Toast.LENGTH_LONG);
            case 2:
                String user=rep.getText().toString();
                db.execSQL("INSERT INTO users(name) VALUES('"+ user +"')");
                choice = 3 ;
                break;
            case 3:
                rep.setEnabled(false);
                message.setText("click next to continue");
                choice = 4;
                break;
            case 4:

                Toast.makeText(this , "added to database" , Toast.LENGTH_LONG);
                Intent b=new Intent(com.alan.aitstudentsupp0rt.open.this,home_page.class);
                startActivity(b);
                break;


        }

    }
}
