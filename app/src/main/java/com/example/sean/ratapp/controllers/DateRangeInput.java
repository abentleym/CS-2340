package com.example.sean.ratapp.controllers;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

public class DateRangeInput extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    public EditText textDate;
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        String date = day + " " + (month+1) + " " + year;
        textDate.setText(date);
    }
    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_sighting_range);

        Button button = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Button pressed!!!");
            }
        });


        DatePickerDialog.OnDateSetListener datePickFrag = new DatePickerDialog.OnDateSetListener () {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                System.out.println("Date set!!!");
            }
        };

        DatePickerDialog dpd = new DatePickerDialog(this, datePickFrag, 2017, 10, 29) {

        };
    }*/
}
