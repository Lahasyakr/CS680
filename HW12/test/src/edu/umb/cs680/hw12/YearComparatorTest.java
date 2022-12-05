
package edu.umb.cs680.hw12;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class YearComparatorTest {

	static ArrayList<Car> usedCars = new ArrayList<>();

	@BeforeAll
	public static void testSetup() {

		usedCars.add(new Car("Honda", "Accord", 34, 2022, 28000f));
		usedCars.add(new Car("Ford", "Bronco", 22, 2019, 44000f));
		usedCars.add(new Car("Kia", "K5", 32, 2021, 25000f));
		usedCars.add(new Car("Hyundai", "Sonata", 36, 2018, 32000f));
		usedCars.add(new Car("Range Rover", "Evoque", 48, 2017, 52000f));
		usedCars.add(new Car("Mazda", "CX-5", 28, 2016, 33000f));

		// Applying price comparator
		Collections.sort(usedCars, new YearComparator());

	}

	@Test
	public void yearSort() {
		ArrayList<Integer> actual = new ArrayList<>();
		ArrayList<Integer> expected = new ArrayList<>();

		expected.add(2016);
		expected.add(2017);
		expected.add(2018);
		expected.add(2019);
		expected.add(2021);
		expected.add(2022);

		for (Car c : usedCars)
			actual.add(c.get_year());

		assertEquals(actual, expected);
	}

	@Test
	public void testFirstCar() {
		Car expected = (new Car("Mazda", "CX-5", 28, 2016, 33000f));
		System.out.println(usedCars);
		Car actual = usedCars.get(0);
		assertEquals(expected.get_year(), actual.get_year());
	}

	@Test
	public void testSecondCar() {
		Car expected = (new Car("Range Rover", "Evoque", 48, 2017, 52000f));
		System.out.println(usedCars);
		Car actual = usedCars.get(1);
		assertEquals(expected.get_year(), actual.get_year());
	}

	@Test
	public void testThirdCar() {
		Car expected = (new Car("Hyundai", "Sonata", 36, 2018, 32000f));
		System.out.println(usedCars);
		Car actual = usedCars.get(2);
		assertEquals(expected.get_year(), actual.get_year());
	}

}