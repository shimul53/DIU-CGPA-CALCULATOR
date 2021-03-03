package com.example.diucgpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class CourseWiseActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout course_layout_list;
    Button add_Btn,submit_Btn;
    ArrayList<course_cgpa> course_cgpa_list = new ArrayList<>();

    private double creditTotal;
    private  String gpa;

    private String courseCode;
    private String creditNum;
    private String gpaNum;
    private double gpaMultiCredit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_wise);

        course_layout_list = findViewById(R.id.course_layout_list);
        add_Btn = findViewById(R.id.add_Btn);
        submit_Btn = findViewById(R.id.submit_Btn);

        add_Btn.setOnClickListener(this);
        submit_Btn.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.add_Btn:
                addCourseView();
                break;

            case R.id.submit_Btn:
                if (CheckValid()){

                    Intent intent = new Intent(CourseWiseActivity.this,AddingCourseActivity.class);
                    Bundle bundle = new Bundle();
                    intent.putExtra(AddingCourseActivity.GPA,gpa);
                    bundle.putSerializable("course",course_cgpa_list);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }
                break;
        }

    }

    private boolean CheckValid() {
       course_cgpa_list.clear();
        boolean courseResult = true;

        for (int i = 0; i<course_layout_list.getChildCount(); i++){
            View addCourse = course_layout_list.getChildAt(i);

            EditText course_Code  = (EditText)addCourse.findViewById(R.id.course_code);
            EditText cgpa_Text_View = (EditText)addCourse.findViewById(R.id.cgpa_Text);
            EditText credit_Text_View = (EditText)addCourse.findViewById(R.id.credit_Text);

            course_cgpa course_cgpa = new course_cgpa();

            if (!course_Code.getText().toString().equals("")){
                courseCode = course_Code.getText().toString();
                course_cgpa.setCourse_code(courseCode);
            }else {
                courseResult = false;
                break;
            }

            if (!cgpa_Text_View.getText().toString().equals("")){
                gpaNum = cgpa_Text_View.getText().toString();
                course_cgpa.setCourse_cgpa(gpaNum);
            }else {
                courseResult = false;
                break;
            }

            if (!credit_Text_View.getText().toString().equals("")){
                creditNum = credit_Text_View.getText().toString();
                course_cgpa.setCourse_credit(creditNum);
            }else {
                courseResult = false;
                break;
            }

            gpaMultiCredit += (Double.parseDouble(gpaNum) * Double.parseDouble(creditNum));
            creditTotal += Double.parseDouble(creditNum);

            course_cgpa_list.add(course_cgpa);

        }
        double round_cgpa_result =  gpaMultiCredit / creditTotal;
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        gpa = String.valueOf(df.format(round_cgpa_result)) ;

        if (course_cgpa_list.size() == 0){
            courseResult = false;
            Toast.makeText(this,"ADD Semester First!",Toast.LENGTH_SHORT).show();
        }else if(!courseResult) {
            Toast.makeText(this,"Enter All Details Correctly!",Toast.LENGTH_SHORT).show();

        }

        return courseResult;
    }

    private void addCourseView() {

        View addCourse = getLayoutInflater().inflate(R.layout.course_wise_result,null,false);

        EditText course_code  = (EditText)addCourse.findViewById(R.id.course_code);
        EditText cgpa_Text = (EditText)addCourse.findViewById(R.id.cgpa_Text);
        EditText credit_Text = (EditText)addCourse.findViewById(R.id.credit_Text);
        ImageView close_icon = (ImageView)addCourse.findViewById(R.id.close_icon);

        close_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeCourseView(addCourse);


            }
        });
        course_layout_list.addView(addCourse);

    }
    private void removeCourseView(View v){
        course_layout_list.removeView(v);
    }
}