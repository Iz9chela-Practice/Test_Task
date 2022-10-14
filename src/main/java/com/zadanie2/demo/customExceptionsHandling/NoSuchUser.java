package com.zadanie2.demo.customExceptionsHandling;

public class NoSuchUser extends RuntimeException {

    public NoSuchUser(String message){
        super(message);
    }

}
