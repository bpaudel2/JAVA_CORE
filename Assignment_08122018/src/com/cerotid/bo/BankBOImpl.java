package com.cerotid.bo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.cerotid.bank.model.Account;
import com.cerotid.bank.model.Bank;
import com.cerotid.bank.model.Customer;
import com.cerotid.bank.model.Transaction;

public class BankBOImpl implements BankBO {

	private Bank bank = Bank.getInstance();

	
	

	@Override
	public void addCustomer(Customer customer) {
		if (!bank.getCustomers().contains(customer)) {
			bank.getCustomers().add(customer);
		}
	}

	@Override
	public boolean customerExist(String ssn) {
		return bank.getCustomers().contains(bank.getCustomer(ssn));
	}

	@Override
	public void sendMoney(Account sendingAccount, double sendingAmount, Account receivingAccount,
			Transaction transaction) {
		sendingAccount.sendMoney(sendingAmount, transaction);
		receivingAccount.depositMoney(sendingAmount);

	}

	@Override
	public void depositMoneyInCustomerAccount(Account depositAccount, double depositAmount) {
		depositAccount.depositMoney(depositAmount);
	}

	@Override
	public void editCustomerInfo(Customer OldCustomer, Customer newCustomer) {
		OldCustomer.setFirstName(newCustomer.getFirstName());
		OldCustomer.setLastName(newCustomer.getLastName());
		OldCustomer.setAddress(newCustomer.getAddress());
	}

	@Override
	public Customer getCustomerInfo(String ssn) {
		return bank.getCustomer(ssn);
	}

	@Override
	public void printBankStatus() {
		System.out.println(bank);
		System.out.println();

	}

	@Override
	public void serializeBank() {
		String filename = "./resources/Bank.ser";
		try {
			FileOutputStream file = new FileOutputStream(new File(filename));
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(bank);
			out.close();
			file.close();
			System.out.println("The Bank has been saved in Bank.ser file.");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void deserializeBank() {
		String filename = "./resources/Bank.ser";
		try {
			FileInputStream file = new FileInputStream(new File(filename));
			if (file.getChannel().size() == 0) {
				System.out.println("Nothing to deserialize.");
			} else {
				ObjectInputStream in = new ObjectInputStream(file);
				bank = (Bank) in.readObject();
				in.close();
				file.close();
				System.out.println("The Bank has been retrieved from Bank.ser file.");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException" + " is caught");
		}
	}

	@Override
	public void openAccount(Customer customer, Account account) {
		if (bank.getCustomers().contains(customer)) {
			int customerIndex = bank.getCustomers().indexOf(customer);
			bank.getCustomers().get(customerIndex).addAccount(account);
		}
	}

	@Override
	public List<Customer> getCustomerByState(String stateCode) {
		return bank.getCustomerByState(stateCode);
	}

	@Override
	public Account getAccountInfo(String accountNumber) {
		return bank.getAccount(accountNumber);
	}
	
}