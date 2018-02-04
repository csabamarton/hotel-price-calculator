package com.csmarton.model;

import com.csmarton.json.LocalDateDeserializer;
import com.csmarton.json.LocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateRange {
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    LocalDate from;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    LocalDate to;


    String label;

    public DateRange() {
    }

    public DateRange(String from, String to) {
        this.from = LocalDate.parse(from);
        this.to = LocalDate.parse(to);
    }



    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    static DateTimeFormatter basicFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public String getLabel() {
        if(label == null) {
            label = String.format("%s - %s", from.format(basicFormatter), to.format(basicFormatter));
        }

        return label;
    }
}

