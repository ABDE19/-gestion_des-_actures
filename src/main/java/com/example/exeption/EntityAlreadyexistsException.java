package com.example.exeption;

public class EntityAlreadyexistsException extends RuntimeException {
    public EntityAlreadyexistsException(){

    }
    public EntityAlreadyexistsException(String message){
        super(message);
    }
}
