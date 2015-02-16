package com.quckcal.lib.app.lewisrhine.exampleapp;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

import com.quckcal.lib.app.lewisrhine.quickcal.MonthViewPager;
import com.quckcal.lib.app.lewisrhine.quickcal.MonthViewPagerAdapter;
import com.quckcal.lib.app.lewisrhine.quickcal.QuickCal;

import java.util.Calendar;
import java.util.Date;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            QuickCal quickCal = (QuickCal) rootView.findViewById(R.id.cal);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            Date date = calendar.getTime();
            quickCal.markDate(date);

            calendar.set(Calendar.DAY_OF_MONTH, 3);
            date = calendar.getTime();
            quickCal.markDate(date);

            calendar.set(Calendar.MONTH, 5);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            date = calendar.getTime();
            quickCal.markDate(date);

            calendar.set(Calendar.YEAR, 2014);
            calendar.set(Calendar.MONTH, 2);
            calendar.set(Calendar.DAY_OF_MONTH, 11);
            date = calendar.getTime();
            quickCal.markDate(date);


            return rootView;
        }
    }
}
