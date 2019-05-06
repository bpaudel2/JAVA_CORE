package com.cerotid.bank.model;

public class Transaction {
	protected double amount;
	protected double fee;
	protected String senderAccountNumber;
	protected String receiverAccountNumer;
	
	public Transaction(String senderAccountNumber, String receiverAccountNumber, double amount, double fee) {
		this.senderAccountNumber = senderAccountNumber;
		this.receiverAccountNumer = receiverAccountNumber;
		this.amount = amount;
		this.fee = fee;
	}
	
	
	@Override
	public String toString() {
		return "Transaction [amount=" + amount + ", fee=" + fee + ", senderAccountNumber=" + senderAccountNumber
				+ ", receiverAccountNumer=" + receiverAccountNumer + "]";
	}


	public void createTransaction() {
		System.out.println("Transaction Completed using: "+this.toString());
	}
	
	
}
