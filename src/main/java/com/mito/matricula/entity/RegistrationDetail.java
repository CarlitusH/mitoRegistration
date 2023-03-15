package com.mito.matricula.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "details_registration")
public class RegistrationDetail {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idDetailReg;

    @ManyToOne
    @JoinColumn(name = "id_course", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_DetailRegistration_Course"))
    private Course course;

    @Column(name = "classroom", nullable = false)
    private String classroomDetailReg;

    @ManyToOne
    @JoinColumn(name = "id_registration", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_DetailRegistration_Registration"))
    private Registration registration;


}
