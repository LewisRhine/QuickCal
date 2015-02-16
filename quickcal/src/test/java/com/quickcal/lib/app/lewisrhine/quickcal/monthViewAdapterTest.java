package com.quickcal.lib.app.lewisrhine.quickcal;

import android.content.Context;

import com.quckcal.lib.app.lewisrhine.quickcal.DayOfWeekHeaderAdapter;
import com.quckcal.lib.app.lewisrhine.quickcal.MonthViewAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

/**
 * Created by lewisrhine on 2/5/15.
 */


@RunWith(RobolectricTestRunner.class)
public class monthViewAdapterTest {

    private MonthViewAdapter monthViewAdapter;
    Calendar calendar;

    @Before
    public void setUp(){
        calendar = Calendar.getInstance();
        monthViewAdapter = new MonthViewAdapter(Robolectric.application.getApplicationContext(), calendar);

    }

    @Test
    public void getCountTest(){
        //days in January
        calendar.set(Calendar.MONTH, 0);
        monthViewAdapter = new MonthViewAdapter(Robolectric.application.getApplicationContext(), calendar);

        assertEquals("Amount of days in Jan is wrong", 35, monthViewAdapter.getCount());

        //days in February
        calendar.set(Calendar.MONTH, 1);
        monthViewAdapter = new MonthViewAdapter(Robolectric.application.getApplicationContext(), calendar);

        assertEquals("Amount of days in Feb wrong", 28, monthViewAdapter.getCount());
    }

    @Test
    public void getFirstDayOfMonthTest(){

        calendar.set(Calendar.MONTH, 0);
        monthViewAdapter.setCalendar(calendar);

        assertEquals("First day of Jan 2015 is wrong", 5, monthViewAdapter.getFirstDayOfMonth());

        calendar.set(Calendar.MONTH, 1);
        monthViewAdapter.setCalendar(calendar);

        assertEquals("First day of Jan 2015 is wrong", 1, monthViewAdapter.getFirstDayOfMonth());

    }

    @Test
    public void getMonthName(){
        calendar.set(Calendar.MONTH, 0);
        monthViewAdapter.setCalendar(calendar);

        assertEquals("Name of Jan 2015 is wrong", "January 2015", monthViewAdapter.getMonthName());

        calendar.set(Calendar.MONTH, 1);
        monthViewAdapter.setCalendar(calendar);

        assertEquals("Name of Jan 2015 is wrong", "February 2015", monthViewAdapter.getMonthName());
    }

    @Test
    public void getItemTest(){

    }

    @Test
    public void getViewTest(){

    }

}