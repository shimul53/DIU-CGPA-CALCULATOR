package com.example.diucgpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
   Button semester_wise,subject_wise;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        semester_wise = (Button)findViewById(R.id.semester_wise);
        subject_wise = (Button)findViewById(R.id.subject_wise);

        semester_wise.setOnClickListener(this);
        subject_wise.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.semester_wise){
            Intent intent = new Intent(HomeActivity.this, SemesterActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.subject_wise){
            Intent intent = new Intent(HomeActivity.this, CourseWiseActivity.class);
            startActivity(intent);
        }

    }
}