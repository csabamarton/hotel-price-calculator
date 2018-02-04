package com.csmarton.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Condition {
    @JsonProperty(value = "season")
    private DateRange range;

    @JsonProperty(value = "single")
    private int singlePrice;

    @JsonProperty(value = "double")
    private int doublePrice;

    public Condition() {
    }

    public Condition(String single) {
    }

    public DateRange getRange() {
        return range;
    }

    public void setRange(DateRange range) {
        this.range = range;
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
