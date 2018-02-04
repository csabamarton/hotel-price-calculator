package com.csmarton.model;

import java.time.LocalDate;

public class HotelConditionSearch {
    private LocalDate firstDay;
    private LocalDate lastDay;
    private boolean singleRoom;
    private String hotelId;

    public HotelConditionSearch() {
    }

    public HotelConditionSearch(LocalDate firstDay, LocalDate lastDay, boolean singleRoom, String hotelId) {
        this.firstDay = firstDay;
        this.lastDay = lastDay;
        this.singleRoom = singleRoom;
        this.hotelId = hotelId;
    }

    public LocalDate getFirstDay() {
        return firstDay;
    }

    public LocalDate getLastDay() {
        return lastDay;
    }

    public boolean isSingleRoom() {
        return singleRoom;
    }

    public String getHotelId() {
        return hotelId;
    }
}
