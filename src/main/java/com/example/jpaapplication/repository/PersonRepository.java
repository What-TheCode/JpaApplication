package com.example.jpaapplication.repository;

import com.example.jpaapplication.entity.person.Hobby;
import com.example.jpaapplication.entity.person.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void addPerson(Person personToPersist) {
        this.entityManager.persist(personToPersist);
    }

    public Person findById(int id) {
        return this.entityManager.find(Person.class, id);
    }

    public Person findByLastName(String lastName) {
        return this.entityManager.createQuery("SELECT p FROM Person p WHERE p.lastname = :lastName", Person.class)
                .setParameter("lastName", lastName)
                .getSingleResult();
    }

    public void updateHobby(Person person, Hobby hobby) {
        person.updateHobby(hobby);
    }

    public void updateFavoriteColor(Person person, String color) {
        person.updateFavoriteColor(color);
    }

    public void removePerson(Person person) {
        this.entityManager.remove(person);
    }


}
