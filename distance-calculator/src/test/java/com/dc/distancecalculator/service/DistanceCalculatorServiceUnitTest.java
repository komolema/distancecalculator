package com.dc.distancecalculator.service;

import com.dc.distancecalculator.constants.DistanceCalculatorConstants;
import com.dc.distancecalculator.model.api.ApiResult;
import com.dc.distancecalculator.model.domain.Distance;
import com.dc.distancecalculator.repo.CityRepository;
import com.dc.distancecalculator.repo.DistanceRepository;
import org.joda.time.LocalTime;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DistanceCalculatorServiceUnitTest {

    @Autowired
    private DistanceCalculatorService distanceCalculatorService;

    @MockBean
    DistanceRepository distanceRepository;
    @MockBean
    CityRepository cityRepository;

    @Before
    public void setup() {

    }

    @Test
    public void calculateDistanceFromJhbToCpt(){

        Distance distance = new Distance("JHB", "CPT", 1000);

        when(distanceRepository.findByFromAndToCity(any(String.class), any(String.class))).thenReturn(distance);

        ApiResult result = distanceCalculatorService.calculateDistance("JHB", "CPT", 100);
        LocalTime convertedLocalTime = LocalTime.parse(result.getBody().getDuration());

        assertEquals(11, convertedLocalTime.getHourOfDay());
        assertEquals(40, convertedLocalTime.getMinuteOfHour());
    }

    @Test
    public void calculateDistanceFromJhbToCptWithFractionalHours(){

        Distance distance = new Distance("JHB", "CPT", 1300);

        when(distanceRepository.findByFromAndToCity(any(String.class), any(String.class))).thenReturn(distance);

        ApiResult result = distanceCalculatorService.calculateDistance("JHB", "CPT", 120);
        LocalTime convertedLocalTime = LocalTime.parse(result.getBody().getDuration());

        assertEquals(12, convertedLocalTime.getHourOfDay());
        assertEquals(29, convertedLocalTime.getMinuteOfHour());
    }

    @Test
    public void calculateDistanceWithNoDistanceFound(){

        ApiResult result = distanceCalculatorService.calculateDistance("JHB", "CPT", 120);

        assertEquals(DistanceCalculatorConstants.NO_DISTANCE_FOUND_CODE, result.getHeader().getCode());
    }

}
