package com.cerotid.validation;

public class CustomerValidation extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CustomerValidation(String message) {
		super(message);		
	}
	
	public static void validateUserInput(String firstName, String lastName, String ssn, 
			String street, String city, String state) throws CustomerValidation {
		StringBuilder message = new StringBuilder("");		
		if (firstName.length()==0) {
			message.append("First Name can not be empty.\n");
		}		
		if(lastName.length()==0) {
			message.append("Last Name can not be empty.\n");
		}
		if((ssn.length()!=9)||(!ssn.matches("[0-9]+"))) {
			message.append("SSN has to be 9 digits only.\n");
		}
		if(street.length()==0) {
			message.append("Street can not be empty.\n");
		}
		if(city.length()==0) {
			message.append("City can not be empty.");
		}
		if((state.length() != 2 || state.matches(".*\\d.*"))) {
			message.append("State has to be 2 characters only.\n");
		}
		if(message.length()!=0) {
			throw new CustomerValidation(message.toString());
		}		
	}
	
}
