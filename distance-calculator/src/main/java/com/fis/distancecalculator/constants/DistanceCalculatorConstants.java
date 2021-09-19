package com.dc.distancecalculator.constants;

public final class DistanceCalculatorConstants {
    public static final String NO_DISTANCE_FOUND_CODE = "001";
    public static final String NO_DISTANCE_FOUND_MESSAGE(String fromCityCode,
                                                         String toCityCode) {
        return "No Distance mapping found for fromCityCode:" + fromCityCode
                + " and toCityCode:" + toCityCode;
    }

    public static final String SUCCESS_CODE = "000";
    public static final String SUCCESS_MESSAGE = "All is good";

    public static final Integer NUMBER_OF_HOURS_FOR_EVERY_STOP = 2;
    public static final Integer DURATION_OF_STOP = 20;
}
