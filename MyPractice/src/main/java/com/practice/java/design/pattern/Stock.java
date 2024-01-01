package com.practice.java.design.pattern;

public class Stock {

	private String stockName = "Google Share";
	private int stockQuantity = 10;

	public Stock(String stockName, int stockQuantity) {
		this.stockName = stockName;
		this.stockQuantity = stockQuantity;
	}

	public void buyStock() {
		System.out.println("Stock name: " + stockName + ", stock quantity: " + stockQuantity + "Bought");
	}

	public void sellStock() {
		System.out.println("Stock name: " + stockName + ", stock quantity: " + stockQuantity + "Sold");
	}
	
	
}
