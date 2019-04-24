package com.cerotid.bank.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String firstName;
	private String lastName;
	private List<Account> accounts = new ArrayList<Account>();
	private String address;
	
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
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
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", accounts=" + accounts + ", address="
				+ address + "]";
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
