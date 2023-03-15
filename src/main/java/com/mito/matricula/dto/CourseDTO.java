package com.mito.matricula.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    private Long idCourse;

    @NotBlank
    @NotNull
    private String nameCourse;

    @NotBlank
    @NotNull
    @Size(min = 2, max = 5, message = "The length must be between 2 and 5 characters")
    private String acronymCourse;

    @NotNull
    private boolean stateCourse;

}
