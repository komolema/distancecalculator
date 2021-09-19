package com.dc.distancecalculator.model.api;

public class ExtractedHourAndTime {
    private Integer hours;
    private Integer minutes;

    public ExtractedHourAndTime(Integer hours, Integer minutes){
        this.hours = hours;
        this.minutes = minutes;
    }
    public Integer getHours() {
        return hours;
    }

    public Integer getMinutes() {
        return minutes;
    }
}
