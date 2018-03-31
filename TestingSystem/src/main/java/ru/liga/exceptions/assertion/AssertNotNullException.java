package ru.liga.exceptions.assertion;

public class AssertNotNullException extends Exception {
    public AssertNotNullException() {
        super("Input is null!");
    }
}
