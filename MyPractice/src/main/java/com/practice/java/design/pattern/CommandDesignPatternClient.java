package com.practice.java.design.pattern;

public class CommandDesignPatternClient {

	public static void main(String[] args) {
		
		SellOrder S1 = new  SellOrder(new Stock("google share",10));
		SellOrder S2 = new  SellOrder(new Stock("merck share",20));
		BuyOrder b1 = new BuyOrder(new Stock("visa share", 100));
		BuyOrder b2 = new BuyOrder(new Stock("marlab share", 200));
		
		StockBroker b = new StockBroker();
		b.placeOrder(S1);
		b.placeOrder(S2);
		b.placeOrder(b1);		
		b.placeOrder(b2);
		
		b.executeOrder();
		
	}
}
