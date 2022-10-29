
package edu.umb.cs680.hw04;

public class Car {
 
	private String make,model;
	private int mileage,year;
	private float price;
	
	
	Car(String make,String model,int mileage,int year,float price)
	{
		this.make=make;
		this.model=model;
		this.mileage=mileage;
		this.year=year;
		this.price=price;
	}
	
	public String get_make()
	{
		return make;
	}
	
	public String get_model() {
		return model;
	}
	
	public int get_mileage() {
		return mileage;
	}
	
	public int get_year() {
		return year;
	}
	
	public float get_price() {
		return price;
	}
	
	public static void main(String args[]) {
		Car c=new Car("Audi","Q4 Etron",320,2022,50000);
		System.out.println("Make    :"+c.get_make());
		System.out.println("Model    :"+c.get_model());
		System.out.println("Mileage  :"+c.get_mileage());
		System.out.println("Year     :"+c.get_year());
		System.out.println("Price    :"+c.get_price());
	}
}