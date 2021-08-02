package com.bootcamp.petApi.service;

import com.bootcamp.petApi.dto.response.MessageResponseDTO;
import com.bootcamp.petApi.model.Person;
import com.bootcamp.petApi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person){
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created a new Pet with ID " + savedPerson.getId())
                .build();
        // MessageResponseDTO
    }
}
