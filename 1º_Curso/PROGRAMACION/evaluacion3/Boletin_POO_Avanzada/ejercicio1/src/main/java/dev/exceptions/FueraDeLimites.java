package dev.exceptions;

public class FueraDeLimites extends StringIndexOutOfBoundsException {
    public FueraDeLimites (String text) {
        super(text);
    }
};
