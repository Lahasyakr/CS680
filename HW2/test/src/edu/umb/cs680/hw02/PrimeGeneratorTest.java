
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw02.PrimeGenerator;


public class PrimeGeneratorTest {
    @Test
	public void primeGenFrom1To10() {
		PrimeGenerator primeGen = new PrimeGenerator( 1, 10);
        primeGen.generatePrimes();
        System.out.println(primeGen.getPrimes());
        Long[] expected = new Long[]{2L,3L,5L,7L};
		assertArrayEquals(expected, primeGen.getPrimes().toArray()); 
	}

    @Test
	public void primeGenFrom20To30() {
		PrimeGenerator primeGen = new PrimeGenerator( 20, 30);
        primeGen.generatePrimes();
        System.out.println(primeGen.getPrimes());
        Long[] expected = new Long[]{23L, 29L};
		assertArrayEquals(expected, primeGen.getPrimes().toArray()); 
	}
    
    @Test
	public void primeGenFrom20To10() {
		long from=20;
		long to=10;
				try {
					PrimeGenerator primeGen=new PrimeGenerator(from,to);
					primeGen.generatePrimes();
					Long[] expectedPrimes = {};
					assertArrayEquals(expectedPrimes,primeGen.getPrimes().toArray());
					
				}catch(RuntimeException e) {
					assertEquals("Wrong input values: from=" + from + " to=" + to,e.getMessage());
					
				}
	}


    @Test
	public void primeGenFrom_neg20To10() {
		long from=-20;
		long to=10;
				try {
					PrimeGenerator primeGen=new PrimeGenerator(from,to);
					primeGen.generatePrimes();
					Long[] expectedPrimes = {};
					assertArrayEquals(expectedPrimes,primeGen.getPrimes().toArray());
					
				}catch(RuntimeException e) {
					assertEquals("Wrong input values: from=" + from + " to=" + to,e.getMessage());
					
				}
	}

    @Test
	public void primeGenForSameNumbers() {
		long from=20;
		long to=20;
				try {
					PrimeGenerator primeGen=new PrimeGenerator(from,to);
					primeGen.generatePrimes();
					Long[] expectedPrimes = {};
					assertArrayEquals(expectedPrimes,primeGen.getPrimes().toArray());
					
				}catch(RuntimeException e) {
					assertEquals("Wrong input values: from=" + from + " to=" + to,e.getMessage());
					
				}
	}

    
}
