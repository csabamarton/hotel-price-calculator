package com.csmarton.util;

import com.csmarton.model.DateRange;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DateHelper {
    public static List<LocalDate> getDaysBetweenDates(DateRange searchRange) {
        LocalDate start = searchRange.getFrom();
        LocalDate end = searchRange.getTo();

        return Stream.iterate(start, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(start, end))
                .collect(Collectors.toList());
    }
}
