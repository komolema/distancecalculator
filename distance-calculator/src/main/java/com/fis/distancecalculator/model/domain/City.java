package com.dc.distancecalculator.model.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {
    private String name;
    @Id
    private String code;

    public City(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public City(){}

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
