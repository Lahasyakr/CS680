package edu.umb.cs680.hw17.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ObserverTest {

	// Captures the console log
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@Test
	public void testStockQuotewithTable() {
		StockQuoteObservable item = new StockQuoteObservable();
		TableObserver tableObserver = new TableObserver();
		item.addObserver(tableObserver);
		StockEvent a = new StockEvent("crash", 100);
		item.notifyObservers(a);
		String expected = "Table Observer of StockEvent:Shown here  crash 100.0";
		assertEquals(expected, outContent.toString());
	}

	@Test
	public void testStockQuotewithLineChart() {
		StockQuoteObservable item = new StockQuoteObservable();
		LineChartObserver lineChartObserver = new LineChartObserver();
		item.addObserver(lineChartObserver);
		StockEvent a = new StockEvent("plummet", 400);
		item.notifyObservers(a);
		String expected = " Line Chart Observer of StockEvent:Shown here  plummet 400.0";
		assertEquals(expected, outContent.toString());
	}

	@Test
	public void testStockQuotewith3D() {
		StockQuoteObservable item = new StockQuoteObservable();
		Three_3_DObserver ThreeDObserver = new Three_3_DObserver();
		item.addObserver(ThreeDObserver);
		StockEvent a = new StockEvent("jump", 400);
		item.notifyObservers(a);
		String expected = " 3D Observer of StockEvent:Shown here  jump 400.0";
		assertEquals(expected, outContent.toString());
	}

	@Test
	public void testStockQuotewithChangeQuote() {
		StockQuoteObservable item = new StockQuoteObservable();
		Three_3_DObserver ThreeDObserver = new Three_3_DObserver();
		item.addObserver(ThreeDObserver);
		item.changeQuote("jump", 300.0);
		String expected = " 3D Observer of StockEvent:Shown here  jump 300.0";
		assertEquals(expected, outContent.toString());
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