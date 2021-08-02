package com.bootcamp.petApi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PetDTO {

    private Long id;
    private String name;
    private String breed; // raça
    private String gender;
    private String birthdate;

}
