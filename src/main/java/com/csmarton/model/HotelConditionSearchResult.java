package com.csmarton.model;

import java.util.Map;

public class HotelConditionSearchResult {
    HotelConditionSearch searchParameters;

    Map<String, Integer> hotelPrices;

    public HotelConditionSearchResult(HotelConditionSearch searchParameters) {
        this.searchParameters = searchParameters;
    }

    public HotelConditionSearch getSearchParameters() {
        return searchParameters;
    }

    public Map getHotelPrices() {
        return hotelPrices;
    }

    public void setHotelPrices(Map<String, Integer> hotelPrices) {
        this.hotelPrices = hotelPrices;
    }
}
