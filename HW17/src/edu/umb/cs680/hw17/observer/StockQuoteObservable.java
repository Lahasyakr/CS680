package edu.umb.cs680.hw17.observer;

import java.util.HashMap;
import java.util.Map;


public class StockQuoteObservable  extends Observable <StockEvent>{
	  private Map<String, Float> mappings = new HashMap<String, Float>();

	void changeQuote(String T, float Q) {
		mappings.put(T, Q);
		//setChanged();
		notifyObservers(new StockEvent(T, Q));
	}
}