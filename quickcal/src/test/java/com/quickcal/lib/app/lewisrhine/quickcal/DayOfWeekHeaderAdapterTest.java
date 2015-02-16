package com.quickcal.lib.app.lewisrhine.quickcal;

import android.view.View;
import android.widget.TextView;

import com.quckcal.lib.app.lewisrhine.quickcal.DayOfWeekHeaderAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by lewisrhine on 2/5/15.
 */


@RunWith(RobolectricTestRunner.class)
public class DayOfWeekHeaderAdapterTest {

    private DayOfWeekHeaderAdapter dayOfWeekHeaderAdapter;

    @Before
    public void setUp(){
           dayOfWeekHeaderAdapter = new DayOfWeekHeaderAdapter(Robolectric.application.getApplicationContext());
    }

    @Test
    public void getCountTest(){
        assertEquals("Adapter item count is not 7", 7, dayOfWeekHeaderAdapter.getCount());
    }

    @Test
    public void getItemTest(){
        assertEquals("First day of week is not set to s for Sunday", "S", dayOfWeekHeaderAdapter.getItem(0));
        assertEquals("Second day of week is not set to m for Sunday", "M", dayOfWeekHeaderAdapter.getItem(1));
        assertEquals("Third day of week is not set to t for Sunday", "T", dayOfWeekHeaderAdapter.getItem(2));
        assertEquals("Forth day of week is not set to w for Sunday", "W", dayOfWeekHeaderAdapter.getItem(3));
        assertEquals("Fifth day of week is not set to t for Sunday", "T", dayOfWeekHeaderAdapter.getItem(4));
        assertEquals("Sixth day of week is not set to f for Sunday", "F", dayOfWeekHeaderAdapter.getItem(5));
        assertEquals("Seventh day of week is not set to s for Sunday", "S", dayOfWeekHeaderAdapter.getItem(6));
    }

    @Test
    public void getViewTest(){

    }

}