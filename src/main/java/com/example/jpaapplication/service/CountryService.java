package com.example.jpaapplication.service;

import com.example.jpaapplication.entity.country.Country;
import com.example.jpaapplication.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getCountries() {
        return this.countryRepository.getAllCountries();
    }
}
