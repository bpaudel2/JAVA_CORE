package com.cerotid.bank.main;

import java.util.ArrayList;
import java.util.List;

import com.cerotid.bank.model.*;

public class BankTester {

	public static void main(String[] args) {
		
		Account checkingAccount = new Account("Checking");
		Account savingAccount = new Account("Saving");
		
		checkingAccount.printAccountInfo();
		savingAccount.printAccountInfo();
		
		
		Customer bikram = new Customer("Bikram");
		Customer paudel = new Customer("Paudel");
		bikram.setAddress("Oklahoma");
		paudel.setAddress("Texas");
		List<Account> bikramAccount = new ArrayList<Account>();
		bikramAccount.add(checkingAccount);
		bikramAccount.add(savingAccount);
		bikram.setAccounts(bikramAccount);
		List<Account> paudelAccount = new ArrayList<Account>();
		paudelAccount.add(savingAccount);
		paudel.setAccounts(paudelAccount);
		
		bikram.printCustomerAccounts();
		bikram.printCustomerDetails();
		paudel.printCustomerAccounts();
		paudel.printCustomerDetails();
		
		
		
		Bank bankOfAmerica = new Bank("Bank Of America");
		Bank chase = new Bank("Chase");
		List<Customer> bankOfAmericaCustomers = new ArrayList<Customer>();
		List<Customer> chaseCustomers = new ArrayList<Customer>();
		bankOfAmericaCustomers.add(bikram);
		bankOfAmericaCustomers.add(paudel);
		chaseCustomers.add(paudel);
		bankOfAmerica.setCustomers(bankOfAmericaCustomers);
		chase.setCustomers(chaseCustomers);
		
		chase.printBankName();
		bankOfAmerica.printBankName();
		chase.printBankDetails();
		bankOfAmerica.printBankDetails();
		
		
		
		

	}

}
