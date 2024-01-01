package com.practice.java.design.pattern;

public class SellOrder implements Order{

	private Stock stock ;
	
	SellOrder(Stock stock){
		this.stock = stock;
	}
	
	
	@Override
	public void execute() {
		stock.sellStock();
	}

}
