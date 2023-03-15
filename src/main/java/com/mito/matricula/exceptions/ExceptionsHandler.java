package com.mito.matricula.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.util.stream.Collectors;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class ExceptionsHandler  extends ResponseEntityExceptionHandler{


    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex,  HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(ex.getStatusCode(), "Route not Implemented");

        problemDetail.setType(URI.create(request.getContextPath()));
        problemDetail.setTitle("ROUTE NOT IMPLEMENTED");

        return  ResponseEntity.status(status).body(problemDetail);

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        String concatMessage = ex.getBindingResult().getFieldErrors().stream().map((obj)-> obj.getField() + ": " + obj.getDefaultMessage()).collect(Collectors.joining(" "));
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status, concatMessage);

        problemDetail.setType(URI.create(request.getContextPath()));
        problemDetail.setTitle("INPUT DATA ERROR");

        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
    }


    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ProblemDetail> handlerDataNotFoundException(DataNotFoundException ex, WebRequest request){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());

        problemDetail.setType(URI.create(request.getContextPath()));
        problemDetail.setTitle("DATA NOT FOUND");

        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
    }


}
