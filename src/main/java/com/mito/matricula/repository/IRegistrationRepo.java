package com.mito.matricula.repository;

import com.mito.matricula.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRegistrationRepo extends IGenericRepo<Registration, Long> {
}
