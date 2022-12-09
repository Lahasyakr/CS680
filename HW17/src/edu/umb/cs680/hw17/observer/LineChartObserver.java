package edu.umb.cs680.hw17.observer;

public class LineChartObserver implements Observer {
    public void update(Observable observable, Object object) {
        StockEvent event = (StockEvent) object;
        System.out.print(" Line Chart Observer of StockEvent:Shown here  " + event.getTicker() + " " + event.getQuote());
    }
}
