package com.csmarton.service;

import com.csmarton.model.Hotel;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HotelServiceImplTest {

    HotelServiceImpl hotelService;

    @Before
    public void setUp() throws Exception {
        hotelService = new HotelServiceImpl();
        hotelService.init();
    }

    @Test
    public void whenCallingGetHotels_thenItShouldReturnWithAllOfThem() {
        List<Hotel> hotels = hotelService.getHotels();

        assertEquals(1, hotels.size());
    }

    @Test
    public void whenCallingProcessConditions_thenItShouldReturnPriceMap() {

    }
}