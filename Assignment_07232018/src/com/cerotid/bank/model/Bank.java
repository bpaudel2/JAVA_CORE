package com.cerotid.bank.model;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	
	private String bankName;
	private List<Customer> customers = new ArrayList<Customer>();
	
	
	public Bank(String bankName) {
		this.bankName = bankName;
	}
	
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}


	public void printBankName() {
		System.out.println(this.bankName);
	}
	
	@Override
	public String toString() {
		return "Bank [bankName=" + bankName + ", customers=" + customers + "]";
	}


	public void printBankDetails() {
		System.out.println(this.toString());		
	}
}
