package ru.liga.exceptions.assertion;

public class AssertEqualsException extends Exception {
    public AssertEqualsException() {
        super("Inputs are not equal!");
    }
}
