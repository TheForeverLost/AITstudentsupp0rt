package com.alan.aitstudentsupp0rt;

import android.database.sqlite.SQLiteDatabase;

public class AttendancePolicy {
    boolean subjectwise ;
    boolean physical;
    boolean total;
    boolean PL;
    int subLimit;
    int totalLimit;
    int physicalLimit;
    int PLlimit;
    SQLiteDatabase db;

    AttendancePolicy(){
        subjectwise = true;
        physical = true;
        total = true;
        PL = true;
        subLimit = 0;
        totalLimit = 0;
        physicalLimit = 0;
        PLlimit = 0;

    }


}
