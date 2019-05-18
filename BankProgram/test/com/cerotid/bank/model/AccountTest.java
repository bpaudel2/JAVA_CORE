package com.cerotid.bank.model;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

// Kind of a bad design all the test cases runs three times but 
// I just wanted the sendMoney to run three times. Although all of them shows passed.
@RunWith(value = Parameterized.class)
public class AccountTest {
	private Account account;
	
	@Parameter(value=0)
	public Transaction transaction;
	@Parameter (value=1)
	public double expected;
	
	// This runs before each test.
	//@BeforeClass runs once for a class
	@Before
	public void setUp() throws Exception {
		System.out.println("Runnig Before");
		account = new Account();
		account.setAccountBalance(1000.0);
	}
	
	@Parameters()
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{new WireTransfer(null, null, 100.0, null, null, null, null, null),880.0},
			{new ElectronicCheck(null,null,500.0,10.0, null),490.0},
			{new MoneyGram(null,null,250.00,25.00,null,null),725.0}
		});
	}
	
	@Test
	public void testSendMoney() {
		account.sendMoney(transaction.amount, transaction);
		assertTrue(expected==account.getAccountBalance());
	}

	@Test
	public void testDepositMoney() {
		account.depositMoney(1000.0);
		assertEquals(2000.0,account.getAccountBalance(),0.01);
		
	}
	
	@Test
	public void testDeductAccountBalance() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = Account.class.getDeclaredMethod("deductAccountBalance",double.class);
		method.setAccessible(true);
		method.invoke(account, 250.00);
		assertTrue(750.00==account.getAccountBalance());
	}

}


