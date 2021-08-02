package com.bootcamp.petApi.service;

import com.bootcamp.petApi.dto.request.PersonDTO;
import com.bootcamp.petApi.dto.response.MessageResponseDTO;
import com.bootcamp.petApi.exception.PersonNotFoundException;
import com.bootcamp.petApi.mapper.PersonMapper;
import com.bootcamp.petApi.model.Person;
import com.bootcamp.petApi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PersonService {
    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave =  personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created a new person with ID " + savedPerson.getId())
                .build();
        // MessageResponseDTO
    }


    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO).collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        // Verificando se o usuário com o ID recebido existe
        Person person = verifyIfExists(id);
        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException {
        // Verificando se o usuário com o ID recebido existe
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    // Método que verifica se o usuário com o id informado existe
    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

}
