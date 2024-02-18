package com.practice.java.sort;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class HashMapCustomSorting {
	public static void main(String[] args) throws Exception {

		String location = "Bangalore";
		// String status = "NEW"; // -1074940510
		String status = "OPEN"; // -1072585108
		final int prime = 31;
		int result = 1;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		System.out.println("Result : " + result);

		Courier c0 = new Courier("Bangalore", 1701396080000L, "NEW");
		Courier c1 = new Courier("Bangalore", 1705309680000L, "DELIVERED");
		Courier c2 = new Courier("Bangalore", 1706396080000L, "OPEN");
		Courier c3 = new Courier("Mangalore", 1705482480000L, "SHIPPPED");
		Courier c4 = new Courier("Delhi", 1705568880000L, "PENDING");
		Courier c5 = new Courier("Chennai", 1704309680000L, "IN PROGRESS");

		// -1070286810
		int keyHash = (c2 == null ? 0 : c2.hashCode());
		int valueHash = (c2.getStatus() == null ? 0 : c2.getStatus().hashCode());
		System.out.println("hash: " + (keyHash ^ valueHash));

		// -1075013598
		 keyHash = (c0 == null ? 0 : c0.hashCode());
		 valueHash = (c0.getStatus() == null ? 0 : c0.getStatus().hashCode());
		System.out.println("hash: " + (keyHash ^ valueHash));

		Map<Courier, String> map = new TreeMap<Courier, String>();

		map.put(c5, c5.getStatus());
		map.put(c3, c3.getStatus());
		map.put(c4, c4.getStatus());

		map.put(c2, c2.getStatus());
		map.put(c0, c0.getStatus());
		map.put(c1, c1.getStatus());

		// System.out.println(map);

		for (Entry<Courier, String> e : map.entrySet()) {
			System.out.println(e.getKey().getLocation() + " " + e.getKey().getStatus() + " " + e.getValue());
		}

	}
}

class Courier implements Comparable<Courier> {

	String location;
	long timeOfArrival;
	String status;

	public Courier(String location, long timeOfArrival, String status) {
		super();
		this.location = location;
		this.timeOfArrival = timeOfArrival;
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getTimeOfArrival() {
		return timeOfArrival;
	}

	public void setTimeOfArrival(long timeOfArrival) {
		this.timeOfArrival = timeOfArrival;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Courier [location=" + location + ", timeOfArrival=" + timeOfArrival + ", status=" + status + "]";
	}

	@Override
	public int compareTo(Courier o) {
		int c = this.getLocation().compareTo(o.getLocation());
		if (c == 0) {
			c = this.getStatus().compareTo(o.getStatus());
		}
		return c;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Courier))
			return false;
		Courier other = (Courier) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
}
