package com.cerotid.bank.model;

public enum CheckType {
	PaperCheck(10.0), 
	ECheck (5.0);
	
	private double fee;
	
	CheckType(double fee){
		this.fee = fee;
	}
	
	public double getFee() {
		return fee;
	}
}
