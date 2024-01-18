package com.example.exeption.handller;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.exeption.EntityAlreadyexistsException;
import com.example.exeption.EntityNotFoundExeption;
import com.example.shard.ErrorMessage;

@RestControllerAdvice

public class HandlerExiption {
    @ExceptionHandler(value = {EntityNotFoundExeption.class})
    public ResponseEntity<Object> entityNotFoundExeption(EntityNotFoundExeption ex){
        ErrorMessage errorMessage=ErrorMessage.builder()
        .message(ex.getMessage())
        .timestamp(new Date(0))
        .code(404)
        .build();
        return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
    }

        @ExceptionHandler(value = {EntityAlreadyexistsException.class})
    public ResponseEntity<Object> entityAlreadyexistsException(EntityAlreadyexistsException ex){
        ErrorMessage errorMessage=ErrorMessage.builder()
        .message(ex.getMessage())
        .timestamp(new Date(0))
        .code(409)
        .build();
        return new ResponseEntity<>(errorMessage,HttpStatus.CONFLICT);
    }
        @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handlerMethodeArgumentVotValid(MethodArgumentNotValidException ex){
        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error->
        errors.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(errors,HttpStatus.UNPROCESSABLE_ENTITY);
    }
 }
