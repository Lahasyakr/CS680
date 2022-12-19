package edu.umb.cs680.hw17.observer;

import java.util.HashMap;
import java.util.Map;


public class StockQuoteObservable  extends Observable <StockEvent>{
	  private Map<String, Double> mappings = new HashMap<String, Double>();

	void changeQuote(String T, double Q) {
		mappings.put(T, Q);
		//setChanged();
		notifyObservers(new StockEvent(T, Q));
	}
}