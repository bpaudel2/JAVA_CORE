package com.cerotid.bank.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bank implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2297531359117781916L;
	private static Bank instance = null;
	private String bankName;
	private List<Customer> customers = new ArrayList<Customer>();

	// private to defeat instantiation
	private Bank(String bankName) {
		this.bankName = bankName;
		this.customers = new ArrayList<Customer>();
	}

	public static Bank getInstance() {
		if (instance == null) {
			instance = new Bank("The Bank of Cerotid");
		}
		return instance;
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

	public Customer getCustomer(String ssn) {
		for (Customer customer : customers) {
			if (ssn.equals(customer.getSsn())) {
				return customer;
			}
		}
		return null;

	}

	public Account getAccount(String uuid) {
		for (Customer customer : customers) {
			for (Account account : customer.getAccounts()) {
				if (account.getAccountNumber().toString().equalsIgnoreCase(uuid)) {
					return account;
				}

			}
		}
		return null;
	}

	public List<Customer> getCustomerByState(String stateCode) {
		List<Customer> customersByState = new ArrayList<Customer>();
		for (Customer customer : customers) {
			if (stateCode.equalsIgnoreCase(customer.getAddress().getState())) {
				customersByState.add(customer);
			}
		}
		return customersByState;
	}
}
