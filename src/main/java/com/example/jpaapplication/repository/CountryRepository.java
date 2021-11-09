package com.example.jpaapplication.repository;

import com.example.jpaapplication.entity.country.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CountryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public CountryRepository() {
    }

    public List<Country> getAllCountries() {
        return this.entityManager
                .createQuery("SELECT c FROM Country c", Country.class)
                .getResultList();
    }

    public Country getCountryById(String countryId) {
        return this.entityManager
                .createQuery("SELECT c FROM Country c WHERE c.id = :countryId", Country.class)
                .setParameter("countryId", countryId)
                .getSingleResult();
    }

    public Country getCountryByName(String countryName) {
        return this.entityManager
                .createQuery("SELECT c FROM Country c WHERE c.countryName = :countryName", Country.class)
                .setParameter("countryName", countryName)
                .getSingleResult();
    }
}
