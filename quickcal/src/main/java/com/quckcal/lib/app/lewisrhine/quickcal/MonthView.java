package com.quckcal.lib.app.lewisrhine.quickcal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by lewisrhine on 2/6/15.
 */
public class MonthView extends GridView {
    public MonthView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        hideScrollBars();
    }

    public MonthView(Context context) {
        super(context);
        hideScrollBars();
    }

    public MonthView(Context context, AttributeSet attrs) {
        super(context, attrs);
        hideScrollBars();
    }

    private void hideScrollBars(){
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
    }
}
