package com.reactive.venkat;

public class StockInfo {

	private String value;

	public StockInfo() {
	}

	public StockInfo(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static StockInfo fetch(String ticker) {
		if(Math.random() > 0.9)
			throw new RuntimeException("BOOM!");
		
		return new StockInfo(ticker);
	}

	@Override
	public String toString() {
		return "value = " + value;
	}
}
