package com.dc.distancecalculator.model.api;

import com.dc.distancecalculator.model.domain.City;

public class ApiBody {
    private City fromCity;
    private City toCity;
    private Integer distance;
    private String duration;
    private Integer numberOfStops;
    private Integer durationOfStopInMinutes;

    public ApiBody(City fromCity, City toCity, Integer distance, String duration, Integer numberOfStops,
                   Integer durationOfStopInMinutes){
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.distance = distance;
        this.duration = duration;
        this.numberOfStops = numberOfStops;
        this.durationOfStopInMinutes = durationOfStopInMinutes;
    }

    public City getFromCity() {
        return fromCity;
    }

    public City getToCity() {
        return toCity;
    }

    public Integer getDistance() {
        return distance;
    }

    public String getDuration() {
        return duration;
    }

    public Integer getNumberOfStops() {
        return numberOfStops;
    }

    public Integer getDurationOfStopInMinutes() {
        return durationOfStopInMinutes;
    }
}
