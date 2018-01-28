package com.csmarton.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Hotel {
    private String hotelId;
    private String name;
    //values by language (de, hu)
    private Map address;
    private Contact contact;
    private String phone;
    //Todo make this to enum
    private String hotelType;
    private List<Condition> conditions;

    public class Contact {
        private String firstName;
        private String lastName;
        private String phone;
        private String email;
    }

    private class Condition {
        private List<DateRange> ranges;
        private double singlePrice;
        private double doublePrice;

        private class DateRange {
            Date from;
            Date to;
        }
    }

    public Hotel() {
    }

    public Hotel(String hotelId, String name) {
        this.hotelId = hotelId;
        this.name = name;
    }

    public String getHotelId() {
        return hotelId;
    }

    public String getName() {
        return name;
    }
}



