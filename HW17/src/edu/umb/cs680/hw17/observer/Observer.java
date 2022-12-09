package edu.umb.cs680.hw17.observer;


public interface Observer<StockEvent> {
	public void update(Observable<StockEvent> sender, StockEvent event);
}
