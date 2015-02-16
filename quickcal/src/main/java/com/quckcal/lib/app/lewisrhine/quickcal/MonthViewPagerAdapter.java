package com.quckcal.lib.app.lewisrhine.quickcal;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by lewisrhine on 2/6/15.
 */
public class MonthViewPagerAdapter extends PagerAdapter {
    Context context;

    private Date currentSelectedDate;
    //private currentMonthView;

    private String currentMonthName;


    private List<Date> markedDates = new ArrayList<>();

    List<Calendar> list = new ArrayList<>();

    LayoutInflater layoutInflater;



    public MonthViewPagerAdapter(Context context) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        for (int i = 20; i > 0; i--) {
            Calendar calendarYear = Calendar.getInstance();
            int currentYear = calendarYear.get(Calendar.YEAR) - i;
            calendarYear.set(Calendar.YEAR, currentYear);
            for (int ii = 0; ii < 12; ii++) {
                calendarYear = Calendar.getInstance();
                calendarYear.set(Calendar.YEAR, currentYear);
                calendarYear.set(Calendar.MONTH, ii);
                list.add(calendarYear);
            }
        }
        for (int i = 0; i < 12; i++) {
            Calendar calendarYear = Calendar.getInstance();
            calendarYear.set(Calendar.MONTH, i);
            list.add(calendarYear);
        }
        for (int i = 1; i < 20; i++) {
            Calendar calendarYear = Calendar.getInstance();
            int currentYear = calendarYear.get(Calendar.YEAR) + i;
            calendarYear.set(Calendar.YEAR, currentYear);
            for (int ii = 0; ii < 12; ii++) {
                calendarYear = Calendar.getInstance();
                calendarYear.set(Calendar.YEAR, currentYear);
                calendarYear.set(Calendar.MONTH, ii);
                list.add(calendarYear);
            }
        }
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        MonthView monthView = new MonthView(context);
        MonthViewAdapter monthViewAdapter = new MonthViewAdapter(context, list.get(position));
        monthViewAdapter.markDate(markedDates);
        monthView.setAdapter(monthViewAdapter);


        monthView.setColumnWidth(90);
        monthView.setNumColumns(7);
        monthView.setVerticalSpacing(10);
        monthView.setHorizontalSpacing(10);
        monthView.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
        monthView.setGravity(Gravity.CENTER);
        monthView.setId(position);

        container.addView(monthView);


        return monthView;
    }



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((MonthView) object);
    }


    public Date getDateFromPosition(int position){
        Date date = new Date();
        date.setTime(list.get(position).getTimeInMillis());

        return date;
    }

   public int getDatePosition(Date date){
       Calendar calendarFromDate = Calendar.getInstance();

       calendarFromDate.setTime(date);

       for (int i = 0; i <list.size(); i++ ){
           if (list.get(i).get(Calendar.YEAR) ==
                   calendarFromDate.get(Calendar.YEAR) &&
                   list.get(i).get(Calendar.MONTH) ==
                   calendarFromDate.get(Calendar.MONTH)){
               return i;
           }
       }

       return 0;
   }

   public void markDate(Date date){
       markedDates.add(date);
       checkForMarkedDays();
   }

   private void checkForMarkedDays(){

   }


}
