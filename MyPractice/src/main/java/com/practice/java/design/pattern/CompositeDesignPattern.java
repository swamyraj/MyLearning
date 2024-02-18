package com.practice.java.design.pattern;

import java.util.ArrayList;
import java.util.List;

public class CompositeDesignPattern {

	public static void main(String[] args) {

		Component ram = new Leaf(2000, "ram");
		Component hdd = new Leaf(4000, "hdd");

		Component mouse = new Leaf(100, "mouse");
		Component keyboard = new Leaf(200, "keyboard");

		Composite motherBoard = new Composite("Mother board");
		Composite peripheral = new Composite("peripheral");

		Composite cabinet = new Composite("cabinet");

		motherBoard.addComponent(ram);
		motherBoard.addComponent(hdd);

		peripheral.addComponent(mouse);
		peripheral.addComponent(keyboard);

		cabinet.addComponent(peripheral);
		cabinet.addComponent(motherBoard);

		cabinet.showPrice();
	}

}

interface Component {
	public void showPrice();
}

class Leaf implements Component {

	int price;
	String name;

	public Leaf(int price, String name) {
		super();
		this.price = price;
		this.name = name;
	}

	@Override
	public void showPrice() {
		System.out.println(name + " : " + price);
	}

}

class Composite implements Component {

	int price;
	String name;
	private List<Component> list = new ArrayList<Component>();

	public Composite(String name) {
		super();
		this.name = name;
	}

	public void addComponent(Component com) {
		list.add(com);
	}

	@Override
	public void showPrice() {
		System.out.println(name);
		for (Component component : list) {
			component.showPrice();
		}
	}

}
