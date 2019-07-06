package com.example.capstoneshs;

public class EvaluationAverage {
    public EvaluationAverage(){}

    private int average_a, average_b;
    private String legend,student_id,teacher_id;

    public EvaluationAverage(int average_a, int average_b, String legend,String student_id, String teacher_id) {
        this.average_a = average_a;
        this.average_b = average_b;
        this.legend = legend;
        this.student_id = student_id;
        this.teacher_id = teacher_id;
    }

    public int getAverage_a() {
        return average_a;
    }

    public void setAverage_a(int average_a) {
        this.average_a = average_a;
    }

    public String getLegend() {
        return legend;
    }

    public void setLegend(String legend) {
        this.legend = legend;
    }

    public int getAverage_b() {
        return average_b;
    }

    public void setAverage_b(int average_b) {
        this.average_b = average_b;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }
}
