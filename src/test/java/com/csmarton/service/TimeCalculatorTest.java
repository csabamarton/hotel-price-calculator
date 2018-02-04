package com.csmarton.service;

import com.csmarton.model.HotelConditionSearch;
import com.csmarton.model.HotelConditionSearchResult;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static com.google.common.truth.Truth.assertWithMessage;
import static java.time.temporal.ChronoUnit.DAYS;

public class TimeCalculatorTest {

    HotelServiceImpl hotelService;

    @Before
    public void setUp() throws Exception {
        hotelService = new HotelServiceImpl();
        hotelService.init();
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

        boolean isInRange = isInRange(date, from, to);

        assertWithMessage("It should have been in the range but..").that(isInRange).isTrue();
    }

    @Test
    public void givenADateRange_AndADateOutOfIt_shouldReturnFalse() {
        String date = "2018-02-11";

        String from = "2018-02-12";
        String to = "2018-02-18";

        boolean isInRange = isInRange(date, from, to);

        assertWithMessage("It should have been in the range but..").that(isInRange).isFalse();
    }

    private boolean isInRange(String date, String from, String to) {
        LocalDate dateBefore = LocalDate.parse(from);
        LocalDate dateAfter = LocalDate.parse(to);
        LocalDate searchDate = LocalDate.parse(date);

        return !dateBefore.isAfter(searchDate) && !dateAfter.isBefore(searchDate);
    }

    @Test
    public void givenADateRange_AndADateInTheEdge_shouldReturnTrue() {
        String date = "2018-02-12";

        String from = "2018-02-12";
        String to = "2018-02-18";

        boolean isInRange = isInRange(date, from, to);

        assertWithMessage("It should have been in the range but..").that(isInRange).isTrue();
    }


    @Test
    public void givenADateRanges_AndOneRange_shouldBeReturnAMapOfNumsOfDayInRanges() {
        String date = "2018-02-12";

        String from = "2018-02-12";
        String to = "2018-02-18";

        boolean isInRange = isInRange(date, from, to);

        assertWithMessage("It should have been in the range but..").that(isInRange).isTrue();
    }

    Map<LocalDate, String> daySeason = new HashMap<>();

    @Test
    public void calculateHowManyDaysFromTheRanges() {
        HotelConditionSearch search = new HotelConditionSearch(LocalDate.parse("2018-03-31"), LocalDate.parse("2018-04-03"), true, "hotel1");
        HotelConditionSearchResult hotelConditionSearchResult = hotelService.processConditionSearch(search);

        System.out.println(hotelConditionSearchResult);

        assertWithMessage("Wrong price calculation").that(hotelConditionSearchResult.getPrice()).isEqualTo(164);
    }
}
