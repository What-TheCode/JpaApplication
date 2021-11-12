package com.example.jpaapplication;

import com.example.jpaapplication.entity.book.Book;
import com.example.jpaapplication.entity.person.Address;
import com.example.jpaapplication.entity.person.Hobby;
import com.example.jpaapplication.entity.person.Person;
import com.example.jpaapplication.service.CountryService;
import com.example.jpaapplication.service.HobbyService;
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
    private final HobbyService hobbyService;
    private final Logger logger = LoggerFactory.getLogger(JpaApplication.class);

    public JpaApplication(CountryService countryService, PersonService personService, HobbyService hobbyService) {
        this.countryService = countryService;
        this.personService = personService;
        this.hobbyService = hobbyService;
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
//            System.out.println(this.countryService.getCountries());

//            Country countryById = this.countryService.getCountryById("CN");
//            System.out.println(countryById);
//
//            Country countryByName = this.countryService.getCountryByName("Japan");
//            System.out.println(countryByName);

//            System.out.println(this.personService.getPersonById(1));
//            System.out.println(this.personService.getPersonById(1));

//            this.personService.updatePersonFavoriteColor("V", "Yellow");
//            System.out.println(this.personService.getPersonByLastName("V"));

//            this.personService.removePerson("HGGKUG");
//            this.personService.removePerson("T");


//            this.personService.addPerson(new Person("Alexander",
//                    "VW",
//                    new Address("Dorpstraat", "101", "Oost-Vlaanderen", 9000),
//                    "Black"));

//            this.hobbyService.addHobby(new Hobby("Cycling", "Sports"));

//            System.out.println(this.personService.getPersonByLastName("VW"));

//            this.personService.updatePersonHobby("VW", new Hobby("Photography", "Arts"));
//            this.personService.updatePersonHobby("VW", new Hobby("Woodworking", "Arts"));

//            System.out.println(this.personService.getPersonByLastName("VW"));
//            System.out.println(this.personService.getPersonByLastName("VW"));

            System.out.println(this.personService.getPersonByLastName("VW"));

            this.personService.removeBooksContainingFirstChar("VW", 'a');

            System.out.println(this.personService.getPersonByLastName("VW"));
        } catch (RuntimeException e) {
            logger.warn(e.getMessage());
        }
    }
}
