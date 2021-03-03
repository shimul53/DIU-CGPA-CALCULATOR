package com.example.diucgpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class SemesterActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout layout_list;
    Button add_btn,submit_btn;
    List<String> semester = new ArrayList<>();
    ArrayList<semester_cgpa> semester_cgpas_list =new ArrayList<>();

    private double totalCreditResult;
    private  String cgpa;
    int count = 0;

    private String creditNumber;
    private String sgpaNumber;
    private double gpaMulCredit;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester);

        layout_list = findViewById(R.id.layout_List);
        add_btn = findViewById(R.id.add_btn);
        submit_btn=findViewById(R.id.submit_btn);

        add_btn.setOnClickListener(this);
        submit_btn.setOnClickListener(this);

        semester.add("-select semester-");semester.add("Semester 1");semester.add("Semester 2");semester.add("Semester 3");
        semester.add("Semester 4");semester.add("Semester 5");semester.add("Semester 6");semester.add("Semester 7");
        semester.add("Semester 8");semester.add("Semester 9");semester.add("Semester 10");semester.add("Semester 11");
        semester.add("Semester 12");




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_btn:
                addView();
                break;

            case R.id.submit_btn:
                if (checkIfValidAndRead()){

                    Intent intent = new Intent(SemesterActivity.this,Adding_Semesters.class);
                    Bundle bundle = new Bundle();
                    intent.putExtra(Adding_Semesters.SCGPA,cgpa);
                    bundle.putSerializable("list",semester_cgpas_list);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    
                }
                break;
        }

    }

    private boolean checkIfValidAndRead() {
        semester_cgpas_list.clear();
        boolean result = true;

        for (int i = 0 ; i<layout_list.getChildCount(); i++){
            View addSemester = layout_list.getChildAt(i);

            Spinner semester_sp = (Spinner) addSemester.findViewById(R.id.semester_sp);
            EditText sgpa = (EditText)addSemester.findViewById(R.id.cgpa_text);
            EditText credit = (EditText)addSemester.findViewById(R.id.credit_text);

            semester_cgpa semester_cgpa = new semester_cgpa();
            if (semester_sp.getSelectedItemPosition() !=  0){
                semester_cgpa.setSemester_name(semester.get(semester_sp.getSelectedItemPosition()));
            }else {
                result =false;
                break;

            }
            if (!sgpa.getText().toString().equals("")){

              sgpaNumber = sgpa.getText().toString();
              semester_cgpa.setCgpa(sgpaNumber);


               // semester_cgpa.setCgpa(sgpa.getText().toString());
            }else {
                result = false;
                break;

            }


            if (!credit.getText().toString().equals("")){

              creditNumber = credit.getText().toString();
              semester_cgpa.setCredit(creditNumber);

                //semester_cgpa.setCredit(credit.getText().toString());

            }else {
                result = false;
                break;

            }
            gpaMulCredit += (Double.parseDouble(sgpaNumber) * Double.parseDouble(creditNumber));
            totalCreditResult += Double.parseDouble(creditNumber);

            semester_cgpas_list.add(semester_cgpa);
        }

        double round_cgpa = gpaMulCredit / totalCreditResult;
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        cgpa = String.valueOf(df.format(round_cgpa)) ;


        if (semester_cgpas_list.size() == 0){
            result = false;
            Toast.makeText(this,"ADD Semester First!",Toast.LENGTH_SHORT).show();
        }else if(!result) {
            Toast.makeText(this,"Enter All Details Correctly!",Toast.LENGTH_SHORT).show();

        }

        return result;
    }

    private void addView() {

        count++;
        if (count<=12){



        View addSemester = getLayoutInflater().inflate(R.layout.semester_wise_result,null,false);

        Spinner semester_sp = (Spinner) addSemester.findViewById(R.id.semester_sp);
        EditText cgpa = (EditText)addSemester.findViewById(R.id.cgpa_text);
        EditText credit = (EditText)addSemester.findViewById(R.id.credit_text);
        ImageView close = (ImageView)addSemester.findViewById(R.id.close);



        String[] semester = {"-select semester-","Semester 1","Semester 2","Semester 3","Semester 4","Semester 5","Semester 6"
        ,"Semester 7","Semester 8","Semester 9","Semester 10","Semester 11","Semester 12"};
        ArrayAdapter adapter =new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,semester);
        semester_sp.setAdapter(adapter);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeView(addSemester);
            }
        });
        layout_list.addView(addSemester);
        }else {
            Toast.makeText(this,"You can't take more than 12 semester",Toast.LENGTH_SHORT).show();
        }
    }
    private  void removeView(View v){
        layout_list.removeView(v);

    }
}