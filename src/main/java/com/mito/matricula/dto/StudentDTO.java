package com.mito.matricula.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private Long idStudent;

    @NotBlank
    @NotNull
    private String namesStudent;

    @NotBlank
    @NotNull
    private String lastNameStudent;

    @NotBlank
    @NotNull
    @Size(min = 8, max = 8, message = "The length must be 8 digits")
    private String dniStudent;

    @Min(value = 10)
    @NotNull
    private int ageStudent;

}
