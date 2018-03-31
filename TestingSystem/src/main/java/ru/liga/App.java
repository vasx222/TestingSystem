package ru.liga;

import ru.liga.system.TestingSystem;
import ru.liga.tested.FailingTest;
import ru.liga.tested.IncorrectTest;
import ru.liga.tested.SimpleTest;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IllegalAccessException, InstantiationException {
        TestingSystem.runClass(SimpleTest.class);
        TestingSystem.runClass(FailingTest.class);
        TestingSystem.runClass(IncorrectTest.class);
    }

}
