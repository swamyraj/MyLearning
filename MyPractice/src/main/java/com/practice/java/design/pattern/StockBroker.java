package com.practice.java.design.pattern;

import java.util.ArrayList;
import java.util.List;

public class StockBroker {

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
