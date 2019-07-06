package com.example.capstoneshs;

public class EvaluationAverageTeacher {
    private String average_a,average_b,legend,user_id,teacher_id;

    public EvaluationAverageTeacher(String average_a, String average_b, String legend, String user_id, String teacher_id) {
        this.average_a = average_a;
        this.average_b = average_b;
        this.legend = legend;
        this.user_id = user_id;
        this.teacher_id = teacher_id;
    }

    public String getAverage_a() {
        return average_a;
    }

    public void setAverage_a(String average_a) {
        this.average_a = average_a;
    }

    public String getAverage_b() {
        return average_b;
    }

    public void setAverage_b(String average_b) {
        this.average_b = average_b;
    }

    public String getLegend() {
        return legend;
    }

    public void setLegend(String legend) {
        this.legend = legend;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }
}
