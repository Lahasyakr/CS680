package edu.umb.cs680.hw17.observer;

public class StockEvent {
	private String ticker;
	private double quote;
	
	public StockEvent(String T, double Q) {
		this.ticker = T;
		this.quote = Q;
	}
	
	public String getTicker() {
		return ticker;
	}
	
	public double getQuote() {
		return quote;
	}
}
