package com.cerotid.bank.model;

public class WireTransfer extends Transaction {
	private String beneficiaryFirstName;
	private String beneficiaryLastName;
	private String intermediaryBankSWIFTCode;
	private String beneficiaryBankName;
	private String beneficiaryAccountNumber;
	
	
	public WireTransfer(int sendingAccountNumber, double amount, double fee, String receiverFirstName, String receiverLastName,
			String beneficiaryFirstName,String beneficiaryLastName,String intermediaryBankSWIFTCode,
			String beneficiaryBankName,String beneficiaryAccountNumber) {
		super(sendingAccountNumber, amount, fee, receiverFirstName, receiverLastName);
		this.beneficiaryFirstName = beneficiaryFirstName;
		this.beneficiaryLastName = beneficiaryLastName;
		this.intermediaryBankSWIFTCode = intermediaryBankSWIFTCode;
		this.beneficiaryBankName = beneficiaryBankName;
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}

	@Override
	public void createTransaction() {
		System.out.println("Transaction Competed using "+this.toString());
		
	}

	@Override
	public String toString() {
		return "WireTransfer [sendingAccountNumber=" +sendingAccountNumber + ", amount=" + amount + ", fee=" + fee + ", "
				+ "receiverFirstName=" + receiverFirstName + ", receiverLastName=" + receiverLastName + ", "
				+ "beneficiaryFirstName=" + beneficiaryFirstName + ", beneficiaryLastName="
				+ beneficiaryLastName + ", intermediaryBankSWIFTCode=" + intermediaryBankSWIFTCode
				+ ", beneficiaryBankName=" + beneficiaryBankName + ", beneficiaryAccountNumber="
				+ beneficiaryAccountNumber + "]";
	}

	
	
	
}
