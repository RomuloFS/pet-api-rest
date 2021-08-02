package com.bootcamp.petApi.dto.request;

import com.bootcamp.petApi.model.Pet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PersonDTO {

    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    @Size(min = 9, max = 11)
    private String phoneNumber;

    @NotEmpty
    private String adress;

    @NotEmpty
    @CPF
    private String cpf;

    @Valid
    private List<Pet> pets;
}
