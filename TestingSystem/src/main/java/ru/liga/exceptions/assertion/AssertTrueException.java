package ru.liga.exceptions.assertion;

public class AssertTrueException extends RuntimeException {
    public AssertTrueException() {
        super("Input is not true!");
    }
}
