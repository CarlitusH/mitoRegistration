package com.mito.matricula.controller;

import com.mito.matricula.config.ModelMapperConfig;
import com.mito.matricula.dto.RegistrationDTO;
import com.mito.matricula.entity.Registration;
import com.mito.matricula.entity.RegistrationDetail;
import com.mito.matricula.service.IRegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.*;

@RestController
@RequestMapping(value = {"api/v1/registration"})
@RequiredArgsConstructor
public class RegistrationController {

    private final IRegistrationService service;
    private final ModelMapperConfig mapper;



    @GetMapping
    public ResponseEntity<List<RegistrationDTO>> listAllRegistrations() throws Exception{
        List<RegistrationDTO> dtos = service.listAllData().stream().map(this::convertToDto).toList();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }



    @GetMapping("registration_course")
    public ResponseEntity<Map<String, List<String>>> listCoursesAndStudents() throws Exception{

        Stream<List<RegistrationDetail>> listaDetails = service.listAllData().stream().map(Registration::getRegistrationDetails);

        Stream<RegistrationDetail> registros = listaDetails.flatMap(Collection::stream);

        Map<String, List<String>> mapa1 = registros.
                collect(Collectors.groupingBy((objReg) -> objReg.getCourse().getNameCourse(),
                        Collectors.mapping(reg->reg.getRegistration().getStudent().getNamesStudent(), Collectors.toList())));


        return new ResponseEntity<>(mapa1, HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<RegistrationDTO> insertRegistration(@Valid @RequestBody RegistrationDTO dto) throws Exception {

        Registration registration = convertToEntity(dto);

        return new ResponseEntity<>(convertToDto(service.addNewData(registration)), HttpStatus.CREATED);
    }



    private RegistrationDTO convertToDto(Registration obj){
        return mapper.modelMapper().map(obj, RegistrationDTO.class);
    }

    private Registration convertToEntity(RegistrationDTO obj){
        return mapper.modelMapper().map(obj, Registration.class);
    }
}
