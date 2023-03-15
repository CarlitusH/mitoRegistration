package com.mito.matricula.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrationDTO {
    private Long idRegistration;

    @NotNull
    private LocalDateTime dateRegistration;

    @NotNull
    private boolean stateRegistration;

    private StudentDTO student;

    @JsonManagedReference
    @NotNull
    private List<RegistrationDetailDTO> registrationDetails;
}
