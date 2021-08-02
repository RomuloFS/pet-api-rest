package com.bootcamp.petApi.repository;

import com.bootcamp.petApi.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>{
    // Entity, Id type


}
