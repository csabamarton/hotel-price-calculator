package com.csmarton.service;

import com.csmarton.model.DateRange;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.truth.Truth.assertWithMessage;
import static java.time.temporal.ChronoUnit.DAYS;

public class TimeCalculatorTest {

    DateRange range1;
    DateRange range2;
    DateRange range3;
    List<DateRange> ranges;
    Map<String, Integer> dayCounter;

    @Before
    public void setUp() throws Exception {
        range1 = new DateRange("2018-01-02", "2018-03-31");
        range2 = new DateRange("2018-04-01", "2018-10-31");
        range3 = new DateRange("2018-11-01","2018-12-31");

        ranges = Lists.newArrayList(range1, range2, range3);
        dayCounter = new HashMap<>();

    }

    @Test
    public void givenARange_ShouldBeAbleToCalculateTheNumberOfDays() {
        String from = "2018-02-12";
        String to = "2018-02-18";

        LocalDate dateBefore = LocalDate.parse(from);
        LocalDate dateAfter = LocalDate.parse(to);
        long daysBetween = DAYS.between(dateBefore, dateAfter);

        assertWithMessage("We got different number of Days").that(daysBetween).isEqualTo(6);
    }

    @Test
    public void givenADateRange_AndADateInIt_shouldReturnTrue() {
        String date = "2018-02-13";

        String from = "2018-02-12";
        String to = "2018-02-18";

        LocalDate dateBefore = LocalDate.parse(from);
        LocalDate dateAfter = LocalDate.parse(to);
        LocalDate searchDate = LocalDate.parse(date);

        boolean isInRange = !dateBefore.isAfter(searchDate) && !dateAfter.isBefore(searchDate);

        assertWithMessage("It should have been in the range but..").that(isInRange).isTrue();
    }

    @Test
    public void givenADateRange_AndADateOutOfIt_shouldReturnFalse() {
        String date = "2018-02-11";

        String from = "2018-02-12";
        String to = "2018-02-18";

        LocalDate dateBefore = LocalDate.parse(from);
        LocalDate dateAfter = LocalDate.parse(to);
        LocalDate searchDate = LocalDate.parse(date);

        boolean isInRange = !dateBefore.isAfter(searchDate) && !dateAfter.isBefore(searchDate);

        assertWithMessage("It should have been in the range but..").that(isInRange).isTrue();
    }

    @Test
    public void givenADateRange_AndADateInTheEdge_shouldReturnTrue() {
        String date = "2018-02-12";

        String from = "2018-02-12";
        String to = "2018-02-18";

        LocalDate dateBefore = LocalDate.parse(from);
        LocalDate dateAfter = LocalDate.parse(to);
        LocalDate searchDate = LocalDate.parse(date);

        boolean isInRange = !dateBefore.isAfter(searchDate) && !dateAfter.isBefore(searchDate);

        assertWithMessage("It should have been in the range but..").that(isInRange).isTrue();
    }


    @Test
    public void givenADateRanges_AndOneRange_shouldBeReturnAMapOfNumsOfDayInRanges() {
        String date = "2018-02-12";

        String from = "2018-02-12";
        String to = "2018-02-18";

        LocalDate dateBefore = LocalDate.parse(from);
        LocalDate dateAfter = LocalDate.parse(to);
        LocalDate searchDate = LocalDate.parse(date);

        boolean isInRange = !dateBefore.isAfter(searchDate) && !dateAfter.isBefore(searchDate);

        assertWithMessage("It should have been in the range but..").that(isInRange).isTrue();
    }

    private boolean isInRange(DateRange range, LocalDate date) {
        return !range.getFrom().isAfter(date) && !range.getTo().isBefore(date);
    }

    @Test
    public void calculateHowManyDaysFromTheRanges() {
        DateRange searchRange = new DateRange("2018-02-12", "2018-02-18");

        List<LocalDate> dates = getDaysBetweenDates(searchRange);

        //TODO
    }

    private List<LocalDate> getDaysBetweenDates(DateRange searchRange) {
        LocalDate start = searchRange.getFrom();
        LocalDate end = searchRange.getTo();

        return Stream.iterate(start, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(start, end))
                .collect(Collectors.toList());
    }
}
