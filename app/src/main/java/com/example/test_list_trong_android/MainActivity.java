package com.example.test_list_trong_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    ListView listView;
    StudentListViewAdapter studentListViewAdapter;
    ArrayList<Student> listStudent;


    Button buttonDatePicker, buttonUpdate;
    EditText editTextName, editTextId;
    CheckBox checkBox;
    AutoCompleteTextView autoCompleteTextView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewDatePicker);

        buttonUpdate = findViewById(R.id.button_Nhapsv);

        editTextName = findViewById(R.id.edittext_name);
        editTextId = findViewById(R.id.editext_id);

        checkBox=findViewById(R.id.checkbox_sex);
        autoCompleteTextView = findViewById(R.id.autoComplete);


        String[] text = {"Ha noi", "Thanh hoa", "Bac Ninh"};
        ArrayAdapter<String> adapter_spin = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, text);

        autoCompleteTextView.setAdapter(adapter_spin);

        listView = findViewById(R.id.list_view_user);
        listStudent = new ArrayList<>();
        studentListViewAdapter = new StudentListViewAdapter(listStudent);
        listView.setAdapter(studentListViewAdapter);


        buttonDatePicker = findViewById(R.id.button_date_Picker);
        buttonDatePicker.setOnClickListener(v -> {
            DatePickerFragment datePickerFragment = new DatePickerFragment();
            datePickerFragment.show(getSupportFragmentManager(), "datePicker");

        });

        buttonUpdate.setOnClickListener(v -> {
            listStudent.add(
                    new Student(editTextId.getText().toString(),
                            editTextName.getText().toString(),
                            Checkgender(),
                            textView.getText().toString(),
                            autoCompleteTextView.getText().toString()
                            )
            );
            studentListViewAdapter.notifyDataSetChanged();
        });

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        textView.setText(currentDateString);

    }

    public String Checkgender(){
        if(checkBox.isChecked()){
            return "Nu";
        }
        else  return "Nam";
    }

}