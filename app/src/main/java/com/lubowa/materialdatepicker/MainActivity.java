package com.lubowa.materialdatepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private Calendar calendar;
    private int year,day, month;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);


    }

    public void checkDate(View v) throws ParseException {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("dd-M-yyyy");
        String dateInString = "24-07-2019";
        String anotherDate = "27-07-2019";
        Date date1 = simpledateformat.parse(dateInString);
        Date date2 = simpledateformat.parse(anotherDate);
        Calendar cal = Calendar.getInstance();
        Calendar cal1 = Calendar.getInstance();
        cal.setTime(date1);
        cal1.setTime(date2);
        Calendar[] days = {cal,cal1};

        datePickerDialog = DatePickerDialog.newInstance(MainActivity.this,year,month,day);
        datePickerDialog.setThemeDark(false);
        datePickerDialog.setTitle("Select Date From DatePickerDialog");
        datePickerDialog.show(getSupportFragmentManager(),"DatePickerDialog");
        datePickerDialog.setSelectableDays(days);

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = "Date: "+dayOfMonth+"/"+(monthOfYear+1)+"/"+year;

        Toast.makeText(MainActivity.this, date, Toast.LENGTH_LONG).show();
    }
}
