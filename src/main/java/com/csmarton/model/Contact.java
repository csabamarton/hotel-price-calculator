package com.csmarton.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contact {
    @JsonProperty(value = "firstname")
    private String firstName;

    @JsonProperty(value = "lastname")
    private String lastName;
    private String phone;
    private String email;

    public Contact() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
