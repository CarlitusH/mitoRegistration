package com.mito.matricula.controller;

import com.mito.matricula.config.ModelMapperConfig;
import com.mito.matricula.dto.CourseDTO;
import com.mito.matricula.entity.Course;
import com.mito.matricula.service.ICourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = {"api/v1/course"})
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService courseService;

    private final ModelMapperConfig mapper;


    @GetMapping
    public ResponseEntity<List<CourseDTO>> listAllCourses() throws Exception{
        List<CourseDTO> dtoList = courseService.listAllData().stream().map(this::convertToDto).toList();
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<CourseDTO> listCourseById(@PathVariable(name = "id") Long id) throws Exception{
        CourseDTO dto = convertToDto(courseService.listDataById(id));
        return new ResponseEntity<>(dto, HttpStatus.FOUND);
    }



    @PostMapping
    public ResponseEntity<CourseDTO> insertCourse(@Valid @RequestBody CourseDTO dto) throws Exception{
        Course course = convertToEntity(dto);
        return new ResponseEntity<>(convertToDto(courseService.addNewData(course)), HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<CourseDTO> updateCourse(@Valid @RequestBody CourseDTO dto) throws Exception{
        Course course = convertToEntity(dto);
        return new ResponseEntity<>(convertToDto(courseService.updateData(course)), HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable(name = "id") Long id) throws Exception{
        courseService.deleteData(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }





    private CourseDTO convertToDto(Course obj){
        return mapper.modelMapper().map(obj, CourseDTO.class);
    }

    private Course convertToEntity(CourseDTO obj){
        return mapper.modelMapper().map(obj, Course.class);
    }
}
