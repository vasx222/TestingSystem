package ru.liga.system;

import ru.liga.annotations.After;
import ru.liga.annotations.Before;
import ru.liga.annotations.Test;
import ru.liga.exceptions.method.ManyMethodsException;
import ru.liga.exceptions.method.MethodWithParametersException;
import ru.liga.exceptions.method.StaticMethodException;
import ru.liga.lib.ReflectionHelper;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

public class TestingSystem {
    private static Method getSingleMethod(Class testClass, Class neededClass)
            throws ManyMethodsException {
        List<Method> methods = ReflectionHelper
                .findAnnotatedMethods(testClass, neededClass);
        Method method = null;

        if (methods.size() > 1) {
            throw new ManyMethodsException(neededClass);
        } else {
            if (methods.size() == 1) {
                method = methods.get(0);
            }
        }
        return method;
    }

    private static void checkThatIsNotStatic(Method method) {
        if (Modifier.isStatic(method.getModifiers())) {
            throw new StaticMethodException(method);
        }
    }
    private static void checkThatIsNotStatic(List<Method> methods)
            throws StaticMethodException {
        for (Method method : methods) {
            checkThatIsNotStatic(method);
        }
    }

    private static void checkThatNoParameters(Method method)
            throws MethodWithParametersException {
        if (method.getParameterCount() > 0) {
            throw new MethodWithParametersException(method);
        }
    }

    private static void checkThatNoParameters(List<Method> methods)
            throws MethodWithParametersException {
        for (Method method : methods) {
            checkThatNoParameters(method);
        }
    }

    public static void runClass(Class testClass)
            throws IllegalAccessException, InstantiationException {
        Object mainClass = testClass.newInstance();
        Method beforeMethod, afterMethod;
        List<Method> testMethods;
        try {
            beforeMethod = getSingleMethod(testClass, Before.class);
            afterMethod = getSingleMethod(testClass, After.class);

            testMethods = ReflectionHelper
                    .findAnnotatedMethods(testClass, Test.class);

            if (beforeMethod != null) {
                checkThatIsNotStatic(beforeMethod);
                checkThatNoParameters(beforeMethod);
            }
            if (afterMethod != null) {
                checkThatIsNotStatic(afterMethod);
                checkThatNoParameters(afterMethod);
            }
            checkThatIsNotStatic(testMethods);
            checkThatNoParameters(testMethods);

        } catch (Exception e) {
            System.out.println("Failed to run tests because of exception");
            e.printStackTrace();
            return;
        }

        int testNumber = 0;
        for (Method testMethod : testMethods) {
            testNumber++;
            try {
                if (beforeMethod != null) {
                    beforeMethod.invoke(mainClass);
                }
                testMethod.invoke(mainClass);
                if (afterMethod != null) {
                    afterMethod.invoke(mainClass);
                }
            } catch (Exception e) {
                System.out.println("Error occurred during test #" + testNumber);
                e.printStackTrace();
                return;
            }
        }
        System.out.println("All tests passed!");
    }
}
