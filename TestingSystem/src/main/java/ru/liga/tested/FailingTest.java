package ru.liga.tested;

import ru.liga.annotations.Test;
import ru.liga.assertion.Assertion;

public class FailingTest {
    @Test
    public void test() {
        Assertion.assertEquals(2 + 2, 5);
    }
}
