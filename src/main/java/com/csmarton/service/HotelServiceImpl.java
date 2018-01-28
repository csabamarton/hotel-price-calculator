package com.csmarton.service;

import com.csmarton.model.Hotel;
import com.csmarton.model.HotelConditionSearch;
import com.csmarton.model.HotelConditionSearchResult;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;
import java.util.List;

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
    public List<HotelConditionSearchResult> processConditionSearch(HotelConditionSearch search) {
        return null;
    }

    private Integer calculatePrice(Hotel hotel, HotelConditionSearch searchParams) {
        return null;
    }


}
