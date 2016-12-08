package com.gmail.peeman34.eglisaofficial;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.view.View;

/**
 * Created by pee on 7/29/2016.
 */

public class ScrollAwareFABBehaviour extends FloatingActionButton.Behavior {
    public ScrollAwareFABBehaviour() {
        super();
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {

        return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);

    if (dyConsumed > 0&& child.getVisibility() == View.VISIBLE){
     // User scrolled down and the FAB is currently visible -> hide the FAB

     child.hide();
    }else if (dyConsumed <0 && child.getVisibility() !=View.VISIBLE ){
        child.show();
    }
    }


}
