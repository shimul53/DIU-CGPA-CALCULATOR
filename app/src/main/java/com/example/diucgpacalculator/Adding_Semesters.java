package com.example.diucgpacalculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adding_Semesters extends AppCompatActivity {
    RecyclerView adding_semester_recView;
    ArrayList<semester_cgpa> semester_cgpas_list = new ArrayList<>();
    public static final String SCGPA = "SCGPA";
    TextView sgpa_result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adding_semesters);

        adding_semester_recView = findViewById(R.id.adding_semester_recView);
        sgpa_result = findViewById(R.id.sgpa_result);

        Intent i = getIntent();
        sgpa_result.setText(i.getStringExtra(SCGPA));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        adding_semester_recView.setLayoutManager(layoutManager);

        semester_cgpas_list = (ArrayList<semester_cgpa>) getIntent().getExtras().getSerializable("list");
        adding_semester_recView.setAdapter(new semesterAdapter(semester_cgpas_list));



    }
}
