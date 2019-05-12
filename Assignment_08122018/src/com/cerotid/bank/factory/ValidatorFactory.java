package com.cerotid.bank.factory;

import com.cerotid.validation.DepositMoneyValidation;
import com.cerotid.validation.SendingMoneyValidation;

public class ValidatorFactory {
	/*This class is responsible for creating object
	 *that can be used for validation.
	 *Using Factory Design Pattern
	 */
	
	public static Exception getObjectForValidation (String validationType){
	      if(validationType == null){
	         return null;
	      }		
	      if(validationType.equalsIgnoreCase("SendingMoneyValidation")){
	    	 Exception ex = new SendingMoneyValidation();
	         return ex;         
	      } else if(validationType.equalsIgnoreCase("DepositMoneyValidation")){
	    	Exception ex = new DepositMoneyValidation();
	    	return ex;     
	      } 
	      return null;
	   }
	
}
