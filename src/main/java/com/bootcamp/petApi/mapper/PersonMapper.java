package com.bootcamp.petApi.mapper;

import com.bootcamp.petApi.dto.request.PersonDTO;
import com.bootcamp.petApi.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person toModel(PersonDTO personDTO);
    PersonDTO toDTO(Person person);
}
