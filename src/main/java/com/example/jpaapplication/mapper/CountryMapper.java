package com.example.jpaapplication.mapper;

import com.example.jpaapplication.entity.country.Country;
import com.example.jpaapplication.entity.country.CountryDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryMapper {

    public List<CountryDto> toDTO(List<Country> countries) {
        return countries.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private CountryDto toDTO(Country country) {
        return new CountryDto(country.getId(), country.getCountryName());
    }

}
