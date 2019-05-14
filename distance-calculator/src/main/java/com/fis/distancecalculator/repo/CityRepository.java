package com.fis.distancecalculator.repo;

import com.fis.distancecalculator.model.domain.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, String> {
    @Query("SELECT c FROM City c WHERE c.code=:code")
    City findByCode(@Param("code") String code);
}
