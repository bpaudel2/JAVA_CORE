package com.cerotid.bank.model;

public class ElectronicCheck extends Transaction {
	private CheckType checkType;
	
	
	public ElectronicCheck(int sendingAccountNumber, double amount, double fee, String receiverFirstName, String receiverLastName, CheckType checkType) {
		super(sendingAccountNumber, amount, fee, receiverFirstName, receiverLastName);
		this.checkType = checkType;
	}

	@Override
	public void createTransaction() {
		System.out.println("Transaction Competed using "+this.toString());
		
	}
	
	@Override
	public String toString() {
		return "ElectronicCheck [sendingAccountNumber=" +sendingAccountNumber + ", amount=" + amount + ", fee=" + fee + ", "
				+ "receiverFirstName=" + receiverFirstName + ", receiverLastName=" + receiverLastName + ", "
				+ "checkType=" + checkType+  "]";
	}

}
