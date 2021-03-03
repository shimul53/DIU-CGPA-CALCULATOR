package com.example.diucgpacalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class AddingCourseActivity extends AppCompatActivity {

    RecyclerView adding_course_recview;
    ArrayList<course_cgpa> course_cgpa_list = new ArrayList<>();
    public static final String GPA = "GPA";
    TextView cgpa_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_course);

        adding_course_recview = findViewById(R.id.adding_course_recview);
        cgpa_result = findViewById(R.id.cgpa_result);

        Intent i = getIntent();
        cgpa_result.setText(i.getStringExtra(GPA));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        adding_course_recview.setLayoutManager(layoutManager);

        course_cgpa_list = (ArrayList<course_cgpa>) getIntent().getExtras().getSerializable("course");
        adding_course_recview.setAdapter(new courseAdapter(course_cgpa_list));
    }
}