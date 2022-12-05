
package edu.umb.cs680.hw12;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParetoComparatorTest {

    static ArrayList<Car> usedCars = new ArrayList<>();

    @BeforeAll
    public static void testSetup() {

        usedCars.add(new Car("Honda", "Accord", 34, 2022, 28000f));
        usedCars.add(new Car("Ford", "Bronco", 22, 2019, 44000f));
        usedCars.add(new Car("Kia", "K5", 32, 2021, 25000f));
        usedCars.add(new Car("Hyundai", "Sonata", 36, 2018, 32000f));
        usedCars.add(new Car("Range Rover", "Evoque", 48, 2017, 52000f));
        usedCars.add(new Car("Mazda", "CX-5", 28, 2016, 33000f));

        for (Car car : usedCars) {
            car.setDominationCount(usedCars);
        }

        Collections.sort(usedCars, new ParetoComparator());
    }

    @Test
    public void paretoSort() {
        ArrayList<Integer> actual = new ArrayList<>();
        ArrayList<Integer> expected = new ArrayList<>();

        expected.add(2);
        expected.add(2);
        expected.add(1);
        expected.add(1);
        expected.add(0);
        expected.add(0);
        for (int i = 0; i < 6; i++)
            actual.add(usedCars.get(i).getDominationCount());
        assertEquals(expected, actual);
    }

    @Test
    public void firstCarTest() {
        assertEquals(2, usedCars.get(0).getDominationCount());
    }

    @Test
    public void secondCarTest() {
        assertEquals(2, usedCars.get(1).getDominationCount());
    }

    @Test
    public void thirdCarTest() {
        assertEquals(1, usedCars.get(2).getDominationCount());
    }

    @Test
    public void fourthCarTest() {
        assertEquals(1, usedCars.get(3).getDominationCount());
    }
}