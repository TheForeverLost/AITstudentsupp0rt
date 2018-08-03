package com.alan.aitstudentsupp0rt;

public class subject {
    String subname;
    int total;
    int attended;
    AttendancePolicy atp;

    subject(AttendancePolicy attendancePolicy){
        subname=this.getClass().getName();
        total=0;
        attended=0;
        atp=attendancePolicy;
    }

    String getSubname(){
        return subname;
    }

    String getPercentage(){
        int p =0;
        if(total!=0){
            p = attended / total * 100;
        }
        String str = ""+p;
        return str;
    }

    String getBunks(){
        String str="";
        int p =0;
        int b= 0;
        if(total!=0){
            p = attended / total * 100;
            int tempatd = attended;
            int temptotal = total;
            while(true) {
                p = tempatd++ / temptotal++ * 100;
                if (p >= atp.getAttendancelimit()) {
                    b++;
                } else {
                    break;
                }
            }
        }
        str="You have "+b+" bunks remaining";
        return str;
    }

    void addAttendance(){
        attended++;
        total++;
    }

    void bunkClass(){
        total++;
    }

    void update(){
        //to add previous attendance
    }
}
