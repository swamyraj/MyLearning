package com.practice.java.design.pattern;

public interface AbstractFactoryDesignPattern {

	public static void main(String[] args) {
		Computer c1 = ComputerFactory.getComputer(new PCFactory("2GB"));
		Computer c2 = ComputerFactory.getComputer(new ServerFactory("20GB"));
		
	}

}

interface ComputerAbstractFactory {

	public Computer createComputer();

}

class PCFactory implements ComputerAbstractFactory {

	private String ram;

	public PCFactory(String ram) {
		this.ram = ram;
	}

	@Override
	public Computer createComputer() {

		return new PC(ram);
	}

}

class ServerFactory implements ComputerAbstractFactory {

	private String ram;

	public ServerFactory(String ram) {
		this.ram = ram;
	}

	@Override
	public Computer createComputer() {

		return new Server(ram);
	}

}

class ComputerFactory {

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

}
