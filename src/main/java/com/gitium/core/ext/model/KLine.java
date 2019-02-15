package com.gitium.core.ext.model;

import java.io.Serializable;

public class KLine implements Serializable {

    private static final long serialVersionUID = 1750362828050235895L;

    private float begin;
    private float end;
    private float high;
    private float low;
    private long date;

    public float getBegin() {
        return begin;
    }

    public float getEnd() {
        return end;
    }

    public float getHigh() {
        return high;
    }

    public float getLow() {
        return low;
    }

    public long getDate() {
        return date;
    }

}