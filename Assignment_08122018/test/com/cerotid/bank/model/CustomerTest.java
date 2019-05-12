package com.cerotid.bank.model;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class CustomerTest {
	//Parameterized test is best for this class with only one method to test.

	private Customer customer;
	
	@Parameter(value=0)
	public Account account;
	@Parameter (value=1)
	public int size;
	
	@Parameters()
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{new Account(AccountType.Checking),1},
			{new Account(AccountType.Saving),1},
			{new Account(AccountType.Business_Checking),1}
		});
	}
	
	@Before
	public void setUp() throws Exception {
		customer = new Customer();
	}

	@Test
	public void testAddAccount() {
		customer.addAccount(account);
		assertEquals(customer.getAccounts().size(),size);
		assertTrue(customer.getAccounts().contains(account));
	}

	

}
