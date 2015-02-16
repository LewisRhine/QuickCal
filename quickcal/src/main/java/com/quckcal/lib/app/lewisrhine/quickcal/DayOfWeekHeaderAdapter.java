package com.quckcal.lib.app.lewisrhine.quickcal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by lewisrhine on 2/5/15.
 */
public class DayOfWeekHeaderAdapter extends BaseAdapter {
    private String[] daysOfWeekNamesShort = {"S", "M", "T", "W", "T", "F", "S"};
    private Context context;

    public DayOfWeekHeaderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return daysOfWeekNamesShort.length;
    }

    @Override
    public Object getItem(int position) {
        return daysOfWeekNamesShort[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        if (convertView == null) {
            textView = new TextView(context);
            textView.setLayoutParams(new GridView.LayoutParams(85, 85));
            textView.setPadding(8, 8, 8, 8);
        } else {
            textView = (TextView) convertView;
        }

        textView.setText(daysOfWeekNamesShort[position]);

        return textView;    }
}
