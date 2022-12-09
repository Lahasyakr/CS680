package edu.umb.cs680.hw17.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*This class is used to test the Observable and Observer classes, using multicast*/
public class ObserverTest {
	
	//Captures the console log, to prove the observers are being notified
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}
	
	@Test
	public void testStockQuote() {
		StockQuoteObservable item = new StockQuoteObservable();
		LineChartObserver lineChartObserver = new LineChartObserver();
		TableObserver tableObserver = new TableObserver();
		Three_3_DObserver ThreeDObserver = new Three_3_DObserver();

		item.addObserver(lineChartObserver);
		item.addObserver(tableObserver);
		item.addObserver(ThreeDObserver);
		
		StockEvent a = new StockEvent("item", 100);
		StockEvent b = new StockEvent("item", 120);
		StockEvent c = new StockEvent("item", 150);
		
		item.notifyObservers(a);
		item.notifyObservers(b);
		item.notifyObservers(c);
		
		String expected = " Line Chart Observer of StockEvent:Shown here  item 100.0Table Observer of StockEvent:Shown here  item 100.0 3D Observer of StockEvent:Shown here  item 100.0 Line Chart Observer of StockEvent:Shown here  item 120.0Table Observer of StockEvent:Shown here  item 120.0 3D Observer of StockEvent:Shown here  item 120.0 Line Chart Observer of StockEvent:Shown here  item 150.0Table Observer of StockEvent:Shown here  item 150.0 3D Observer of StockEvent:Shown here  item 150.0";
		
		
		assertEquals(expected, outContent.toString());
	}
	
}