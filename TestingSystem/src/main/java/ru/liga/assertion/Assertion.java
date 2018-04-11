package ru.liga.assertion;

import ru.liga.exceptions.assertion.AssertEqualsException;
import ru.liga.exceptions.assertion.AssertNotNullException;
import ru.liga.exceptions.assertion.AssertTrueException;

public class Assertion {
    public static void assertTrue(boolean input) {
        if (!input) {
            throw new AssertTrueException();
        }
    }
    public static void assertEquals(Object input1, Object input2) {
        if (!input1.equals(input2)) {
            throw new AssertEqualsException();
        }
    }
    public static void assertNotNull(Object input) {
        if (input == null) {
            throw new AssertNotNullException();
        }
    }
}
