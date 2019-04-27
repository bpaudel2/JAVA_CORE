package com.cerotid.bank.model;

public class MoneyGram extends Transaction{
	private DeliveryOption deliveryOption;
	private String destinationCountry;

	public MoneyGram(int sendingAccountNumber, double amount, double fee, String receiverFirstName, String receiverLastName, 
			DeliveryOption deliveryOption, String desinationCountry ) {
		super(sendingAccountNumber, amount, fee, receiverFirstName, receiverLastName);
		this.deliveryOption = deliveryOption;
		this.destinationCountry = destinationCountry;
	}

	@Override
	public void createTransaction() {
		System.out.println("Transaction Competed using "+this.toString());
		
	}
	
	@Override
	public String toString() {
		return "MoneyGram [sendingAccountNumber=" +sendingAccountNumber + ", amount=" + amount + ", fee=" + fee + ", "
				+ "receiverFirstName=" + receiverFirstName + ", receiverLastName=" + receiverLastName + ", "
				+ "deliveryOption=" + deliveryOption + ", destinationCountry="+destinationCountry+ "]";
	}
	
}
