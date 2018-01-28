package com.csmarton.service;

import com.csmarton.model.Hotel;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.springframework.stereotype.Service;

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

    @Override
    public List<Hotel> buildHotelData() {
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
}
