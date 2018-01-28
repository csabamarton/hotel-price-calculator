package com.csmarton.model;

import java.util.Date;

public class HotelConditionSearch {
    private Date firstDay;
    private Date lastDay;
    private boolean singleRoom;

    public HotelConditionSearch() {
    }

    public HotelConditionSearch(Date firstDay, Date lastDay, boolean singleRoom) {
        this.firstDay = firstDay;
        this.lastDay = lastDay;
        this.singleRoom = singleRoom;
    }

    public Date getFirstDay() {
        return firstDay;
    }

    public Date getLastDay() {
        return lastDay;
    }

    public boolean isSingleRoom() {
        return singleRoom;
    }
}
