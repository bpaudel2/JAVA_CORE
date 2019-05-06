package com.cerotid.bank.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5743014974417314673L;
	private String firstName;
	private String lastName;
	private List<Account> accounts = new ArrayList<Account>();
	private Address address;
	private String ssn;
	private String dob;
	
	public Customer() {
		
	}
	
	
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		if (this.accounts == null) {
			this.accounts = new ArrayList<>();
		}
	}
	
	public Customer(String fname, String lastName, String ssn, Address address) {
		this.firstName = fname;
		this.lastName = lastName;
		this.ssn = ssn;	
		this.address = address;
		if(this.accounts == null) {
			this.accounts = new ArrayList<>();
		}
	}
	
	public void addAccount(Account account) {
		this.accounts.add(account);
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
				+ address + ", ssn=" + ssn + ", dob=" + dob + "]";
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (ssn == null) {
			if (other.ssn != null)
				return false;
		} else if (!ssn.equals(other.ssn))
			return false;
		return true;
	}
	
	
	
}
