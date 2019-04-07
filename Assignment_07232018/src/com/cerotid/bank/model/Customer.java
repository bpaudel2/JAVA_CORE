package com.cerotid.bank.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Account> accounts = new ArrayList<Account>();
	private String address;
	
	public Customer(String name) {
		this.name = name;
	}
	public void printCustomerAccounts() {
		System.out.println(this.accounts);
	}
	
	public void printCustomerDetails() {
		String details = this.toString();
		System.out.println(details);
	}
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", accounts=" + accounts + ", address=" + address + "]";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
