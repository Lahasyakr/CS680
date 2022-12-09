package edu.umb.cs680.hw17.observer;

public class TableObserver implements Observer {

    public void update(Observable observable, Object object) {
        StockEvent event = (StockEvent) object;
        System.out.print("Table Observer of StockEvent:Shown here  " + event.getTicker() + " " + event.getQuote());

    }
}