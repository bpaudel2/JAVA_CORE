package com.cerotid.validation;

import com.cerotid.bank.model.Account;

public class DepositMoneyValidation extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8555077055994582690L;
	private StringBuilder validationMessage = new StringBuilder("");

	public DepositMoneyValidation() {
	}
	
	public DepositMoneyValidation(String message) {
		super(message);
	}

	public void validateUserInput(Account receivingAccount, String depositAmount) throws NumberFormatException, DepositMoneyValidation{
		double depositAmountDouble = Double.parseDouble(depositAmount);
		validateIfReceivingAccountExists(receivingAccount);
		validateIfDepositMoney(depositAmountDouble);
		if(validationMessage.length()!=0) {
			throw new DepositMoneyValidation(validationMessage.toString());
		}
	}

	private void validateIfDepositMoney(double depositAmountDouble) {
		if(depositAmountDouble <=0.00) {
			validationMessage.append("Receiving Amount has to be greater than 0.0. \n");
		}	
	}

	private void validateIfReceivingAccountExists(Account receivingAccount) {
		if(receivingAccount == null) {
			validationMessage.append("Receiving Account does not exist.\n");
		}	
	}
}
