package com.cerotid.bank.main;

import java.util.ArrayList;
import java.util.List;

import com.cerotid.bank.model.*;

public class BankTester {

	public static void main(String[] args) {
		
		Account checkingAccount = new Account(AccountType.Checking);
		Account savingAccount = new Account(AccountType.Saving);
		
		
		checkingAccount.printAccountInfo();
		savingAccount.printAccountInfo();
		
		
		Customer bikram = new Customer("Bikram", "Paudel");
		Customer parker = new Customer("Parker","Kern");
		bikram.setAddress("Oklahoma");
		parker.setAddress("Texas");
		List<Account> bikramAccount = new ArrayList<Account>();
		bikramAccount.add(checkingAccount);
		bikramAccount.add(savingAccount);
		bikram.setAccounts(bikramAccount);
		List<Account> parkerAccount = new ArrayList<Account>();
		parkerAccount.add(savingAccount);
		parker.setAccounts(parkerAccount);
		
		bikram.printCustomerAccounts();
		bikram.printCustomerDetails();
		parker.printCustomerAccounts();
		parker.printCustomerDetails();
		
		
		
		
		Bank bankOfAmerica = new Bank("Bank Of America");
		Bank chase = new Bank("Chase");
		List<Customer> bankOfAmericaCustomers = new ArrayList<Customer>();
		List<Customer> chaseCustomers = new ArrayList<Customer>();
		bankOfAmericaCustomers.add(bikram);
		bankOfAmericaCustomers.add(parker);
		chaseCustomers.add(parker);
		bankOfAmerica.setCustomers(bankOfAmericaCustomers);
		chase.setCustomers(chaseCustomers);
		
		chase.printBankName();
		bankOfAmerica.printBankName();
		chase.printBankDetails();
		bankOfAmerica.printBankDetails();
		
		
		
		System.out.println("-----Reading Writing Customer File-------------");
		ReaderWriter.readWriteCustomerFile();
		
		System.out.println("Bikram sending money from his Checking account");
		Account bikramsCheckingAccount = bikram.getAccounts().get(0);
		bikramsCheckingAccount.sendMoney();

	}

}
