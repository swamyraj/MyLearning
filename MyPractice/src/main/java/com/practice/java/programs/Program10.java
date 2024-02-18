package com.practice.java.programs;

/**
 * FInd the degree between angles in Clock
 *
 */
public class Program10 {

	public static void main(String[] args) {

		System.out.println(calculate(3, 0));
		System.out.println(calculate(12, 60));
		System.out.println(calculate(12, 59));
		System.out.println(calculate(6, 0));
	}

	/**
	 * 
	 * Minute hand moves 360 degrees in 60 mins(6 degrees in one minute = 360/60)
	 * Hour hand moves 360 degrees in 12 hrs (0.5 degree in one minute =
	 * 360/(12*60))
	 * 
	 * (h*60+m)*6  (h*60+m)*0.5
	 * 
	 * @param h
	 * @param m
	 * @return
	 */
	public static int calculate(int h, int m) {
		if (h < 0 || h > 12 || m < 0 || m > 60) {
			System.out.println("Wrong input");
			return -1000;
		}
		if (h == 12) {
			h = 0;
		}
		if (m == 60) {
			m = 0;
		}
		int hourAngle = (int) (h * 30 + m * 0.5);
		int minuteAngle = (int) m * 6;
		int angle = Math.abs(hourAngle-minuteAngle);
		return Math.min(360 - angle, angle);

	}
}
