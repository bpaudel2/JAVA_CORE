package com.cerotid.bank.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BankTest {

	private Bank bank;
	private String ssn1;
	private String ssn2;
	private String accountNumber1;
	private String accountNumber2;
	private String accountNumber3;
	@Before
	public void setUp() throws Exception {
		bank = Bank.getInstance();
		ssn1 = "123456789";
		ssn2 = "987654321";
		bank.getCustomers().add(new Customer("Bikram","Paudel",ssn1,
				new Address("1920 E 2ND ST","Edmond","OK")));
		bank.getCustomers().add(new Customer("CEROTID","CEROTID",ssn2,
				new Address("1920 E 2ND ST","Edmond","TX")));
		Account account1 = new Account(AccountType.Checking);
		accountNumber1 = account1.getAccountNumber().toString();
		Account account2 = new Account(AccountType.Saving);
		accountNumber2 = account2.getAccountNumber().toString();
		Account account3 = new Account(AccountType.Saving);
		accountNumber3 = account3.getAccountNumber().toString();
		bank.getCustomers().get(0).addAccount(account1);
		bank.getCustomers().get(0).addAccount(account2);
		bank.getCustomers().get(1).addAccount(account3);		
	}

	@Test
	public void testGetInstance() {
		Bank existingBank = Bank.getInstance();
		assertTrue(existingBank.equals(bank));
	}

	@Test
	public void testGetCustomer() {
		Customer returnedCustomer = bank.getCustomer(ssn1);
		assertTrue(bank.getCustomers().get(0).equals(returnedCustomer));
	}

	@Test
	public void testGetAccount() {
		Account returnedAccount = bank.getAccount(accountNumber3);
		assertTrue(bank.getCustomers().get(1).getAccounts().get(0).equals(returnedAccount));
	}

	@Test
	public void testGetCustomerByState() {
		List<Customer> texasCustomerList = bank.getCustomerByState("TX");
		assertTrue(texasCustomerList.contains(bank.getCustomers().get(1)));
	}

}
