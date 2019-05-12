package com.cerotid.validation;

public class TransactionValidation extends Exception{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1304121616906821800L;
	
	public TransactionValidation(String message) {
		super(message);
	}
	
	public static boolean validateWireTransfer(String beneficiaryFirstName, String beneficiaryLastName, String intermediaryBankSWIFTCode,
			String beneficiaryBankName, String beneficiaryAccountNumber) throws TransactionValidation {
		StringBuilder message = new StringBuilder("");
		if (beneficiaryFirstName.length()==0) {
			message.append("Beneficiary First Name can not be empty.\n");
		}
		if (beneficiaryLastName.length()==0) {
			message.append("Beneficiary Last Name can not be empty. \n");
		}
		if(intermediaryBankSWIFTCode.length()==0) {
			message.append("IntermediaryBankSWIFTCode can not be empty. \n");
		}
		if(beneficiaryBankName.length()==0) {
			message.append("BeneficiaryBankName can not empty. \n");
		}
		if(beneficiaryAccountNumber.length()==0) {
			message.append("BeneficiaryAccountNumber can not be empty. \n");
		}
		if (message.length()==0) {
			return true;
		}else {
			throw new TransactionValidation(message.toString());
		}
	}

}
