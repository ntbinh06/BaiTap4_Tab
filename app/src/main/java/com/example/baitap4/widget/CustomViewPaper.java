package com.example.baitap4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class CustomViewPaper extends ViewPager {
    private boolean enabled;
    public CustomViewPaper( Context context,  AttributeSet attrs) {
        super(context, attrs);
        this.enabled=true;
    }
    public boolean onTouchEvent(MotionEvent event){
    if(this.enabled){
        return super.onTouchEvent(event);
    }
        return false;
    }
    public boolean onInterceptTouchEvent(MotionEvent event){
        if(this.enabled) {
            return super.onInterceptTouchEvent(event);
        }
        return false;
    }
    public void setPagingEnable(boolean enabled){
        this.enabled= enabled;
    }
}
