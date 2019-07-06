package com.example.capstoneshs;

public class AttendanceClass {
    private String date,time_in_am,time_out_am,time_in_pm,time_out_pm,user_id;
    public  AttendanceClass(){}

    public AttendanceClass(String date, String time_in_am, String time_out_am, String time_in_pm, String time_out_pm, String user_id) {
        this.date = date;
        this.time_in_am = time_in_am;
        this.time_out_am = time_out_am;
        this.time_in_pm = time_in_pm;
        this.time_out_pm = time_out_pm;
        this.user_id = user_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime_in_am() {
        return time_in_am;
    }

    public void setTime_in_am(String time_in_am) {
        this.time_in_am = time_in_am;
    }

    public String getTime_out_am() {
        return time_out_am;
    }

    public void setTime_out_am(String time_out_am) {
        this.time_out_am = time_out_am;
    }

    public String getTime_in_pm() {
        return time_in_pm;
    }

    public void setTime_in_pm(String time_in_pm) {
        this.time_in_pm = time_in_pm;
    }

    public String getTime_out_pm() {
        return time_out_pm;
    }

    public void setTime_out_pm(String time_out_pm) {
        this.time_out_pm = time_out_pm;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
