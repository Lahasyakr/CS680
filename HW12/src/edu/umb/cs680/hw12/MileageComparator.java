package edu.umb.cs680.hw12;

import java.util.Comparator;

public class MileageComparator implements Comparator<Car> {

	public int compare(Car car1, Car car2) {
		return car1.get_mileage() - car2.get_mileage();
	}

}
