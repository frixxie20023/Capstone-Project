package com.example.capstoneshs;

public class ScheduleClass {

    private String start_time,end_time,subject,class_room,section;

    public ScheduleClass(String start_time, String end_time, String subject, String class_room, String section) {
        this.start_time = start_time;
        this.end_time = end_time;
        this.subject = subject;
        this.class_room = class_room;
        this.section = section;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getClass_room() {
        return class_room;
    }

    public void setClass_room(String class_room) {
        this.class_room = class_room;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
