package com.example.diucgpacalculator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class semesterAdapter  extends RecyclerView.Adapter<semesterAdapter.semesterView> {
    ArrayList<semester_cgpa> semesterList = new ArrayList<>();

    public semesterAdapter(ArrayList<semester_cgpa> semesterList) {
        this.semesterList = semesterList;
    }

    @NonNull
    @Override
    public semesterView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_subject,parent,false);
        return new semesterView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull semesterView holder, int position) {
        semester_cgpa semester_cgpa = semesterList.get(position);
        holder.semester_tv.setText(semester_cgpa.getSemester_name());
        holder.cgpa_tv.setText(semester_cgpa.getCgpa());
        holder.credit_tv.setText(semester_cgpa.getCredit());

    }

    @Override
    public int getItemCount() {
        return semesterList.size();
    }

    public class semesterView extends RecyclerView.ViewHolder{
        TextView semester_tv,credit_tv,cgpa_tv;




        public semesterView(@NonNull View itemView) {
            super(itemView);


            semester_tv = (TextView)itemView.findViewById(R.id.semester_tv);
            credit_tv = (TextView)itemView.findViewById(R.id.credit_tv);
            cgpa_tv = (TextView)itemView.findViewById(R.id.cgpa_tv);
        }
    }
}
