package com.mito.matricula.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "course")
public class Course {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idCourse;

    @Column(name = "name", nullable = false)
    private String nameCourse;

    @Column(name = "acronym", nullable = false)
    private String acronymCourse;

    @Column(name = "state", nullable = false)
    private boolean stateCourse;

}
