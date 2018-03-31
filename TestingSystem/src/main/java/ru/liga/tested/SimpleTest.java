package ru.liga.tested;

import ru.liga.annotations.After;
import ru.liga.annotations.Before;
import ru.liga.annotations.Test;
import ru.liga.assertion.Assertion;
import ru.liga.exceptions.assertion.AssertEqualsException;
import ru.liga.exceptions.assertion.AssertNotNullException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleTest {
    private List<Integer> numbers;
    @Before
    public void before() {
        System.out.println("before");
        numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    @Test
    public void countSum() throws AssertEqualsException, AssertNotNullException {
        System.out.println("countSum");
        Assertion.assertNotNull(numbers);
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        Assertion.assertEquals(sum, 55);
    }

    @Test
    public void countProduct() throws AssertEqualsException, AssertNotNullException {
        System.out.println("countProduct");
        Assertion.assertNotNull(numbers);
        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        Assertion.assertEquals(product, 3628800);
    }

    @After
    public void after() {
        System.out.println("after");
    }
}
