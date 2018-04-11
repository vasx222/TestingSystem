package ru.liga.exceptions.method;

import java.lang.reflect.Method;

public class StaticMethodException extends RuntimeException {
    public StaticMethodException(Method method) {
        super("Method " + method.getName() + " must not be static!");
    }
}
