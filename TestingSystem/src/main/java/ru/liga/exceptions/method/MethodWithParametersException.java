package ru.liga.exceptions.method;

import java.lang.reflect.Method;

public class MethodWithParametersException extends RuntimeException {
    public MethodWithParametersException(Method method) {
        super("Method " + method.getName() + " must not have parameters!");
    }
}
