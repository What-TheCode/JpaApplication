package com.example.jpaapplication.service;

import com.example.jpaapplication.entity.person.Hobby;
import com.example.jpaapplication.repository.HobbyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HobbyService {
    private final HobbyRepository hobbyRepository;

    public HobbyService(HobbyRepository hobbyRepository) {
        this.hobbyRepository = hobbyRepository;
    }

    public void addHobby(Hobby hobbyToPersist) {
        this.hobbyRepository.addHobby(hobbyToPersist);
    }
}
