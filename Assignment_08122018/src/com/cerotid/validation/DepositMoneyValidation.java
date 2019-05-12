package com.cerotid.validation;

import com.cerotid.bank.model.Account;

public class DepositMoneyValidation extends Exception{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2559935549840403179L;
	

	public DepositMoneyValidation(String message) {
		super(message);
	}

	public static boolean validateUserInput(Account receivingAccount, String depositAmount) throws NumberFormatException, DepositMoneyValidation{
		StringBuilder message = new StringBuilder("");
		double depositAmountDouble = Double.parseDouble(depositAmount);
		if(receivingAccount == null) {
			message.append("Receiving Account does not exist.");
		}
		if(depositAmountDouble <=0.00) {
			message.append("Receiving Amount has to be greater than 0.0");
		}
		if(message.length()!=0) {
			throw new DepositMoneyValidation(message.toString());
		}else {
			return true;
		}
	}
}
