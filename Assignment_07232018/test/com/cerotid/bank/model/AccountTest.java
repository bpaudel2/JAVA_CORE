package com.cerotid.bank.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {
	private Account account;
	private Transaction transaction;
	
	// This runs before each test.
	@Before
	public void setUp() throws Exception {
		System.out.println("Runnig Before");
		account = new Account();
		account.setAccountBalance(1000.0);
		transaction = new WireTransfer(null, null, 20.0, null, null, null, null, null);
	}

	@Test
	public void testSendMoney() {
		account.sendMoney(500, transaction);
		assertTrue(480.0==account.getAccountBalance());
	}

	@Test
	public void testDepositMoney() {
		account.depositMoney(1000.0);
		assertEquals(2000.0,account.getAccountBalance(),0.01);
		
	}

}
