package com.example.jpaapplication.service;

import com.example.jpaapplication.entity.person.Hobby;
import com.example.jpaapplication.entity.person.Person;
import com.example.jpaapplication.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void addPerson(Person person) {
        this.personRepository.addPerson(person);
    }

    public Person getPersonById(int id) {
        if(this.personRepository.findById(id) == null) {
            throw new EntityNotFoundException("Person not found");
        }
        return this.personRepository.findById(id);
    }

    public Person getPersonByLastName(String lastName) {
        if(this.personRepository.findByLastName(lastName) == null) {
            throw new EntityNotFoundException("Person not found");
        }
        return this.personRepository.findByLastName(lastName);
    }

    public void updatePersonFavoriteColor(String lastName, String color) {
        if(this.personRepository.findByLastName(lastName) == null) {
            throw new EntityNotFoundException("Person not found");
        }
        this.personRepository.updateFavoriteColor(this.personRepository.findByLastName(lastName), color);
    }

    public void updatePersonHobby(String lastName, Hobby hobby) {
        if(this.personRepository.findByLastName(lastName) == null) {
            throw new EntityNotFoundException("Person not found");
        }
        this.personRepository.updateHobby(this.personRepository.findByLastName(lastName), hobby);
    }

    public void removePerson(String lastName) {
        if(this.personRepository.findByLastName(lastName) == null) {
            throw new EntityNotFoundException("Person not found");
        }
        this.personRepository.removePerson(this.personRepository.findByLastName(lastName));
    }
}
