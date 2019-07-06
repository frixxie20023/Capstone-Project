package com.example.capstoneshs;

public class EvaluationAverageStudent {
    public EvaluationAverageStudent(){}

    private int average_a, average_b,average_c,average_d;
    private String legend,student_id,teacher_id;

    public EvaluationAverageStudent(int average_a, int average_b, int average_c, int average_d, String legend, String student_id, String teacher_id) {
        this.average_a = average_a;
        this.average_b = average_b;
        this.average_c = average_c;
        this.average_d = average_d;
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

    public int getAverage_b() {
        return average_b;
    }

    public void setAverage_b(int average_b) {
        this.average_b = average_b;
    }

    public int getAverage_c() {
        return average_c;
    }

    public void setAverage_c(int average_c) {
        this.average_c = average_c;
    }

    public int getAverage_d() {
        return average_d;
    }

    public void setAverage_d(int average_d) {
        this.average_d = average_d;
    }

    public String getLegend() {
        return legend;
    }

    public void setLegend(String legend) {
        this.legend = legend;
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
