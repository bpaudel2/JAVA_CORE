package com.cerotid.bank.model;

public class Account {
	private String accountType;
	

	public Account(String accountType) {
		this.accountType = accountType;
	}
	
	
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
	@Override
	public String toString() {
		return "Account [accountType=" + accountType + "]";
	}


	public void printAccountInfo() {
		System.out.println(this.toString());
	}
}
