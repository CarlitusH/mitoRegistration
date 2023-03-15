package com.mito.matricula.service.impl;

import com.mito.matricula.entity.Registration;
import com.mito.matricula.repository.IGenericRepo;
import com.mito.matricula.repository.IRegistrationRepo;
import com.mito.matricula.service.IRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl extends CrudServiceImpl<Registration, Long> implements IRegistrationService {

    private final IRegistrationRepo repo;

    @Override
    public IGenericRepo<Registration, Long> returnRepo() {
        return repo;
    }


}
