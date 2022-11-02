package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

	
	private String[] carToStringArray(Car newCar) {
		String[] car_details= {
			newCar.get_make(),
			newCar.get_model(),
				String.valueOf(newCar.get_year())
		};
		
		return car_details;
	}

	@Test
	public void verifyCarEqualityWithMakeModelYear() {
		String[] expected = { "Toyota", "RAV4", "2018" };
		Car c1=new Car("Toyota","RAV4",60,2018,55000);
		assertArrayEquals(expected,carToStringArray(c1));
		
	}

	@Test
    public void testNotNull() {
        Car c1 = new Car("Audi", "Q7",50, 2018, 80000);
        assertNotNull(c1);
    }
	
	@Test
	public void verifyDifferentCarObjects() {
		Car c2=new Car("Toyota","RAV4",70,2018,70000);
		String [] expected={"Mazda","xxx","2018"};
		assertNotEquals(expected, carToStringArray(c2));
	}
	
	@Test
	public void testCarDetails() {
		Car c3=new Car("porsche","Taycan",250,2020,120000);
		String [] expected= {"porsche","Taycan","2020"};
		assertArrayEquals(expected, carToStringArray(c3));
	}
}