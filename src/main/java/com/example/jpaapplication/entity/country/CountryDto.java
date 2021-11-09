package com.example.jpaapplication.entity.country;

import javax.persistence.Column;

public class CountryDto {
    private String id;
    private String countryName;

    public CountryDto(String id, String countryName) {
        this.id = id;
        this.countryName = countryName;
    }

    public String getId() {
        return id;
    }

    public String getCountryName() {
        return countryName;
    }
}
