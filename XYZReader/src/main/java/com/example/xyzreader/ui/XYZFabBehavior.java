package com.example.xyzreader.ui;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.List;

/**
 * Created by admin on 2018/2/2.
 */

public class XYZFabBehavior
        extends AppBarLayout.ScrollingViewBehavior {


    public XYZFabBehavior(){

    }

    public XYZFabBehavior(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        Log.i("behavior","!");
        return super.layoutDependsOn(parent, child, dependency)
                ||dependency instanceof FloatingActionButton;

    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        Log.i("behavior","!!");
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);

    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);

        if (dyConsumed>0){
            List<View> dependencies = coordinatorLayout
                    .getDependencies(child);
            Log.i("behavior","!!!");
            for (View view : dependencies){
                if (view instanceof FloatingActionButton){
                    ((FloatingActionButton)view).hide();
                }
            }

        }else if (dyConsumed < 0){
            List<View> dependencies = coordinatorLayout.getDependencies(child);
            Log.i("behavior","!@@");
            for (View view : dependencies) {
                if (view instanceof FloatingActionButton) {
                    ((FloatingActionButton) view).show();
                }
            }
        }

    }
}
