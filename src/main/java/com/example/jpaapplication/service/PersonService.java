package com.example.jpaapplication.service;

import com.example.jpaapplication.entity.book.Book;
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
        personExistCheckBasedOnLastName(lastName);
        return this.personRepository.findByLastName(lastName);
    }

    public void updatePersonFavoriteColor(String lastName, String color) {
        personExistCheckBasedOnLastName(lastName);
        this.personRepository.updateFavoriteColor(this.personRepository.findByLastName(lastName), color);
    }

    public void updatePersonHobby(String lastName, Hobby hobby) {
        personExistCheckBasedOnLastName(lastName);
        this.personRepository.updateHobby(this.personRepository.findByLastName(lastName), hobby);
    }

    public void addBook(String lastName, Book book) {
        personExistCheckBasedOnLastName(lastName);
        this.personRepository.addBook(this.personRepository.findByLastName(lastName), book);
    }

    public void removeBooksContainingFirstChar(String lastName, char character) {
        personExistCheckBasedOnLastName(lastName);
        this.personRepository.removeBooksContainingChar(this.personRepository.findByLastName(lastName), character);
    }

    public void removePerson(String lastName) {
        personExistCheckBasedOnLastName(lastName);
        this.personRepository.removePerson(this.personRepository.findByLastName(lastName));
    }



    //HELPER METHODS
    private void personExistCheckBasedOnLastName(String lastName) {
        if(this.personRepository.findByLastName(lastName) == null) {
            throw new EntityNotFoundException("Person not found");
        }
    }
}
