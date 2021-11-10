package com.example.jpaapplication.service;

import com.example.jpaapplication.entity.country.Country;
import com.example.jpaapplication.repository.CountryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getCountries() {
        return this.countryRepository.getAllCountries();
    }

    public Country getCountryById(String countryId) {
        return this.countryRepository.getCountryById(countryId);
    }

    public Country getCountryByName(String countryName) {
        return this.countryRepository.getCountryByName(countryName);
    }
}
