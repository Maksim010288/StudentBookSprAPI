package com.example.demo.exeption;

public class NotFoundException extends Exception {

    public static Exception notFound(String message){
        return new Exception(message);
    }
}
