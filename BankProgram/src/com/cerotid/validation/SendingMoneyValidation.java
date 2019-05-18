package com.cerotid.validation;

import com.cerotid.bank.model.Account;

public class SendingMoneyValidation extends Exception{


	/**
	 * 
	 */
	private static final long serialVersionUID = 4216493958139822487L;
	private StringBuilder validationMessage = new StringBuilder("");
	
	public SendingMoneyValidation() {
		
	}
	
	public SendingMoneyValidation(String message) {
		super(message);
	}
	
	public void validateUserInput(Account sendingAccount, Account receivingAccount, String sendingAmount) throws SendingMoneyValidation {
		validateSendingAndReceivingAccount(sendingAccount, receivingAccount);
		try {
			double sendingAmountDouble = Double.parseDouble(sendingAmount);
			if (sendingAmountDouble <= 0.00) {
				validationMessage.append("Sending Amount has to be greater than 0.00.");
			}
		}catch(NumberFormatException ex) {
			validationMessage.append(ex.getMessage());
		}
		if(validationMessage.length()!=0) {
			throw new SendingMoneyValidation(validationMessage.toString());
		}
	}

	private void validateSendingAndReceivingAccount(Account sendingAccount, Account receivingAccount) {
		if(sendingAccount==null||receivingAccount == null) {
			validationMessage.append("Sending or Receiving Account does not exists.\n");
		}
		if(sendingAccount.equals(receivingAccount)) {
			validationMessage.append("Sending and Receiving Account can not be the same.\n");
		}	
	}
}
