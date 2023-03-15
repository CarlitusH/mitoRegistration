package com.mito.matricula.service.impl;

import com.mito.matricula.entity.Course;
import com.mito.matricula.repository.ICourseRepo;
import com.mito.matricula.repository.IGenericRepo;
import com.mito.matricula.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CrudServiceImpl<Course, Long> implements ICourseService {


    private final ICourseRepo iCourseRepo;

    @Override
    public IGenericRepo<Course, Long> returnRepo() {
        return iCourseRepo;
    }

}
