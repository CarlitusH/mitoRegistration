package com.mito.matricula.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDetailDTO {
    private Long idDetailReg;
    private CourseDTO course;

    @NotBlank
    @NotNull
    private String classroomDetailReg;

    @JsonBackReference
    private RegistrationDTO registration;
}
