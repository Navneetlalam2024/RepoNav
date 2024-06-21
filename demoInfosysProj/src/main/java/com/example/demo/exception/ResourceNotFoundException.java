package com.example.demo.exception;

/**
 * @author Navneet Lalam
 * @version 1.0
 * @since 2024-06-20
 */
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("Resource not found exception !!");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
