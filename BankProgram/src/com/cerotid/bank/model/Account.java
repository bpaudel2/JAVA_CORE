package com.cerotid.bank.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2185040279177564200L;

	
	private UUID accountNumber;
	private AccountType accountType;
	private LocalDate accountOpenDate;
	private LocalDate accountCloseDate;
	//Should be using BigDecimal to represent money in Java
	private double accountBalance;

	public Account() {
		this.accountOpenDate = LocalDate.now();
		this.accountCloseDate = null;
		this.accountNumber = UUID.randomUUID();
		this.accountBalance = 0.0;
	}
	
	public Account(AccountType accountType) {
		this.accountType = accountType;
		this.accountOpenDate = LocalDate.now();
		this.accountCloseDate = null;
		this.accountNumber = UUID.randomUUID();
		this.accountBalance = 0.0;
		System.out.println("The account generated with UUID: "+this.accountNumber);
	}


	public UUID getAccountNumber() {
		return accountNumber;
	}

	
	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	

	public LocalDate getAccountOpenDate() {
		return accountOpenDate;
	}


	public LocalDate getAccountCloseDate() {
		return accountCloseDate;
	}


	public void setAccountCloseDate(LocalDate accountCloseDate) {
		this.accountCloseDate = accountCloseDate;
	}


	public double getAccountBalance() {
		return accountBalance;
	}
	
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}


	@Override
	public String toString() {
		return "Account [accountType=" + accountType + ", accountOpenDate=" + accountOpenDate + ", accountCloseDate="
				+ accountCloseDate + ", accountNumber=" + accountNumber + ", amount=" + accountBalance + "]";
	}


	public void printAccountInfo() {
		System.out.println(this.toString());
	}
	
	public void sendMoney(double sendingAmount, Transaction transaction) {
		System.out.println("Sending "+sendingAmount+" using "+transaction);
		deductAccountBalance(sendingAmount + transaction.fee);		
	}
	
	public void depositMoney(double depositAmount) {
		this.accountBalance += depositAmount;
	}
	
	private void deductAccountBalance(double deductionAmount) {
		this.accountBalance -= deductionAmount;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
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
		Account other = (Account) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		return true;
	}
	
	
}
