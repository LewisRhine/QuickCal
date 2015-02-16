package com.quckcal.lib.app.lewisrhine.quickcal;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by lewisrhine on 2/11/15.
 */
public class DayView extends TextView {
    private boolean isMarked;
    private boolean isToday;


    public DayView(Context context) {
        super(context);
    }

    public DayView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DayView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public boolean isMarked() {
        return isMarked;
    }

    public void setMarked(boolean isMarked) {
        this.isMarked = isMarked;
        if (isMarked){
            setTextColor(Color.BLUE);
        }

    }

    public boolean isToday() {
        return isToday;
    }

    public void setToday(boolean isToday) {
        this.isToday = isToday;
        if (isToday){
            setTextColor(Color.RED);
        }
    }
}
