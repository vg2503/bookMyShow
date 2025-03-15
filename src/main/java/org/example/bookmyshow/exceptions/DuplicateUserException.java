package org.example.bookmyshow.exceptions;

public class DuplicateUserException extends  Exception{
    public DuplicateUserException(String message){
        super(message);
    }
}
