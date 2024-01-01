package com.practice.java.design.pattern;

public class ComputerFactory {

	public static Computer getComputer(ComputerAbstractFactory factory) {
		return factory.createComputer();

	}
}

abstract class Computer {

	public abstract String getRAM();

}

class PC extends Computer {

	private String ram;

	PC(String ram) {
		this.ram = ram;
	}

	@Override
	public String getRAM() {
		return this.ram;
	}
}

class Server extends Computer {

	private String ram;

	Server(String ram) {
		this.ram = ram;
	}

	@Override
	public String getRAM() {
		return this.ram;
	}

	
	
	public static void main(String[] args) {
		Computer c1 =  ComputerFactory.getComputer(new PCFactory("2GB"));
		Computer c2 =  ComputerFactory.getComputer(new ServerFactory("20GB"));
	}
}
