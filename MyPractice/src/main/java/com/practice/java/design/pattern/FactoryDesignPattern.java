package com.practice.java.design.pattern;

public class FactoryDesignPattern {

	public static void main(String[] args) {
		OperatingSystem o=  OperatingSystemFactory.getInstance("AD");
		System.out.println(o.getOSName());
	}
}

interface OperatingSystem {

	public abstract String getOSName();
}

class Andriod implements OperatingSystem {

	@Override
	public String getOSName() {
		return "Andriod";
	}

}

class IOS implements OperatingSystem {

	@Override
	public String getOSName() {
		return "IOS";
	}

}

class OperatingSystemFactory {

	public static OperatingSystem getInstance(String type) {
		switch (type) {
		case "AD":
			return new Andriod();

		case "IO":
			return new IOS();

		case "":
			System.out.println("Invalid inout type");
		}
		return null;
	}
}