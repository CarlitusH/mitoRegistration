package com.mito.matricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;



@NoRepositoryBean
public interface IGenericRepo<T, R> extends JpaRepository<T, R> {





}
