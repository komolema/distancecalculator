package com.fis.distancecalculator.api;

import com.fis.distancecalculator.model.api.ApiResult;
import com.fis.distancecalculator.service.DistanceCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("distance")
public class DistanceCalculatorController {

    private DistanceCalculatorService distanceCalculatorService;


    @GetMapping("/calculate-distance/{fromCityCode}/{toCityCode}/{averageSpeed}")
    public ApiResult calculateDistance(@PathVariable("fromCityCode") String fromCityCode,
                                       @PathVariable("toCityCode") String toCityCode,
                                       @PathVariable("averageSpeed") Integer averageSpeed){
        return distanceCalculatorService.calculateDistance(fromCityCode, toCityCode, averageSpeed);
    }

    @Autowired
    public void setDistanceCalculatorService(DistanceCalculatorService distanceCalculatorService) {
        this.distanceCalculatorService = distanceCalculatorService;
    }
}
