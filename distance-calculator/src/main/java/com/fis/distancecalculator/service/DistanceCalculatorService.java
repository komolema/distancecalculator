package com.dc.distancecalculator.service;

import com.dc.distancecalculator.constants.DistanceCalculatorConstants;
import com.dc.distancecalculator.model.api.ApiBody;
import com.dc.distancecalculator.model.api.ApiHeader;
import com.dc.distancecalculator.model.api.ApiResult;
import com.dc.distancecalculator.model.api.ExtractedHourAndTime;
import com.dc.distancecalculator.model.domain.City;
import com.dc.distancecalculator.model.domain.Distance;
import com.dc.distancecalculator.repo.CityRepository;
import com.dc.distancecalculator.repo.DistanceRepository;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DistanceCalculatorService {

    DistanceRepository distanceRepository;

    CityRepository cityRepository;

    public ApiResult calculateDistance(String fromCityCode, String toCityCode, Integer averageSpeedPerHour) {

        Distance distance = distanceRepository.findByFromAndToCity(fromCityCode, toCityCode);

        if (distance == null) {
            return ApiResultNoDistanceFound(fromCityCode, toCityCode);
        }

        ExtractedHourAndTime extractedHourAndTime =
                extractHoursAndMinutes(distance.getDistance().doubleValue() / averageSpeedPerHour);
        LocalTime durationOfTrip = LocalTime.now()
                .withHourOfDay(extractedHourAndTime.getHours())
                .withMinuteOfHour(extractedHourAndTime.getMinutes());
        Integer numberOfRestStops =
                durationOfTrip.getHourOfDay() / DistanceCalculatorConstants.NUMBER_OF_HOURS_FOR_EVERY_STOP;

        LocalTime durationOfTripWithRest =
                durationOfTrip.plusMinutes(numberOfRestStops * DistanceCalculatorConstants.DURATION_OF_STOP);

        City fromCity = cityRepository.findByCode(fromCityCode);
        City toCity = cityRepository.findByCode((toCityCode));

        return new ApiResult(
                new ApiHeader(DistanceCalculatorConstants.SUCCESS_CODE, DistanceCalculatorConstants.SUCCESS_MESSAGE),
                new ApiBody(fromCity, toCity, distance.getDistance(), durationOfTripWithRest.toString(), numberOfRestStops,
                        DistanceCalculatorConstants.DURATION_OF_STOP)
        );

    }

    private ExtractedHourAndTime extractHoursAndMinutes(Double numberToExtract) {
        String formattedNumberToExtract = new DecimalFormat("#0.00").format(numberToExtract);
        List<Integer> extractedArray = Arrays.stream(formattedNumberToExtract.split("[.]"))
                .map(Integer::new)
                .collect(Collectors.toList());
        if (extractedArray.size() > 1) {

            return new ExtractedHourAndTime(extractedArray.get(0), convertToMinutes(extractedArray.get(1)));
        } else if (extractedArray.size() == 1) {
            return new ExtractedHourAndTime(extractedArray.get(1), 0);
        } else {
            return new ExtractedHourAndTime(0, 0);
        }
    }

    private Integer convertToMinutes(Integer number) {
        if(number > 0) {
            return number * 60 / 100;
        }
        return number;
    }

    private ApiResult ApiResultNoDistanceFound(String fromCityCode, String toCityCode) {
        ApiHeader apiHeader = new ApiHeader(DistanceCalculatorConstants.NO_DISTANCE_FOUND_CODE,
                DistanceCalculatorConstants.NO_DISTANCE_FOUND_MESSAGE(fromCityCode, toCityCode));

        return new ApiResult(apiHeader, null);
    }

    @Autowired
    public void setDistanceRepository(DistanceRepository distanceRepository) {
        this.distanceRepository = distanceRepository;
    }

    @Autowired
    public void setCityRepository(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
}
