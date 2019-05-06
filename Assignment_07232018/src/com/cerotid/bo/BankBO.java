package com.cerotid.bo;

import java.util.List;

import com.cerotid.bank.model.Account;
import com.cerotid.bank.model.Customer;
import com.cerotid.bank.model.Transaction;

public interface BankBO {
	
	public void addCustomer(Customer customer);
	public void openAccount(Customer customer, Account account);
	public void sendMoney(Account sendingAccount, double sendingAmount, Account receivingAccount,Transaction transaction);
	public void depositMoneyInCustomerAccount(Account account,double depositAmount);
	public void editCustomerInfo(Customer oldCustomer, Customer newCustomer);
	public Customer getCustomerInfo (String ssn);
	public Account getAccountInfo (String accountNumber);
	public void printBankStatus();
	public void serializeBank();
	public void deserializeBank();
	public List <Customer> getCustomerByState(String StateCode);
	
}
