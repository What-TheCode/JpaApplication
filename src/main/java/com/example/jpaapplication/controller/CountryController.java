package com.example.jpaapplication.controller;

import com.example.jpaapplication.entity.country.CountryDto;
import com.example.jpaapplication.mapper.CountryMapper;
import com.example.jpaapplication.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {
    private final CountryService countryService;
    private final CountryMapper countryMapper;

    public CountryController(CountryService countryService, CountryMapper countryMapper) {
        this.countryService = countryService;
        this.countryMapper = countryMapper;
    }

//    @GetMapping(produces = "application/json")
//    @ResponseStatus(HttpStatus.OK)
//    public List<CountryDto> getCountries(@RequestParam(name = "countryId", required = false) String countryId) {
//        return this.countryMapper.toDTO(this.countryService.getCountries(countryId));
//    }
}
