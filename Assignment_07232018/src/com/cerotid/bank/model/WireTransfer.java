package com.cerotid.bank.model;

public class WireTransfer extends Transaction {
	private String beneficiaryFirstName;
	private String beneficiaryLastName;
	private String intermediaryBankSWIFTCode;
	private String beneficiaryBankName;
	private String beneficiaryAccountNumber;
	public static final double FEE = 20.00;
	
	
	public WireTransfer(String senderAccountNumber, String receiverAccountNumber, double amount,
			String beneficiaryFirstName,String beneficiaryLastName,String intermediaryBankSWIFTCode,
			String beneficiaryBankName,String beneficiaryAccountNumber) {
		super(senderAccountNumber, receiverAccountNumber, amount, FEE);
		this.beneficiaryFirstName = beneficiaryFirstName;
		this.beneficiaryLastName = beneficiaryLastName;
		this.intermediaryBankSWIFTCode = intermediaryBankSWIFTCode;
		this.beneficiaryBankName = beneficiaryBankName;
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}

	
	


	@Override
	public String toString() {
		return "WireTransfer [beneficiaryFirstName=" + beneficiaryFirstName + ", beneficiaryLastName="
				+ beneficiaryLastName + ", intermediaryBankSWIFTCode=" + intermediaryBankSWIFTCode
				+ ", beneficiaryBankName=" + beneficiaryBankName + ", beneficiaryAccountNumber="
				+ beneficiaryAccountNumber + "]";
	}





	@Override
	public void createTransaction() {
		System.out.println("Transaction Competed using "+this.toString());
		
	}

	
	
	
}
