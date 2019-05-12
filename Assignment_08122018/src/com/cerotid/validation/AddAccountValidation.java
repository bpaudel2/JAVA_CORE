package com.cerotid.validation;

import com.cerotid.bank.model.Bank;
import com.cerotid.bank.model.Customer;
import com.cerotid.bo.BankBOImpl;

public class AddAccountValidation extends Exception{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 8374409011330901864L;
	
	public AddAccountValidation(String message) {
		super(message);
		
	}
	
	public static boolean validateUserInput(Customer customer, String accountChose) throws AddAccountValidation {
		StringBuilder message = new StringBuilder("");	
		
		if (!accountChose.matches("[0-9]+")){
			message.append("Please provide Account Choice in number.\n");
		}
		if(customer==null) {
			message.append("Customer does not exist.\n");
		}
		if (message.length()==0) {
			return true;
		}
		else {
			throw new AddAccountValidation(message.toString());
		}
	}

}
