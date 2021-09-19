package com.dc.distancecalculator.repo;

import com.dc.distancecalculator.model.domain.Distance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistanceRepository extends CrudRepository<Distance, Long> {

    @Query(value = "SELECT d FROM Distance d WHERE d.cityFromCode=:fromCityCode and d.cityToCode=:toCityCode")
    Distance findByFromAndToCity(@Param("fromCityCode") String fromCityCode,
                                       @Param("toCityCode") String toCityCode);
}
