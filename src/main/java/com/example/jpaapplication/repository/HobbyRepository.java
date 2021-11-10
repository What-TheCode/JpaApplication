package com.example.jpaapplication.repository;

import com.example.jpaapplication.entity.person.Hobby;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class HobbyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public HobbyRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addHobby(Hobby hobbyToPersist) {
        this.entityManager.persist(hobbyToPersist);
    }

}
