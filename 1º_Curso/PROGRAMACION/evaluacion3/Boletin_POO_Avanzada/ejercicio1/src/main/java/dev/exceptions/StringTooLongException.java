package dev.exceptions;

public class StringTooLongException extends IllegalArgumentException{
    public StringTooLongException(String text){
        super(text);
    }
}
