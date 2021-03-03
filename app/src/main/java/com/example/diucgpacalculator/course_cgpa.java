package com.example.diucgpacalculator;


import java.io.Serializable;

public class course_cgpa implements Serializable {
    public String course_code;
    public String course_cgpa;
    public String course_credit;

    public course_cgpa() {
    }

    public course_cgpa(String course_code, String course_cgpa, String course_credit) {
        this.course_code = course_code;
        this.course_cgpa = course_cgpa;
        this.course_credit = course_credit;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getCourse_cgpa() {
        return course_cgpa;
    }

    public void setCourse_cgpa(String course_cgpa) {
        this.course_cgpa = course_cgpa;
    }

    public String getCourse_credit() {
        return course_credit;
    }

    public void setCourse_credit(String course_credit) {
        this.course_credit = course_credit;
    }
}
