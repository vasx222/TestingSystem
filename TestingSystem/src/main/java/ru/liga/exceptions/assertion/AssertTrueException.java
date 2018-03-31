package ru.liga.exceptions.assertion;

public class AssertTrueException extends Exception {
    public AssertTrueException() {
        super("Input is not true!");
    }
}
