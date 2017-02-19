package com.draganddraw.model;

import android.graphics.PointF;

/**
 * Created by yufei0213 on 2017/2/19.
 */
public class Box {

    private PointF origin;
    private PointF current;

    public Box(PointF origin) {
        this.origin = origin;
    }

    public PointF getOrigin() {
        return origin;
    }

    public void setOrigin(PointF origin) {
        this.origin = origin;
    }

    public PointF getCurrent() {
        return current;
    }

    public void setCurrent(PointF current) {
        this.current = current;
    }
}
