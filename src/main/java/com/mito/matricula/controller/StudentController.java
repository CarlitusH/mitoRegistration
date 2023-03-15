package com.mito.matricula.controller;

import com.mito.matricula.config.ModelMapperConfig;
import com.mito.matricula.dto.StudentDTO;
import com.mito.matricula.entity.Student;
import com.mito.matricula.service.IStudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = {"api/v1/student"})
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService studentService;

    private final ModelMapperConfig mapper;


    @GetMapping
    public ResponseEntity<List<StudentDTO>> listAllStudents() throws Exception{
        List<StudentDTO> studentDTOList = studentService.listAllData().stream().map(this::convertToDto).toList();

        return new ResponseEntity<>(studentDTOList, HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<StudentDTO> listStudentById(@PathVariable(name = "id") Long id) throws Exception{
        StudentDTO dto = convertToDto(studentService.listDataById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<StudentDTO> insertStudent(@Valid @RequestBody StudentDTO dto) throws Exception{
        Student student = convertToEntity(dto);
        return new ResponseEntity<>(convertToDto(studentService.addNewData(student)),HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<StudentDTO> updateStudent(@Valid @RequestBody StudentDTO dto) throws Exception{
        Student student = convertToEntity(dto);
        return new ResponseEntity<>(convertToDto(studentService.updateData(student)),HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable(name = "id") Long id) throws Exception{
        studentService.deleteData(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Prueba de listado de student por edad descendente
    @GetMapping("order")
    public ResponseEntity<List<StudentDTO>> listAllStudentsByAgeDesc() throws Exception {
        List<Student> studentList = studentService.listAllData().stream().sorted(Comparator.comparingInt(Student::getAgeStudent)).toList();

        List<StudentDTO> studentDTOS = studentList.stream().map(this::convertToDto).toList();

        return new ResponseEntity<>(studentDTOS, HttpStatus.OK);
    }


    private StudentDTO convertToDto(Student obj){
        return mapper.modelMapper().map(obj, StudentDTO.class);
    }

    private Student convertToEntity(StudentDTO obj){
        return mapper.modelMapper().map(obj, Student.class);
    }

}
