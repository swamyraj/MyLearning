package com.practice.java.design.pattern;

public class TemplateDesignPattern {
	public static void main(String[] args) {
		ComputerTemplate c = new PCComputer();
		c.buidlComputer();
		
		ComputerTemplate c1 = new ServerComputer();
		c1.buidlComputer();
	}

}

abstract class ComputerTemplate {

	public final void buidlComputer() {
		collectComponets();
		assembleComponent();
		installOs();
		startComputer();
		System.out.println("Computer is ON");
	}

	private void collectComponets() {
		System.out.println("computer with 4GB RAM ,1TB HDD");

	};

	private void startComputer() {
		System.out.println("system is booting");
	};

	public abstract void assembleComponent();

	public abstract void installOs();

}

class PCComputer extends ComputerTemplate {

	@Override
	public void assembleComponent() {
		System.out.println("Joining all units,4 HDMI ports");
	}

	@Override
	public void installOs() {
		System.out.println("Installing windows standalone..");
	}

}

class ServerComputer extends ComputerTemplate {

	@Override
	public void assembleComponent() {
		System.out.println("Joining all units,0 HDMI ports");
	}

	@Override
	public void installOs() {
		System.out.println("Installing windows server OS..");
	}


}
