package com.csmarton.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

class Condition {
    @JsonProperty(value = "ranges")
    private List<DateRange> ranges;

    @JsonProperty(value = "single")
    private int singlePrice;

    @JsonProperty(value = "double")
    private int doublePrice;

    public Condition() {
    }

    public Condition(String single) {
    }



    public List<DateRange> getRanges() {
        return ranges;
    }

    public void setRanges(List<DateRange> ranges) {
        this.ranges = ranges;
    }

    public int getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(int singlePrice) {
        this.singlePrice = singlePrice;
    }

    public int getDoublePrice() {
        return doublePrice;
    }

    public void setDoublePrice(int doublePrice) {
        this.doublePrice = doublePrice;
    }
}
