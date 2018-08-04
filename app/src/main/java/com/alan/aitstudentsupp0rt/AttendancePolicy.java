package com.alan.aitstudentsupp0rt;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class AttendancePolicy {
    boolean subjectwise ;
    boolean physical;
    boolean PL;
    int subLimit;
    int totalLimit;
    int physicalLimit;
    int PLlimit;
    SQLiteDatabase db;

    AttendancePolicy(){
        subjectwise = true;
        physical = true;
        PL = true;
        subLimit = 0;
        totalLimit = 0;
        physicalLimit = 0;
        PLlimit = 0;

    }

    AttendancePolicy(SQLiteDatabase db){
        Cursor c = c = db.rawQuery("SELECT * FROM policy",null);
        if(c.getCount()>0){
            c.moveToLast();
            subLimit = c.getInt(c.getColumnIndex("subjectwise"));
            subjectwise = subLimit != 0;
            totalLimit = c.getInt(c.getColumnIndex("total"));
            physicalLimit = c.getInt(c.getColumnIndex("physical"));
            physical = physicalLimit!=0;
            PLlimit = c.getInt(c.getColumnIndex("PL"));
            PL=PLlimit!=0;
        }
    }

    public int getAttendancelimit(){
        if(subjectwise){
            return subLimit;
        }else{
            return totalLimit;
        }
    }

    protected void obtain(Cursor c){
        if(c.getCount()>0){
            c.moveToLast();
            subLimit = c.getInt(c.getColumnIndex("subjectwise"));
            subjectwise = subLimit != 0;
            totalLimit = c.getInt(c.getColumnIndex("total"));
            physicalLimit = c.getInt(c.getColumnIndex("physical"));
            physical = physicalLimit!=0;
            PLlimit = c.getInt(c.getColumnIndex("PL"));
            PL=PLlimit!=0;
        }
    }

    protected String executeUpdate(){
        String query="UPDATE TABLE policy SET total = "+totalLimit+" , " +
                "subjectwise = "+subLimit+" , " +
                "physical = "+physicalLimit+" ," +
                "PL = "+PLlimit+" ";

        return query;
    }

    protected void settotalLimit(int k){
            totalLimit=k;
    }

    protected void setphysicalLimit(int k){
            physicalLimit=k;
            physical=true;
    }

    protected void setPLlimit(int k){
            PLlimit=k;
            PL=true;
    }

    protected void setsubLimit(int k){
            subLimit=k;
            subjectwise=true;
    }


}
