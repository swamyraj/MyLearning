package com.practice.java.design.pattern;

public class ProxyDesignPattern {

	public static void main(String[] args) {
		Account account = new ATM();
		System.out.println(account.withdraw());
	}

}

interface Account {

	int withdraw();
}

class BankAccount implements Account {

	@Override
	public int withdraw() {
		return 1000;
	}

}

//based on some validation logic, you will allow to call the real method like based on roles..
class ATM implements Account {
	BankAccount ba;

	ATM() {
		ba = new BankAccount();
	}

	@Override
	public int withdraw() {
		return ba.withdraw();
	}

}
