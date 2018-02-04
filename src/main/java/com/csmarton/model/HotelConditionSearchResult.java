package com.csmarton.model;

public class HotelConditionSearchResult {
    HotelConditionSearch searchParameters;

    Integer price;

    public HotelConditionSearchResult(HotelConditionSearch searchParameters) {
        this.searchParameters = searchParameters;
    }

    public HotelConditionSearch getSearchParameters() {
        return searchParameters;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
