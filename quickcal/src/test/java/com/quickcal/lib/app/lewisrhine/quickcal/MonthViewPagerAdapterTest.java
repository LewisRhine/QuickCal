package com.quickcal.lib.app.lewisrhine.quickcal;

import android.content.Context;

import com.quckcal.lib.app.lewisrhine.quickcal.DayOfWeekHeaderAdapter;
import com.quckcal.lib.app.lewisrhine.quickcal.MonthViewAdapter;
import com.quckcal.lib.app.lewisrhine.quickcal.MonthViewPagerAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by lewisrhine on 2/5/15.
 */


@RunWith(RobolectricTestRunner.class)
public class MonthViewPagerAdapterTest {

    MonthViewPagerAdapter monthViewPagerAdapter;

    @Before
    public void setUp() {
        monthViewPagerAdapter = new MonthViewPagerAdapter(Robolectric.application.getApplicationContext());
    }

    @Test
    public void getDatePositionTest(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2015);
        calendar.set(Calendar.MONTH, 1);

        Date date = new Date();
        date.setTime(calendar.getTimeInMillis());

        assertEquals("Date position is wrong", 241, monthViewPagerAdapter.getDatePosition(date));

    }

}
