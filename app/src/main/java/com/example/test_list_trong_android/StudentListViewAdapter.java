package com.example.test_list_trong_android;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentListViewAdapter extends BaseAdapter {
    ArrayList<Student> listStudent=null;

    public StudentListViewAdapter(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
    }

    @Override
    public int getCount() {
        return listStudent.size();
    }

    @Override
    public Object getItem(int position) {
        return listStudent.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewStudent = null;
        if (convertView == null) {
            viewStudent = View.inflate(parent.getContext(), R.layout.student_item_liatview, null);
            Student student = (Student) getItem(position);
            ((TextView) viewStudent.findViewById(R.id.textView1)).setText((String)String.format("%s" + " - " + "%s", student.getId(), student.getName()));
            ((TextView) viewStudent.findViewById(R.id.textView2)).setText((String)String.format("%s" + " - " + "%s" + " - " + "%s", student.getSex(), student.getDateOfBirth(), student.getDirthplace()));
        }
        return viewStudent;
    }
}
