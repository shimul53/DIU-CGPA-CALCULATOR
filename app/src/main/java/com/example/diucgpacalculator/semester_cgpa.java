package com.example.diucgpacalculator;

import java.io.Serializable;

public class semester_cgpa implements Serializable {
    public String semester_name ;
    public String cgpa;
    public String credit;


    public semester_cgpa() {
    }

    public semester_cgpa(String semester_name, String cgpa, String credit) {
        this.semester_name = semester_name;
        this.cgpa = cgpa;
        this.credit = credit;

    }

    public String getSemester_name() {
        return semester_name;
    }

    public void setSemester_name(String semester_name) {
        this.semester_name = semester_name;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }


}
