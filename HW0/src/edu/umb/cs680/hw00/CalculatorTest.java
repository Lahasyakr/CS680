package edu.umb.cs680.hw00;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	@Test
	public void multiply4By4() {
		Calculator multi = new Calculator();
		float expected = 16;
		float actual = multi.multiply(4,4);
		assertEquals(expected, actual);
	}
    @Test
	public void divide16By2(){
		Calculator divide = new Calculator();
		float expected = 8;
		float actual = divide.divide(16,2);
		assertEquals(expected, actual);
	}
	@Test
	public void divide5By2(){
		Calculator divide = new Calculator();
		float expected = 2.5f;
		float actual = divide.divide(5,2);
		assertEquals(expected, actual);
	}
	@Test
	public void divide10By0withException(){
		Calculator divide = new Calculator();
		try{
			divide.divide(10, 0);
			fail("Division by zero");
		}
		catch(IllegalArgumentException error){
			assertEquals("division by zero", error.getMessage());
		}
	}
}