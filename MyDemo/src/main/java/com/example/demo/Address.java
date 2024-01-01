package com.example.demo;

public class Address {

	int pinCode;

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	
	Address(int pinCode){
		this.pinCode=pinCode;
	}
}
