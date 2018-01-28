package com.csmarton.service;

import com.csmarton.model.Hotel;
import com.csmarton.model.HotelConditionSearch;
import com.csmarton.model.HotelConditionSearchResult;

import java.util.List;

public interface HotelService {
    List<Hotel> getHotels();

    List<HotelConditionSearchResult> processConditionSearch(HotelConditionSearch search);
}
