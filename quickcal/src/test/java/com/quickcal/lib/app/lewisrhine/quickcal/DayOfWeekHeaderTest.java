package com.quickcal.lib.app.lewisrhine.quickcal;

import android.content.Context;

import com.quckcal.lib.app.lewisrhine.quickcal.DayOfWeekHeader;
import com.quckcal.lib.app.lewisrhine.quickcal.DayOfWeekHeaderAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;


//TODO this is a mess I'll come back later
@RunWith(RobolectricTestRunner.class)
public class DayOfWeekHeaderTest {

    DayOfWeekHeader dayOfWeekHeader;
    DayOfWeekHeaderAdapter dayOfWeekHeaderAdapter;

    Context context = Robolectric.application.getApplicationContext();

    @Before
    public void setUp(){
        dayOfWeekHeader = new DayOfWeekHeader(context);

        dayOfWeekHeaderAdapter = mock(DayOfWeekHeaderAdapter.class);
        when(dayOfWeekHeaderAdapter.getViewTypeCount()).thenReturn(1);

        dayOfWeekHeader.setAdapter(dayOfWeekHeaderAdapter);

    }

    @Test
    public void adapterTest(){
        assertEquals("adapter wrong type", dayOfWeekHeaderAdapter, dayOfWeekHeader.getAdapter());
    }
}
