package com.example.exeption;

public class EntityNotFoundExeption extends RuntimeException{
    public EntityNotFoundExeption(){

    }
    public EntityNotFoundExeption(String message){
        super(message);
    }
}
