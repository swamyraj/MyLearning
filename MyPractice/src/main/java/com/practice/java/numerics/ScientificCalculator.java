package com.practice.java.numerics;

//When we declare an interface or a class with strictfp, all of its member methods and other nested types inherit its behavior.

//However, please note that we’re not allowed to use strictfp keyword on variables, constructors or abstract methods.

//A popular real-world use-case for it is a system performing highly-sensitive medicinal calculations.

//Since the ScientificCalculator class makes use of this keyword, the above test case will pass on all hardware platforms. Please note that if we don’t use it, JVM is free to use any extra precision available on the target platform hardware.
public strictfp class ScientificCalculator {

	public static void main(String[] args) {

		ScientificCalculator calculator = new ScientificCalculator();
		double result = calculator.sum(23e10, 98e17);
		// assertThat(result, is(9.800000230000001E18));

		result = calculator.diff(Double.MAX_VALUE, 1.56);
		// assertThat(result, is(1.7976931348623157E308));

	}

	public double sum(double value1, double value2) {
		return value1 + value2;
	}

	public double diff(double value1, double value2) {
		return value1 - value2;
	}

	strictfp void calculateMarksPercentage() {

	}

}

strictfp interface Circle {
	double computeArea(double radius);
}
