package com.practice.java.design.pattern;

public class DecoratorDesignPattern {

	public static void main(String[] args) {

		CasualDress c = new CasualDress(new BasicDress());
		// c.assemble();

		CasualDress cf = new CasualDress(new FancyDress(new BasicDress()));
		cf.assemble();
	}
}

interface Dress {

	void assemble();

}

class BasicDress implements Dress {

	@Override
	public void assemble() {
		System.out.println("basic dress feature");
	}

}

class DressDecorator implements Dress {
	Dress dress;

	public DressDecorator(Dress dress) {
		this.dress = dress;
	}

	@Override
	public void assemble() {
		this.dress.assemble();
	}

}

class CasualDress extends DressDecorator {

	public CasualDress(Dress dress) {
		super(dress);

	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.println("Adding casual dress feature");
	}

}

class FancyDress extends DressDecorator {

	public FancyDress(Dress dress) {
		super(dress);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.println("Adding fancy dress feature");
	}
}

class SportyDress extends DressDecorator {

	public SportyDress(Dress dress) {
		super(dress);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.println("Adding sport dress feature");
	}

}
