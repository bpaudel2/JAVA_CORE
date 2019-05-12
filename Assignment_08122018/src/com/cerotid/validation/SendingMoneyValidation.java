package com.cerotid.validation;

import com.cerotid.bank.model.Account;

public class SendingMoneyValidation extends Exception{


	/**
	 * 
	 */
	private static final long serialVersionUID = 4216493958139822487L;

	public SendingMoneyValidation(String message) {
		super(message);
	}
	
	public static boolean validateUserInput(Account sendingAccount, Account receivingAccount, String sendingAmount) throws SendingMoneyValidation {
		StringBuilder message = new StringBuilder("");	
		if(sendingAccount==null||receivingAccount == null) {
			message.append("Sending or Receiving Account does not exists.\n");
		}
		try {
			double sendingAmountDouble = Double.parseDouble(sendingAmount);
			if (sendingAmountDouble <= 0.00) {
				message.append("Sending Amount has to be greater than 0.00.");
			}
		}catch(NumberFormatException ex) {
			message.append(ex.getMessage());
		}
		if(sendingAccount.equals(receivingAccount)) {
			message.append("Sending Account and Receiving Account can not be the same.\n");
		}
		if(message.length()!=0) {
			throw new SendingMoneyValidation(message.toString());
		}else {
			return true;
		}
	}
}
