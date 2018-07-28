package com.alan.aitstudentsupp0rt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class home_page extends AppCompatActivity {
    Intent n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    protected void attendance(View view){
        n=new Intent(com.alan.aitstudentsupp0rt.home_page.this,alterAttendace.class);
        startActivity(n);
    }

    protected void settings(View view){

    }

    protected void manage(View view){

    }


}
