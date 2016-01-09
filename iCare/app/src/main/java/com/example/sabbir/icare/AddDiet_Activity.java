package com.example.sabbir.icare;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AddDiet_Activity extends AppCompatActivity  {
     private EditText pickDate,pickTime;

     private Spinner dietSpinner;
    private CheckBox dailyAlarm;
    private CheckBox dailyRemainder;
    AlarmManager am;

    String diets[]= {"Select diet type", "Breakfast","Lunch","Dinner"};

    static final int DATE_DIALOG_ID=0;
    static final int TIME_DILOG_ID=1;
    public int year,month,day,hour,minute, mHour,mMinute;
    private int mYear, mMonth, mDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_diet_activity);
        pickDate=(EditText)findViewById(R.id.pickDate);
        pickTime=(EditText)findViewById(R.id.pickTime);
        dietSpinner=(Spinner)findViewById(R.id.dietSpinner);
        dailyAlarm=(CheckBox)findViewById(R.id.dailyAlarm);
        dailyRemainder=(CheckBox)findViewById(R.id.dailyRemainder);

        am=(AlarmManager)getSystemService(Context.ALARM_SERVICE);


        ArrayAdapter<String> spinnerArrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,diets);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dietSpinner.setAdapter(spinnerArrayAdapter);


         Calendar ca=Calendar.getInstance();
        mYear=ca.get(Calendar.YEAR);
        mMonth=ca.get(Calendar.MONTH);
        mDay=ca.get(Calendar.DAY_OF_MONTH);
        dailyAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction("com.techpalle.action.ALARM_RECEIVER");
                PendingIntent pen=PendingIntent.getBroadcast(getApplicationContext(),0,intent,0);
                am.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+5000,pen);
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


    }
    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {


                public void onDateSet(DatePicker view, int yearSelected,
                                      int monthOfYear, int dayOfMonth) {
                    year = yearSelected;
                    month = monthOfYear+1;
                    day = dayOfMonth;

                    pickDate.setText(day + "-" + month + "-" + year);
                }
            };
    private TimePickerDialog.OnTimeSetListener mTimeSetListener =
            new TimePickerDialog.OnTimeSetListener() {

                public void onTimeSet(TimePicker view, int hourOfDay, int min) {

                    Calendar calendar = Calendar.getInstance();
                    calendar.set(0, 0, 0, hourOfDay, min, 0);
                    long timeInMillis = calendar.getTimeInMillis();
                    java.text.DateFormat dateFormatter = new SimpleDateFormat("hh:mm a");

                    pickTime.setText(dateFormatter.format(timeInMillis));


                }
            };

        protected Dialog onCreateDialog(int id){
            switch (id){
                case DATE_DIALOG_ID:
                    return new DatePickerDialog(this,
                            mDateSetListener,mYear,mMonth,mDay);

                case TIME_DILOG_ID:
                    return new TimePickerDialog(this,
                            mTimeSetListener,mHour,mMinute,false);
            }
            return null;
        }


}
