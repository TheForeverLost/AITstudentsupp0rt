package com.alan.aitstudentsupp0rt;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.sql.SQLException;
import java.util.ArrayList;

public class manage extends AppCompatActivity {

    SQLiteDatabase db;
    ArrayList<subject> subjects;
    AttendancePolicy atp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);

        try{
            db=this.openOrCreateDatabase("AITstudent",MODE_PRIVATE,null);
            atp=new AttendancePolicy(db);
            db.execSQL("CREATE TABLE IF NOT EXISTS subject(name varchar ,attended int(3),total int(3))");

            Cursor c = db.rawQuery("SELECT * FROM subject",null);
            int num = c.getCount();

            RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvsubject);

            if(num>0){
                // Initialize contacts
                subjects = subject.createsubjectsList(num, atp);
                // Create adapter passing in the sample user data
                subjectAdapter adapter = new subjectAdapter(subjects);
                // Attach the adapter to the recyclerview to populate items
                rvContacts.setAdapter(adapter);
                // Set layout manager to position the items
                rvContacts.setLayoutManager(new LinearLayoutManager(this));
                // That's all!
            }

        }catch(Exception e){

        }

    }
}
