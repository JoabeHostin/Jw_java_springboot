package com.jw.jw_mecanica.handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jw.jw_mecanica.models.error.ErrorMessage;
import com.jw.jw_mecanica.models.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandle {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> hendleResourceNotFoundException(ResourceNotFoundException ex){

    ErrorMessage error = new ErrorMessage("Recurso não encontrado", 404, ex.getMessage());
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);


    }

    
}
