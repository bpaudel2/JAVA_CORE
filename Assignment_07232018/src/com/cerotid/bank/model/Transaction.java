package com.cerotid.bank.model;

public class Transaction {
	protected double amount;
	protected double fee;
	protected int sendingAccountNumber;
	protected String receiverFirstName;
	protected String receiverLastName;
	
	public Transaction(int sendingAccountNumber, double amount, double fee, String receiverFirstName, String receiverLastName) {
		this.sendingAccountNumber = sendingAccountNumber;
		this.amount = amount;
		this.fee = fee;
		this.receiverFirstName = receiverFirstName;
		this.receiverLastName = receiverLastName;
	}
	
	

	@Override
	public String toString() {
		return "Transaction [amount=" + amount + ", fee=" + fee + ", sendingAccountNumber=" + sendingAccountNumber
				+ ", receiverFirstName=" + receiverFirstName + ", receiverLastName=" + receiverLastName + "]";
	}



	public void createTransaction() {
		System.out.println("Transaction Completed using: "+this.toString());
	}
	
	
}
