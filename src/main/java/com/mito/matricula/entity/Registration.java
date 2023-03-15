package com.mito.matricula.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "registration")
public class Registration {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idRegistration;


    @Column(name = "date_registration", nullable = false)
    private LocalDateTime dateRegistration;

    @Column(name = "state", nullable = false)
    private boolean stateRegistration;

    @ManyToOne
    @JoinColumn(name = "id_student", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_Registration_Student"))
    private Student student;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "registration")
    @ToString.Exclude
    private List<RegistrationDetail> registrationDetails;


}
