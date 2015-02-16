package com.quckcal.lib.app.lewisrhine.quickcal;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by lewisrhine on 2/6/15.
 */
public class MonthViewAdapter extends BaseAdapter {

    Context context;
    Calendar calendar;
    Calendar currentDay = Calendar.getInstance();

    private List<DayView> dayViewList = new ArrayList<>();

    private List<Date> markedDates =  new ArrayList<>();

    int month;
    private Integer[] daysWithOffSet;

    Integer[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public MonthViewAdapter(Context context, Calendar calendar) {
        this.context = context;
        this.calendar = calendar;
        this.month = calendar.get(Calendar.MONTH);

        setDaysWithOffSet();
    }

    @Override
    public int getCount() {
        return daysWithOffSet.length;
    }

    @Override
    public DayView getItem(int position) {
        return dayViewList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        DayView dayView;
        if (convertView == null) {
            dayView = new DayView(context);
            dayView.setLayoutParams(new GridView.LayoutParams(85, 85));
            dayView.setPadding(8, 8, 8, 8);
            dayView.setGravity(Gravity.CENTER);

        } else {
            dayView = (DayView) convertView;
        }


        if (daysWithOffSet[position] == 0) {
            dayView.setVisibility(View.INVISIBLE);
        } else dayView.setText(daysWithOffSet[position].toString());

        if (calendar.get(Calendar.YEAR) == currentDay.get(Calendar.YEAR)
                && calendar.get(Calendar.MONTH) == currentDay.get(Calendar.MONTH)
                && position == currentDay.get(Calendar.DAY_OF_MONTH)-1){
                dayView.setToday(true);

        }

        for (Date date : markedDates){
            Calendar markedDatCal = Calendar.getInstance();
            markedDatCal.setTime(date);

            if (calendar.get(Calendar.YEAR) == markedDatCal.get(Calendar.YEAR)
                && calendar.get(Calendar.MONTH) == markedDatCal.get(Calendar.MONTH)
                && position == markedDatCal.get(Calendar.DAY_OF_MONTH)) {
                dayView.setMarked(true);
                Log.d("LR", "cal day " + calendar.get(Calendar.DAY_OF_MONTH) + " mark cal day " + position);

            }

        }




        dayViewList.add(dayView);
        return dayView;
    }


    private void setDaysWithOffSet(){

        daysWithOffSet = new Integer[getFirstDayOfMonth() + daysInMonth[month]-1];

        int dayNumber =1;

        for (int i=0; i< daysWithOffSet.length; i++){
            if (i < getFirstDayOfMonth()-1){
                daysWithOffSet[i] = 0;
            } else {
                daysWithOffSet[i] = dayNumber;
                dayNumber++;
            }
        }
    }


    public int getFirstDayOfMonth(){
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        Date date = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("EE");
        //String dayAsString = dateFormat.format(date);

        switch (dateFormat.format(date)){
            case "Sun":
                return 1;
            case "Mon":
                return 2;
            case "Tue":
                return 3;
            case "Wed":
                return 4;
            case "Thu":
                return 5;
            case "Fri":
                return 6;
            case "Sat":
                return 7;

        }
        System.out.println("First Day of Month: " + dateFormat.format(date));
        return 0;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
        this.month = calendar.get(Calendar.MONTH);
        setDaysWithOffSet();
    }

    public String getMonthName() {

        Date date = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("MMMMM yyyy");
        return dateFormat.format(date);
    }

    public Date getDate(){
        return calendar.getTime();
    }

    public void markDate(List<Date> markedDates){
        this.markedDates = markedDates;

    }
}
