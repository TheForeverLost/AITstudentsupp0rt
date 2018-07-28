package com.alan.aitstudentsupp0rt;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
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
                c = db.rawQuery("Select * from users",null);
                if(c!=null) {
                    c.moveToFirst();
                    int nameindex=c.getColumnIndex("name");
                    String name=c.getString(nameindex);
                    message.setText("hi "+name);
                    rep.setText("click next to continue");
                    rep.setEnabled(false);
                    choice=1;
                }else{
                    message.setText("Hi enter your name");
                    rep.setText("");
                    choice = 2;
                    Log.i("GG", "Choice = 2");
                }
            }catch(Exception e){
                Log.i("GG", e.getMessage());
            }



        }catch (Exception e){
            Log.i("GG", "exception ran");
        }

    }

    protected void next(View view){
        Log.i("GG", Integer.toString(choice) );
        Intent b;
        switch (choice){
            case 1:
                Toast.makeText(this , "already in database" , Toast.LENGTH_LONG).show();
                b=new Intent(com.alan.aitstudentsupp0rt.open.this,home_page.class);
                startActivity(b);
                break;

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

                Toast.makeText(this , "added to database" , Toast.LENGTH_LONG).show();
                b=new Intent(com.alan.aitstudentsupp0rt.open.this,alterAttendace.class);
                startActivity(b);
                break;


        }

    }
}
