package com.example.diucgpacalculator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class courseAdapter extends RecyclerView.Adapter<courseAdapter.courseView> {

    ArrayList<course_cgpa> courseList = new ArrayList<>();

    public courseAdapter(ArrayList<course_cgpa> courseList)
    {
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public courseView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_row,parent,false);

        return new courseView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull courseView holder, int position) {

        course_cgpa course_cgpa = courseList.get(position);
        holder.course_tv.setText(course_cgpa.getCourse_code());
        holder.gpa_tv.setText(course_cgpa.getCourse_cgpa());
        holder.course_credit_tv.setText(course_cgpa.getCourse_credit());

    }

    @Override
    public int getItemCount()
    {
        return courseList.size();
    }

    public class courseView extends RecyclerView.ViewHolder{
        TextView course_tv,gpa_tv,course_credit_tv;


        public courseView(@NonNull View itemView) {
            super(itemView);

            course_tv = (TextView)itemView.findViewById(R.id.course_tv);
            gpa_tv = (TextView)itemView.findViewById(R.id.gpa_tv);
            course_credit_tv = (TextView)itemView.findViewById(R.id.course_credit_tv);



        }
    }
}
