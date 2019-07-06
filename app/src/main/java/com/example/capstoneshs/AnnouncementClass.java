package com.example.capstoneshs;

public class AnnouncementClass {
    String message,date,subject,location,time;

    public AnnouncementClass(String message, String date, String subject, String location, String time) {
        this.message = message;
        this.date = date;
        this.subject = subject;
        this.location = location;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
