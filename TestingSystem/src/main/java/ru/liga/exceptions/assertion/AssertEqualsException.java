package ru.liga.exceptions.assertion;

public class AssertEqualsException extends RuntimeException {
    public AssertEqualsException() {
        super("Inputs are not equal!");
    }
}
