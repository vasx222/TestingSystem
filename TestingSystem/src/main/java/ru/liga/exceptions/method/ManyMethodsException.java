package ru.liga.exceptions.method;

public class ManyMethodsException extends RuntimeException {
    public ManyMethodsException() {
        super("Testable class can contain no more than one method!");
    }
    public ManyMethodsException(Class neededClass) {
        super("Testable class can contain no more than one @" +
                neededClass.getSimpleName() + " method!");
    }
}
