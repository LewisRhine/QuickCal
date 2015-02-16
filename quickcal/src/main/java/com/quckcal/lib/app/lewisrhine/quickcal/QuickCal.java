package com.quckcal.lib.app.lewisrhine.quickcal;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by lewisrhine on 2/5/15.
 */
public class QuickCal extends LinearLayout implements ViewPager.OnPageChangeListener {

    private Context context;
    private Calendar calendar;
    private Date currentSelectedDate;

    private boolean isOpen = false;
    private int expandHigh;

    private int currentMonthViewHight;

    private DayOfWeekHeader dayOfWeekHeader;
    private MonthViewPager monthViewPager;
    private MonthViewPagerAdapter monthViewPagerAdapter;
    private TextView monthText;


    public QuickCal(Context context) {
        super(context);
        this.context = context;
        addChildren();
    }

    public QuickCal(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        addChildren();


    }

    public QuickCal(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        addChildren();


    }



    public void markDate(Date date){
        if (monthViewPagerAdapter != null){
            monthViewPagerAdapter.markDate(date);
        }

    }



    public Date getSelectedDay(){

        // give the currently selected day
        return null;
    }

    public void setCurrentSelectedDate() {
        MonthView currentMonthView;
        MonthViewAdapter currentMonthViewAdapter;

        if (monthViewPager != null) {

            currentMonthView = (MonthView) monthViewPager.getChildAt(monthViewPager.getCurrentItem());
            currentMonthViewAdapter = (MonthViewAdapter) currentMonthView.getAdapter();

            this.currentSelectedDate = currentMonthViewAdapter.getDate();

            if (monthText != null) {

                monthText.setText(currentMonthViewAdapter.getMonthName());
            }
///        this.currentSelectedDate = currentSelectedDate;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN : {
                //startY = motionEvent.getY();
                Log.d("LR", "Down");
                //expand(monthViewPager);
                break ;
            }
            case MotionEvent.ACTION_UP: {
                float endY = event.getY();
                Log.d("LR", "UP");
                //collapse(monthViewPager);
                //if (endY < startY) {
                //    System.out.println("Move UP");
                //    ll.setVisibility(View.VISIBLE);

                //}
                // else {
                // ll.setVisibility(View.GONE);
                // }
            }

        }
        return true;
    }

    private void collapseQuickCal(){
        dayOfWeekHeader.setVisibility(GONE);
        monthViewPager.setVisibility(GONE);

        Animation anim=new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                monthViewPager.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int) (0 * interpolatedTime)));
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        anim.setDuration(500);
        monthViewPager.startAnimation(anim);

        isOpen = false;
    }

    private void expandQuickCal(){
        dayOfWeekHeader.setVisibility(VISIBLE);
        monthViewPager.setVisibility(VISIBLE);

        Animation anim=new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                monthViewPager.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int) (500 * interpolatedTime)));
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        anim.setDuration(500);
        monthViewPager.startAnimation(anim);

        isOpen = true;
    }



    private void addChildren(){
        setOrientation(VERTICAL);
        //setLayoutParams( new LayoutParams(LayoutParams.MATCH_PARENT, 5));

        monthText = new TextView(context);
        monthText.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));

        monthText.setGravity(Gravity.CENTER);

        monthText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen){
                    Log.d("LR", "Close");
                    collapseQuickCal();
                } else {
                    Log.d("LR", "Open");
                    expandQuickCal();
                }
            }
        });


        addView(monthText);



        dayOfWeekHeader = new DayOfWeekHeader(context);
        DayOfWeekHeaderAdapter dayOfWeekHeaderAdapter = new DayOfWeekHeaderAdapter(context);
        dayOfWeekHeader.setAdapter(dayOfWeekHeaderAdapter);

        dayOfWeekHeader.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));
        dayOfWeekHeader.setColumnWidth(90);
        dayOfWeekHeader.setNumColumns(7);
        dayOfWeekHeader.setVerticalSpacing(10);
        dayOfWeekHeader.setHorizontalSpacing(10);
        dayOfWeekHeader.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
        dayOfWeekHeader.setGravity(Gravity.CENTER);

        //dayOfWeekHeader.setVisibility(GONE);
        addView(dayOfWeekHeader);


        monthViewPager = new MonthViewPager(context);
        monthViewPagerAdapter = new MonthViewPagerAdapter(context);
        monthViewPager.setAdapter(monthViewPagerAdapter);


        monthViewPager.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));

        monthViewPager.setCurrentItem(monthViewPagerAdapter.getDatePosition(new Date()));


        monthViewPager.setOnPageChangeListener(this);

        //monthViewPager.setVisibility(GONE);
        addView(monthViewPager);

        getMonthNameFromDate(
                monthViewPagerAdapter.getDateFromPosition(
                        monthViewPager.getCurrentItem()));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }


    @Override
    public void onPageSelected(int position) {
        getMonthNameFromDate(
                monthViewPagerAdapter.getDateFromPosition(position));
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void getMonthNameFromDate(Date date){
        Calendar currentDate = Calendar.getInstance();
        Calendar pramDate = Calendar.getInstance();
        pramDate.setTime(date);

        DateFormat dateFormat = new SimpleDateFormat("MMMM");

        if (currentDate.get(Calendar.YEAR) != pramDate.get(Calendar.YEAR)){
            dateFormat = new SimpleDateFormat("MMMM yyyy");
        }

        setMonthText(dateFormat.format(date));
    }

    public  void setMonthText(String string){
        if (monthText != null){
            monthText.setText(string);
        }
    }



}
