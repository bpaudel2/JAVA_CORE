package com.cerotid.bank.model;

public class MoneyGram extends Transaction{
	private DeliveryOption deliveryOption;
	private String destinationCountry;

	public MoneyGram(String senderAccountNumber, String receiverAccountNumber, double amount, double fee, 
			DeliveryOption deliveryOption, String destinationCountry ) {
		super(senderAccountNumber, receiverAccountNumber, amount, fee);
		this.deliveryOption = deliveryOption;
		this.destinationCountry = destinationCountry;
	}

	@Override
	public void createTransaction() {
		System.out.println("Transaction Competed using "+this.toString());
		
	}

	@Override
	public String toString() {
		return "MoneyGram [deliveryOption=" + deliveryOption + ", destinationCountry=" + destinationCountry + "]";
	}
	
	
	
}
