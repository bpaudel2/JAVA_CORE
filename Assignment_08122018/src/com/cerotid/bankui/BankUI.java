package com.cerotid.bankui;

import java.io.Serializable;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

import com.cerotid.bank.model.Account;
import com.cerotid.bank.model.AccountType;
import com.cerotid.bank.model.Address;
import com.cerotid.bank.model.CheckType;
import com.cerotid.bank.model.Customer;
import com.cerotid.bank.model.DeliveryOption;
import com.cerotid.bank.model.ElectronicCheck;
import com.cerotid.bank.model.MoneyGram;
import com.cerotid.bank.model.Transaction;
import com.cerotid.bank.model.WireTransfer;
import com.cerotid.bo.BankBO;
import com.cerotid.bo.BankBOImpl;
import com.cerotid.validation.AddAccountValidation;
import com.cerotid.validation.CustomerValidation;
import com.cerotid.validation.DepositMoneyValidation;
import com.cerotid.validation.SendingMoneyValidation;
import com.cerotid.validation.TransactionValidation;

public class BankUI {
	private BankBO bankInterface;

	public static void main(String[] args) {
		BankUI bankUI = new BankUI();
		bankUI.setBankInterface(new BankBOImpl());
		bankUI.bankInterface.deserializeBank();
		while (true) {
			displayMenu();
			bankUI.performAction();
		}
	}

	private static Scanner getScanner() {
		return new Scanner(System.in);
	}

	private static void displayMenu() {
		System.out.println("Choose from the menu below:");
		System.out.println("1. Add Customer");
		System.out.println("2. Edit Customer Info");
		System.out.println("3. Add Account");
		System.out.println("4. Send Money");
		System.out.println("5. Print Bank Status");
		System.out.println("6. Deposit Money");
		System.out.println("7. Print All Customers By State");
		System.out.println("8. Exit");
	}

	private void performAction() {
		Scanner userInput = getScanner();
		while (true) {
			try {
				switch (userInput.nextInt()) {
				case 1:
					addCustomer();
					break;
				case 2:
					editCustomerInfo();
					break;
				case 3:
					addAccount();
					break;
				case 4:
					sendMoney();
					break;
				case 5:
					bankInterface.printBankStatus();
					break;
				case 6:
					depositMoney();
					break;
				case 7:
					printCustomerByState();
					break;
				case 8:
					System.out.println("Thank you for visting out Bank!!");
					bankInterface.serializeBank();
					System.exit(0);
					break;
				default:
					System.out.println("Not in option!");
					break;
				}

				break; // breaks while loop when it execution point gets here
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	// Reflection: to test private method
	private void addCustomer() {
		try {
			Customer newCustomer = userInputForCustomerInfo();
			bankInterface.addCustomer(newCustomer);
		} catch (CustomerValidation cv) {
			System.out.println(cv.getMessage());
		}
	}

	private void addAccount() {
		Dictionary<String, Serializable> validUserInputForAddAccount = new Hashtable<String, Serializable>();
		try {
			validUserInputForAddAccount = getUserInputForAddAccount();
			bankInterface.openAccount((Customer) validUserInputForAddAccount.get("customer"),
					new Account((AccountType) validUserInputForAddAccount.get("accountType")));
		} catch (AddAccountValidation ex) {
			System.out.println(ex.getMessage());
		}
	}

	private void editCustomerInfo() {
		Scanner editCustomerInput = getScanner();
		System.out.println("Enter Customer's SSN to edit: ");
		String ssn = editCustomerInput.nextLine();
		if (!bankInterface.customerExist(ssn)) {
			System.out.println("Can not edit customer. The customer does not exists.");
		} else {
			System.out.println("You are editing the following customer.");
			Customer oldCustomer = bankInterface.getCustomerInfo(ssn);
			System.out.println(oldCustomer);
			try {
				Customer newCustomer = userInputForCustomerInfo();
				if (oldCustomer.equals(newCustomer)) {
					bankInterface.editCustomerInfo(oldCustomer, newCustomer);
				} else {
					System.out.println("You can NOT edit SSN of existing Customer.");
				}

			} catch (CustomerValidation cv) {
				System.out.println(cv.getMessage());
			}
		}
	}

	private void sendMoney() {
		Dictionary<String, Serializable> validUserInputForSendMoney = new Hashtable<String, Serializable>();
		try {
			validUserInputForSendMoney = getUserInputForSendMoney();
			bankInterface.sendMoney((Account) validUserInputForSendMoney.get("sendingAccount"),
					(double) validUserInputForSendMoney.get("sendingAmount"),
					(Account) validUserInputForSendMoney.get("receivingAccount"),
					(Transaction) validUserInputForSendMoney.get("transaction"));
		} catch (NumberFormatException ex) {
			System.out.println(ex.getMessage());
		} catch (TransactionValidation ex) {
			System.out.println(ex.getMessage());
		} catch (SendingMoneyValidation ex) {
			System.out.println(ex.getMessage());
		}
	}

	private void depositMoney() {
		Dictionary<String, Serializable> validUserInputForDepositMoney = new Hashtable<String, Serializable>();
		try {
			validUserInputForDepositMoney = getUserInputForDepositMoney();
			bankInterface.depositMoneyInCustomerAccount((Account) validUserInputForDepositMoney.get("receivingAccount"),
					(double) validUserInputForDepositMoney.get("receivingAmount"));
		} catch (DepositMoneyValidation ex) {
			System.out.println(ex.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	private void printCustomerByState() {
		Scanner customerByStateInput = getScanner();
		System.out.println("Please enter the state code [2 characters only]");
		String stateCode = customerByStateInput.nextLine();
		if (stateCode.length() != 2 || stateCode.matches(".*\\d.*")) {
			System.out.println("StateCode has to be 2 characters.");
		} else {
			List<Customer> customersByState = bankInterface.getCustomerByState(stateCode);
			System.out.println(customersByState);
		}
	}

	public BankBO getBankInterface() {
		return bankInterface;
	}

	public void setBankInterface(BankBO bankInterface) {
		this.bankInterface = bankInterface;
	}

	private Customer userInputForCustomerInfo() throws CustomerValidation {
		Scanner customerInput = getScanner();
		String firstName, lastName, ssn, street, city, state;
		System.out.println("Enter Customer First Name: ");
		firstName = customerInput.nextLine();
		System.out.println("Enter Customer Last Name: ");
		lastName = customerInput.nextLine();
		System.out.println("Enter Customer Social Security Number: ");
		ssn = customerInput.nextLine();
		System.out.println("Provide information for Customer Address:  ");
		System.out.println("Enter Street Name:  ");
		street = customerInput.nextLine();
		System.out.println("Enter City Name: ");
		city = customerInput.nextLine();
		System.out.println("Enter 2 Characters StateCode: ");
		state = customerInput.nextLine();
		CustomerValidation.validateUserInput(firstName, lastName, ssn, street, city, state);
		return new Customer(firstName, lastName, ssn, new Address(street, city, state));
	}

	private Dictionary<String, Serializable> getUserInputForAddAccount() throws AddAccountValidation {
		Scanner inputForAddAccount = getScanner();
		System.out.println("Enter Customer's SSN: ");
		String ssn = inputForAddAccount.nextLine();
		System.out.println("Choose Account type: [Default is Checking Account]");
		System.out.println("1. Checking  2. Saving  3. Business Checking");
		String accountChose = inputForAddAccount.nextLine();
		Customer customer = bankInterface.getCustomerInfo(ssn);
		AddAccountValidation.validateUserInput(customer, accountChose);
		Dictionary<String, Serializable> validInputHolder = new Hashtable<String, Serializable>();
		int accountChoseInt = Integer.parseInt(accountChose);
		AccountType accountType = getAccountType(accountChoseInt);
		validInputHolder.put("customer", customer);
		validInputHolder.put("accountType", accountType);
		return validInputHolder;
	}

	private AccountType getAccountType(int accountTypeChose) {
		switch (accountTypeChose) {
		case 1:
			return AccountType.Checking;
		case 2:
			return AccountType.Saving;
		case 3:
			return AccountType.Business_Checking;
		default:
			return AccountType.Checking;
		}
	}

	private Dictionary<String, Serializable> getUserInputForDepositMoney()
			throws NumberFormatException, DepositMoneyValidation {
		Scanner depositMoneyInput = getScanner();
		System.out.println("Please provide info about deposit account.");
		Account receivingAccount = getUserInputForAccountNumber();
		System.out.println("Please enter amount you like to deposit.");
		String depositAmount = depositMoneyInput.nextLine();
		DepositMoneyValidation.validateUserInput(receivingAccount, depositAmount);
		Dictionary<String, Serializable> validUserInputForDepositMoney = new Hashtable<String, Serializable>();
		validUserInputForDepositMoney.put("receivingAccount", receivingAccount);
		validUserInputForDepositMoney.put("receivingAmount", Double.parseDouble(depositAmount));
		return validUserInputForDepositMoney;
	}

	private Dictionary<String, Serializable> getUserInputForSendMoney()
			throws NumberFormatException, TransactionValidation, SendingMoneyValidation {
		Scanner sendingAmountInput = getScanner();
		System.out.println("Please provide info about sending account.");
		Account sendingAccount = getUserInputForAccountNumber();
		System.out.println("Please provide info about receiving account.");
		Account receivingAccount = getUserInputForAccountNumber();
		System.out.println("Please enter amount you like to send.");
		String sendingAmount = sendingAmountInput.nextLine();
		SendingMoneyValidation.validateUserInput(sendingAccount, receivingAccount, sendingAmount);
		Transaction transaction = userInputForTransaction(sendingAccount.getAccountNumber().toString(),
				receivingAccount.getAccountNumber().toString(), sendingAmount);
		Dictionary<String, Serializable> validInputHolder = new Hashtable<String, Serializable>();
		validInputHolder.put("receivingAccount",  receivingAccount);
		validInputHolder.put("sendingAmount", Double.parseDouble(sendingAmount));
		validInputHolder.put("transaction", transaction);
		validInputHolder.put("sendingAccount", sendingAccount);
		return validInputHolder;
	}

	private WireTransfer getWireTransfer(String sendingAccount, String receivingAccount, String sendingAmount)
			throws TransactionValidation {
		Scanner wireTransferInput = getScanner();
		String beneficiaryFirstName, beneficiaryLastName, intermediaryBankSWIFTCode, beneficiaryBankName,
				beneficiaryAccountNumber;
		System.out.println("Welcome to WireTransfer. Please provide below information");
		System.out.println("Enter beneficiary firstName: ");
		beneficiaryFirstName = wireTransferInput.nextLine();
		System.out.println("Enter beneficiary lastName: ");
		beneficiaryLastName = wireTransferInput.nextLine();
		System.out.println("Enter intermediaryBankSWIFTCode: ");
		intermediaryBankSWIFTCode = wireTransferInput.nextLine();
		System.out.println("Enter beneficiaryBankName: ");
		beneficiaryBankName = wireTransferInput.nextLine();
		System.out.println("Enter beneficiaryAccountNumber: ");
		beneficiaryAccountNumber = wireTransferInput.nextLine();
		TransactionValidation.validateWireTransfer(beneficiaryFirstName, beneficiaryLastName, intermediaryBankSWIFTCode,
				beneficiaryBankName, beneficiaryAccountNumber);
		double sendingAmountDouble = Double.parseDouble(sendingAmount);
		return new WireTransfer(sendingAccount, receivingAccount, sendingAmountDouble, beneficiaryFirstName,
				beneficiaryLastName, intermediaryBankSWIFTCode, beneficiaryBankName, beneficiaryAccountNumber);
	}

	private Transaction userInputForTransaction(String sendingAccountNumber, String receivingAccountNumber,
			String sendingAmount) throws NumberFormatException, TransactionValidation {
		Scanner transactionTypeInput = getScanner();
		System.out.println("Please choose the type of transaction you want to use to send money. Please enter");
		System.out.println("1.WireTransfer");
		System.out.println("2.ElectronicCheck");
		System.out.println("3.MoneyGram");
		String transactionType = transactionTypeInput.nextLine();
		int transactionTypeInt = Integer.parseInt(transactionType);
		switch (transactionTypeInt) {
		case 1:
			return getWireTransfer(sendingAccountNumber, receivingAccountNumber, sendingAmount);
		case 2:
			return getElectronicCheck(sendingAccountNumber, receivingAccountNumber, sendingAmount);
		case 3:
			return getMoneyGram(sendingAccountNumber, receivingAccountNumber, sendingAmount);
		default:
			throw new TransactionValidation("Transaction Type does not exist.\n");
		}
	}

	private Account getUserInputForAccountNumber() {
		Scanner accountInput = getScanner();
		System.out.println("Please enter account number.");
		String accountNumber = accountInput.nextLine();
		return bankInterface.getAccountInfo(accountNumber);
	}

	private ElectronicCheck getElectronicCheck(String sendingAccount, String receivingAccount, String sendingAmount)
			throws TransactionValidation {
		Scanner checkInput = getScanner();
		System.out.println("Welcome to Electronic Check. Please provide below information");
		System.out.println("What type of check would you like to use.");
		System.out.println("1. PaperCheck  2. ECheck");
		String checkOption = checkInput.nextLine();
		int checkOptionInt = Integer.parseInt(checkOption);
		switch (checkOptionInt) {
		case 1:
			return new ElectronicCheck(sendingAccount, receivingAccount, Double.parseDouble(sendingAmount),
					CheckType.PaperCheck.getFee(), CheckType.PaperCheck);
		case 2:
			return new ElectronicCheck(sendingAccount, receivingAccount, Double.parseDouble(sendingAmount),
					CheckType.ECheck.getFee(), CheckType.ECheck);
		default:
			throw new TransactionValidation("Electronic Check Type does not exist. \n");
		}
	}

	private MoneyGram getMoneyGram(String sendingAccount, String receivingAccount, String sendingAmount)
			throws NumberFormatException, TransactionValidation {
		Scanner moneyGramInput = getScanner();
		System.out.println("Welcome to MoneyGram. Please provide below information");
		System.out.println("Please enter the destination country: ");
		String destinationCountry = moneyGramInput.nextLine();
		System.out.println("What type of delivery option would you like to use.");
		System.out.println("1. 10Minutes  2. 24Hrs");
		String deliveryOption = moneyGramInput.nextLine();
		int deliveryOptionInt = Integer.parseInt(deliveryOption);
		switch (deliveryOptionInt) {
		case 1:
			return new MoneyGram(sendingAccount, receivingAccount, Double.parseDouble(sendingAmount),
					DeliveryOption.TenMinutes.getFee(), DeliveryOption.TenMinutes, destinationCountry);
		case 2:
			return new MoneyGram(sendingAccount, receivingAccount, Double.parseDouble(sendingAmount),
					DeliveryOption.TwentyFourHours.getFee(), DeliveryOption.TwentyFourHours, destinationCountry);
		default:
			throw new TransactionValidation("Delivery Option does not exist. \n");
		}
	}

}
