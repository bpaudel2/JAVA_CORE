package com.cerotid.validation;

import com.cerotid.bank.model.Customer;

public class AddAccountValidation extends Exception {
	/**
	 * 
	 */
	

	private static final long serialVersionUID = 8374409011330901864L;

	public AddAccountValidation(String message) {
		super(message);

	}

	public static void validateUserInput(Customer customer, String accountTypeInput) throws AddAccountValidation {
		StringBuilder validateMessage = new StringBuilder("");	
		validateIfAccountNumberAllDigits(validateMessage, accountTypeInput);
		validateIfCustomerPresent(validateMessage, customer);
		summarizeValidation(validateMessage);
	}

	private static void summarizeValidation(StringBuilder validateMessage) throws AddAccountValidation {
		if (validateMessage.length() != 0) 
			throw new AddAccountValidation(validateMessage.toString());
	}

	private static void validateIfCustomerPresent(StringBuilder validateMessage, Customer customer) {
		if (customer == null) 
			validateMessage.append("Customer does not exist.\n");
		
	}

	private static void validateIfAccountNumberAllDigits(StringBuilder validateMessage, String accountChose) {
		if (!accountChose.matches("[0-9]+"))
			validateMessage.append("Please provide Account Choice in number.\n");
	}

}
