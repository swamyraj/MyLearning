package com.practice.java.design.pattern;

public class AdapterDesignPattern {

	public static void main(String[] args) {

		ChargeShop s = new ChargeShop();
		s.setCellPhoneCharger(new CellPhoneChargerAdapter());
		s.charge();
	}
}

interface CellPhone {

	abstract void charge();
}

class ChargeShop {

	CellPhoneChargerAdapter cellPhoneCharger;

	public CellPhoneChargerAdapter getCellPhoneCharger() {
		return cellPhoneCharger;
	}

	public void setCellPhoneCharger(CellPhoneChargerAdapter charger) {
		this.cellPhoneCharger = charger;
	}

	public void charge() {
		cellPhoneCharger.charge();

	}
}

class CellPhoneChargerAdapter implements CellPhone {

	NokiaCharger nc = new NokiaCharger();

	@Override
	public void charge() {
		nc.chargeMyPhone();
	}
}

class NokiaCharger {

	public void chargeMyPhone() {
		System.out.println("I am a nokia charger");
	}

}
