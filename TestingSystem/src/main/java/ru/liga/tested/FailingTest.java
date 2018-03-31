package ru.liga.tested;

import ru.liga.annotations.Test;
import ru.liga.assertion.Assertion;
import ru.liga.exceptions.assertion.AssertEqualsException;

public class FailingTest {
    @Test
    public void test() throws AssertEqualsException {
        Assertion.assertEquals(2 + 2, 5);
    }
}
