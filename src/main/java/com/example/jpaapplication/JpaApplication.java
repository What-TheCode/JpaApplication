package com.example.jpaapplication;

import com.example.jpaapplication.entity.country.Country;
import com.example.jpaapplication.entity.person.Person;
import com.example.jpaapplication.service.CountryService;
import com.example.jpaapplication.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {
    private final CountryService countryService;
    private final PersonService personService;
    private final Logger logger = LoggerFactory.getLogger(JpaApplication.class);

    public JpaApplication(CountryService countryService, PersonService personService) {
        this.countryService = countryService;
        this.personService = personService;
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            System.out.println(this.countryService.getCountries());

            Country countryById = this.countryService.getCountryById("CN");
            System.out.println(countryById);

            Country countryByName = this.countryService.getCountryByName("Japan");
            System.out.println(countryByName);

            this.personService.addPerson(new Person("Amadeo", "T", "Green"));

            System.out.println(this.personService.getPersonById(0));
            System.out.println(this.personService.getPersonById(1));

            this.personService.updatePersonFavoriteColor("VW", "Yellow");
            System.out.println(this.personService.getPersonByLastName("VW"));

//            this.personService.removePerson("HGGKUG");
//            this.personService.removePerson("T");
        } catch (RuntimeException e) {
            logger.warn(e.getMessage());
        }
    }
}
