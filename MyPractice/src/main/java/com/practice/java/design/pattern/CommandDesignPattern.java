package com.practice.java.design.pattern;

import java.util.ArrayList;
import java.util.List;

public class CommandDesignPattern {

	public static void main(String[] args) {

		SellOrder S1 = new SellOrder(new Stock("google share", 10));
		SellOrder S2 = new SellOrder(new Stock("merck share", 20));
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

interface Order {

	public abstract void execute();
}

class SellOrder implements Order {

	private Stock stock;

	SellOrder(Stock stock) {
		this.stock = stock;
	}

	@Override
	public void execute() {
		stock.sellStock();
	}

}

class BuyOrder implements Order {

	private Stock stock;

	BuyOrder(Stock stock) {
		this.stock = stock;
	}

	@Override
	public void execute() {
		stock.buyStock();

	}

}

//request
class Stock {

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

//commander
class StockBroker {

	List<Order> orderList = new ArrayList<Order>();

	public void placeOrder(Order order) {
		orderList.add(order);
	}

	public void executeOrder() {
		for (Order order : orderList) {
			order.execute();
		}
		orderList.clear();
	}

}