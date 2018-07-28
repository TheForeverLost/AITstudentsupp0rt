package com.alan.aitstudentsupp0rt;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.alan.aitstudentsupp0rt.AttendancePolicy;

public class alterAttendace extends AppCompatActivity {
    SQLiteDatabase db;
    Cursor c;
    EditText edsub,edphy,edPL,edTotal;
    CheckBox cbsub , cbphy , cbPL;
    AttendancePolicy atp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alter_attendace);

        edsub=(EditText) findViewById(R.id.editText3);
        cbsub=(CheckBox) findViewById(R.id.checkBox2);
        edphy=(EditText) findViewById(R.id.editText4);
        cbphy=(CheckBox) findViewById(R.id.checkBox3);
        edPL=(EditText) findViewById(R.id.editText5);
        cbPL=(CheckBox) findViewById(R.id.checkBox4);
        edTotal=(EditText) findViewById(R.id.editText2);

        try{
        db = openOrCreateDatabase("AITstudent",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS policy(total int(3),subjectwise int(3) DEFAULT 0,physical int(3) DEFAULT 0" +
                    ",PL int(3) DEFAULT 0)");

        c = db.rawQuery("SELECT * FROM policy",null);
        if(c.getCount()>0){
            c.moveToLast();
            atp.obtain(c);

            edTotal.setText(Integer.toString(atp.totalLimit));

            if(atp.subjectwise){
                edsub.setAlpha(1f);
                edsub.setText(Integer.toString(atp.subLimit));

            }else{
                edsub.setAlpha(0f);
                edsub.setText("");
            }
            cbsub.setChecked(atp.subjectwise);

            if(atp.physical){
                edphy.setAlpha(1f);
                edphy.setText(Integer.toString(atp.physicalLimit));
            }else{
                edphy.setAlpha(0f);
                edphy.setText("");
            }
            cbsub.setChecked(atp.physical);

            if(atp.PL){
                edPL.setAlpha(1f);
                edPL.setText(Integer.toString(atp.PLlimit));
            }else{
                edPL.setAlpha(0f);
                edPL.setText("");
            }
            cbsub.setChecked(atp.physical);

            Log.i("GE", "SO It works too");
        }

        }catch(SQLException e){}
    }

    protected void phyClicked(View view){
        edphy=(EditText) findViewById(R.id.editText4);
        cbphy=(CheckBox) findViewById(R.id.checkBox3);
        if(cbphy.isChecked()){
            edphy.setAlpha(1f);
        }else{
            edphy.setAlpha(0f);
        }
    }

    protected void subjectClicked(View view){
        edsub=(EditText) findViewById(R.id.editText3);
        cbsub=(CheckBox) findViewById(R.id.checkBox2);
        if(cbsub.isChecked()){
            edsub.setAlpha(1f);
        }else{
            edsub.setAlpha(0f);
        }

    }

    protected void PLclicked(View view){
        edPL=(EditText) findViewById(R.id.editText5);
        cbPL=(CheckBox) findViewById(R.id.checkBox4);
        if(cbPL.isChecked()){
            edPL.setAlpha(1f);
        }else{
            edPL.setAlpha(0f);
        }
    }

    protected void save(View view){
        //db.execSQL("DROP TABLE policy;");
        int flag=1;
        int totallimit = Integer.parseInt(edTotal.getText().toString());
        Log.i("nps", String.valueOf(totallimit));
        if(totallimit<100&&totallimit>0){
            atp.settotalLimit(totallimit);
        }else{
            flag=0;
        }

        if(cbphy.isChecked()){
            int physical= Integer.parseInt(edphy.getText().toString());
            if (physical<100&&physical>0){
                atp.setphysicalLimit(physical);
            }else{
                flag=0;
            }
        }

        if(cbsub.isChecked()){
            int subject= Integer.parseInt(edsub.getText().toString());
            if (subject<100&&subject>0){
                atp.setsubLimit(subject);
            }else{
                flag=0;
            }
        }

        if(cbPL.isChecked()){
            int PLc= Integer.parseInt(edPL.getText().toString());
            if (PLc>0){
                atp.setPLlimit(PLc);
            }else{
                flag=0;
            }
        }

        if(flag==0){
            clear();
            Toast.makeText(this,"Please input valid data" , Toast.LENGTH_SHORT).show();

        }else{
            String query=atp.executeUpdate();
            db.execSQL(query);
        }

    }

    public void clear(){
        edTotal.setText("");
        edsub.setText("");
        edphy.setText("");
        edPL.setText("");
        edsub.setAlpha(0f);
        edphy.setAlpha(0f);
        edPL.setAlpha(0f);
        cbphy.setChecked(false);
        cbPL.setChecked(false);
        cbsub.setChecked(false);
    }
}

