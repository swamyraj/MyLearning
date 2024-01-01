package com.practice.java.design.pattern;

public interface ComputerAbstractFactory {

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
