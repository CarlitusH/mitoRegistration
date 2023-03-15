package com.mito.matricula.service.impl;

import com.mito.matricula.entity.Student;
import com.mito.matricula.repository.IGenericRepo;
import com.mito.matricula.repository.IStudentRepo;
import com.mito.matricula.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CrudServiceImpl<Student, Long> implements IStudentService {


    private final IStudentRepo iStudentRepo;

    @Override
    public IGenericRepo<Student, Long> returnRepo() {
        return iStudentRepo;
    }



}
