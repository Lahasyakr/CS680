package edu.umb.cs680.hw17.observer;

public class Three_3_DObserver implements Observer {
    
    public void update(Observable observable, Object object) {
        StockEvent event = (StockEvent) object;
        System.out.print(" 3D Observer of StockEvent:Shown here  " + event.getTicker() + " " + event.getQuote());

    }
}
