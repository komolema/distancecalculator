package com.fis.distancecalculator.model.domain;

import javax.persistence.*;

@Entity
public class Distance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="cityFromCode")
    private String cityFromCode;
    @Column(name="cityToCode")
    private String cityToCode;
    private Integer distance;

    public Distance(String cityFromCode, String cityToCode, Integer distance){
        this.cityFromCode = cityFromCode;
        this.cityToCode = cityToCode;
        this.distance = distance;
    }

    public Distance(){}

    public String getCityFromCode() {
        return cityFromCode;
    }

    public String getCityToCode() {
        return cityToCode;
    }

    public Integer getDistance() {
        return distance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCityFromCode(String cityFromCode) {
        this.cityFromCode = cityFromCode;
    }

    public void setCityToCode(String cityToCode) {
        this.cityToCode = cityToCode;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
