package ru.liga.exceptions.assertion;

public class AssertNotNullException extends RuntimeException {
    public AssertNotNullException() {
        super("Input is null!");
    }
}
