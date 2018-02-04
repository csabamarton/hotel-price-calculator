package com.csmarton.service;

import com.csmarton.model.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static com.csmarton.util.DateHelper.getDaysBetweenDates;

@Service
public class HotelServiceImpl implements HotelService {
    private static ObjectMapper objectMapper;
    static {
        objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    }

    private List<Hotel> hotels;

    @PostConstruct
    public void init() {
        hotels = buildHotelData();
    }

    private List<Hotel> buildHotelData() {
        URL url = Resources.getResource("hotel.json");
        try {
            String hotelJson = Resources.toString(url, Charsets.UTF_8);
            List<Hotel> hotels = objectMapper.readValue(hotelJson, new TypeReference<List<Hotel>>(){});

            return hotels;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Hotel> getHotels() {
        return hotels;
    }

    @Override
    public HotelConditionSearchResult processConditionSearch(HotelConditionSearch search) {
        HotelConditionSearchResult result = new HotelConditionSearchResult(search);

        int price =  calculatePrice(search);

        result.setPrice(price);

        return result;
    }

    private Integer calculatePrice(HotelConditionSearch searchParams) {
        DateRange searchRange = new DateRange(searchParams.getFirstDay(), searchParams.getLastDay());

        Map<LocalDate, String> daySeason = new HashMap<>();

        List<LocalDate> dates = getDaysBetweenDates(searchRange);

        Optional<Hotel> hotelOptional = getHotelById(searchParams.getHotelId());
        Map<String, Integer> result = new HashMap<>();
        if(hotelOptional.isPresent()) {
            Hotel hotel = hotelOptional.get();

            dates.forEach(date -> checkWhichDay(daySeason, date, hotel.getConditions()));

            System.out.println(daySeason);

            result = hotel.getConditions()
                    .stream()
                    .filter(condition -> daySeason.containsValue(condition.getRange().getLabel()))
                    .collect(Collectors.toMap(condition -> condition.getRange().getLabel(), condition -> Collections.frequency(daySeason.values(), condition.getRange().getLabel())));
            System.out.println(result);

        }

        return getPrice(result, hotelOptional.get(), searchParams.isSingleRoom());
    }

    private int getPrice(Map<String, Integer> result, Hotel hotel, boolean singleRoom) {
        AtomicInteger price = new AtomicInteger();
        result.forEach((rangeLabel,numOfDays) -> {
            Condition condition = getConditionBySeason(hotel, rangeLabel);
            price.set(price.get() + (singleRoom?condition.getSinglePrice():condition.getDoublePrice()) * numOfDays);
        });

        return price.get();
    }

    private void checkWhichDay(Map<LocalDate, String> daySeason, LocalDate date, List<Condition> conditions) {
        daySeason.put(date, findSeason(date, conditions));
    }

    private String findSeason(LocalDate date, List<Condition> conditions) {
        return conditions
                .stream()
                .filter(condition -> isInRange(condition.getRange(), date))
                .findFirst()
                .get().getRange()
                .getLabel();
    }

    private boolean isInRange(DateRange range, LocalDate date) {
        return !range.getFrom().isAfter(date) && !range.getTo().isBefore(date);
    }

    public Optional<Hotel> getHotelById(String id) {
        return hotels.stream().filter(hotel -> hotel.getHotelId().equals(id)).findFirst();
    }

    public Condition getConditionBySeason(Hotel hotel, String season) {
        return hotel.getConditions().stream().filter(condition -> condition.getRange().getLabel().equals(season)).findFirst().get();
    }
}
