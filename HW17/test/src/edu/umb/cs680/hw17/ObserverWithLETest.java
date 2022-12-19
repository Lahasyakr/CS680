
package edu.umb.cs680.hw17.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ObserverWithLETest {

    // Captures the console log
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams1() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testStockQuotewithTable() {
        StockQuoteObservable item = new StockQuoteObservable();
        Observer<StockEvent> tableObserver = (Observable<StockEvent> sender, StockEvent event) -> {
            System.out.print("Table Observer of StockEvent:Shown here  " + event.getTicker() + " " + event.getQuote());
        };
        item.addObserver(tableObserver);
        StockEvent a = new StockEvent("crash", 100);
        item.notifyObservers(a);
        String expected = "Table Observer of StockEvent:Shown here  crash 100.0";
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testStockQuotewithLineChart() {
        StockQuoteObservable item = new StockQuoteObservable();
        Observer<StockEvent> lineChartObserver = (Observable<StockEvent> sender, StockEvent event) -> {
            System.out.print(
                    " Line Chart Observer of StockEvent:Shown here  " + event.getTicker() + " " + event.getQuote());
        };
        item.addObserver(lineChartObserver);
        StockEvent a = new StockEvent("plummet", 400);
        item.notifyObservers(a);
        String expected = " Line Chart Observer of StockEvent:Shown here  plummet 400.0";
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testStockQuotewith3D() {
        StockQuoteObservable item = new StockQuoteObservable();
        Observer<StockEvent> ThreeDObserver = (Observable<StockEvent> sender, StockEvent event) -> {
            System.out.print(" 3D Observer of StockEvent:Shown here  " + event.getTicker() + " " + event.getQuote());
        };
        item.addObserver(ThreeDObserver);
        StockEvent a = new StockEvent("jump", 400);
        item.notifyObservers(a);
        String expected = " 3D Observer of StockEvent:Shown here  jump 400.0";
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testStockQuotewithChangeQuote() {
        StockQuoteObservable item = new StockQuoteObservable();
        Observer<StockEvent> ThreeDObserver = (Observable<StockEvent> sender, StockEvent event) -> {
            System.out.print(" 3D Observer of StockEvent:Shown here  " + event.getTicker() + " " + event.getQuote());
        };
        item.addObserver(ThreeDObserver);
        item.changeQuote("itm", 300.0);
        String expected = " 3D Observer of StockEvent:Shown here  itm 300.0";
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testStockQuote() {
        StockQuoteObservable item = new StockQuoteObservable();
        Observer<StockEvent> lineChartObserver = (Observable<StockEvent> sender, StockEvent event) -> {
            System.out.print(
                    " Line Chart Observer of StockEvent:Shown here  " + event.getTicker() + " " + event.getQuote());
        };
        Observer<StockEvent> tableObserver = (Observable<StockEvent> sender, StockEvent event) -> {
            System.out.print("Table Observer of StockEvent:Shown here  " + event.getTicker() + " " + event.getQuote());
        };
        Observer<StockEvent> ThreeDObserver = (Observable<StockEvent> sender, StockEvent event) -> {
            System.out.print(" 3D Observer of StockEvent:Shown here  " + event.getTicker() + " " + event.getQuote());
        };

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

    @Test
    public void testStockQuoteRemoveObserver() {
        StockQuoteObservable item = new StockQuoteObservable();
        Observer<StockEvent> lineChartObserver = (Observable<StockEvent> sender, StockEvent event) -> {
            System.out.print(
                    " Line Chart Observer of StockEvent:Shown here  " + event.getTicker() + " " + event.getQuote());
        };
        Observer<StockEvent> tableObserver = (Observable<StockEvent> sender, StockEvent event) -> {
            System.out.print("Table Observer of StockEvent:Shown here  " + event.getTicker() + " " + event.getQuote());
        };
        Observer<StockEvent> ThreeDObserver = (Observable<StockEvent> sender, StockEvent event) -> {
            System.out.print(" 3D Observer of StockEvent:Shown here  " + event.getTicker() + " " + event.getQuote());
        };
        item.addObserver(lineChartObserver);
        item.addObserver(tableObserver);
        item.addObserver(ThreeDObserver);
        StockEvent a = new StockEvent("item", 100);
        item.notifyObservers(a);
        String expected = " Line Chart Observer of StockEvent:Shown here  item 100.0Table Observer of StockEvent:Shown here  item 100.0 3D Observer of StockEvent:Shown here  item 100.0";
        assertEquals(expected, outContent.toString());
        assertEquals(3, item.countObservers());
        item.removeObserver(lineChartObserver);
        assertEquals(2, item.countObservers());
        item.removeObserver(ThreeDObserver);
        assertEquals(1, item.countObservers());
    }

}