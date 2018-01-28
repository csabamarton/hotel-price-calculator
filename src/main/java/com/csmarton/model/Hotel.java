package com.csmarton.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties
public class Hotel {
    @JsonProperty(value = "id")
    private String hotelId;

    private String name;

    //values by language (de, hu)
    @JsonProperty(value = "address")
    private Map address;

    @JsonProperty(value = "contact")
    private Contact contact;

    private String phone;

    //Todo make this to enum
    private String hotelType;

    @JsonProperty(value = "conditions")
    private List<Condition> conditions;


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

    public Map getAddress() {
        return address;
    }

    public void setAddress(Map address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHotelType() {
        return hotelType;
    }

    public void setHotelType(String hotelType) {
        this.hotelType = hotelType;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }
}



