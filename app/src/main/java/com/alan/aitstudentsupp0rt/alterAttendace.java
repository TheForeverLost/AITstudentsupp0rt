package com.alan.aitstudentsupp0rt;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class alterAttendace extends AppCompatActivity {
    SQLiteDatabase db;
    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alter_attendace);
        try{
        db = openOrCreateDatabase("AITstudent",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS policy(ID int(3),name varchar,total int(3),subjectwise int(3) DEFAULT 0,physical int(3) DEFAULT 0" +
                    ",PL int(3) DEFAULT 0)");
        c = db.rawQuery("SELECT * FROM policy",null);
        if(c!=null){

        }

        }catch(SQLException e){}
    }

    protected void phyClicked(View view){
        EditText ed=(EditText) findViewById(R.id.editText4);
        CheckBox cb=(CheckBox) findViewById(R.id.checkBox3);
        if(cb.isChecked()){
            ed.setAlpha(1f);
        }else{
            ed.setAlpha(0f);
        }
    }

    protected void subjectClicked(View view){
        EditText ed=(EditText) findViewById(R.id.editText3);
        CheckBox cb=(CheckBox) findViewById(R.id.checkBox2);
        if(cb.isChecked()){
            ed.setAlpha(1f);
        }else{
            ed.setAlpha(0f);
        }

    }

    protected void PLclicked(View view){
        EditText ed=(EditText) findViewById(R.id.editText5);
        CheckBox cb=(CheckBox) findViewById(R.id.checkBox4);
        if(cb.isChecked()){
            ed.setAlpha(1f);
        }else{
            ed.setAlpha(0f);
        }
    }

    protected void save(View view){

    }
}
