package com.cerotid.bank.model;

public enum DeliveryOption {
	TenMinutes(15.0),
	TwentyFourHours(9.0);
	
	private double fee;
	
	DeliveryOption(double fee){
		this.fee = fee;
	}
	
	public double getFee() {
		return fee;
	}
}