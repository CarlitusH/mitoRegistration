package com.mito.matricula.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "student")
public class Student {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idStudent;

    @Column(name = "names", nullable = false)
    private String namesStudent;

    @Column(name = "lastname", nullable = false)
    private String lastNameStudent;

    @Column(name = "dni", nullable = false)
    private String dniStudent;

    @Column(name = "age", nullable = false)
    private int ageStudent;



}
