package com.example.sabbir.icare;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddVaccine extends AppCompatActivity {

    private EditText vName;
    private EditText pickDate;
    private EditText pickTime;
    private EditText showDetail;
    private EditText dailyRemainder;
    private int mYear, mMonth, mDay;
    public int year,month,day,mHour,mMinute;

    static final int DATE_DIALOG_ID=0;
    static final int TIME_DILOG_ID=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__vaccine);
        vName=(EditText)findViewById(R.id.vName);
        pickDate=(EditText)findViewById(R.id.pickDate);
        pickTime= (EditText) findViewById(R.id.pickTime);
        showDetail=(EditText)findViewById(R.id.showDetail);
        dailyRemainder=(EditText)findViewById(R.id.showDetail);

        Calendar ca=Calendar.getInstance();
        mYear=ca.get(Calendar.YEAR);
        mMonth=ca.get(Calendar.MONTH);
        mDay=ca.get(Calendar.DAY_OF_MONTH);

        pickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });
        pickTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(TIME_DILOG_ID);
            }
        });
        dailyRemainder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra("beginTime", cal.getTimeInMillis());
                intent.putExtra("allDay", false);
                intent.putExtra("rrule", "FREQ=DAILY");
                intent.putExtra("endTime", cal.getTimeInMillis()+60*60*1000);
                intent.putExtra("title", "A Test Event from android app");
                startActivity(intent);
            }
        });
    }
    private DatePickerDialog.OnDateSetListener mDateSetlistener=
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    year = year;
                    month = monthOfYear+1;
                    day = dayOfMonth;
                    pickDate.setText(day + "-" + month + "-" + year);
                }
            };
    private TimePickerDialog.OnTimeSetListener onTimeSetListener=
            new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    Calendar calendar=Calendar.getInstance();
                    calendar.set(0,0,0,hourOfDay,minute,0);
                    long timeInMillis=calendar.getTimeInMillis();
                    java.text.DateFormat dateFormat=new SimpleDateFormat("hh:mm a");
                    pickTime.setText(dateFormat.format(timeInMillis));
                }
            };
    protected Dialog onCreateDialog(int id){
        switch (id){
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,
                        mDateSetlistener,mYear,mMonth,mDay);

            case TIME_DILOG_ID:
                return new TimePickerDialog(this,
                        onTimeSetListener,mHour,mMinute,false);
        }
        return null;
    }

    }

