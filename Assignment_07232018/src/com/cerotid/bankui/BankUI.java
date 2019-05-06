package com.cerotid.bankui;

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

public class BankUI {
	// You can try to make them boolean for validation or check if it null and do
	// nothing.
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

	private void addCustomer() {
		Customer newCustomer = getCustomerInfo();
		if (newCustomer == null) {
			displayCustomerInfoValidationMessage();
		} else {
			if (bankInterface.getCustomerInfo(newCustomer.getSsn()) == null) {
				bankInterface.addCustomer(newCustomer);
			} else {
				System.out.println("Can not add Customer. The customer already exists.");
			}
		}
	}

	// Rather try throwing custom exception
	private void addAccount() {
		Scanner customerInput = getScanner();
		System.out.println("Enter Customer's SSN: ");
		String ssn = customerInput.nextLine();
		Customer customer = bankInterface.getCustomerInfo(ssn);
		AccountType accountType = getAccountTypeInfo();
		if (customer == null || accountType == null) {
			System.out.println("Can not add Account. Customer and AccountType can not be null.");
		} else {
			bankInterface.openAccount(customer, new Account(accountType));
		}

	}

	private void editCustomerInfo() {
		Scanner editCustomerInput = getScanner();
		System.out.println("Enter Customer's SSN to edit: ");
		String ssn = editCustomerInput.nextLine();
		Customer oldCustomer = bankInterface.getCustomerInfo(ssn);
		if (oldCustomer == null) {
			System.out.println("Can not edit customer. The customer does not exists.");
		} else {
			System.out.println("You are editing the following customer.");
			System.out.println(oldCustomer);
			Customer newCustomer = getCustomerInfo();
			if (newCustomer == null) {
				System.out.println("Can not edit customer.");
				displayCustomerInfoValidationMessage();
			} else {
				if (bankInterface.getCustomerInfo(newCustomer.getSsn()) == null) {
					bankInterface.editCustomerInfo(oldCustomer, newCustomer);
				} else {
					System.out.println(
							"Can not edit customer with provided information. Provided SSN already exists for other customer.");
				}
			}
		}

	}

	private void sendMoney() {
		Scanner sendingAmountInput = getScanner();
		System.out.println("Please provide info about sending account.");
		Account sendingAccount = getAccountInfo();
		System.out.println("Please provide info about receiving account.");
		Account receivingAccount = getAccountInfo();
		double sendingAmount =0.0;
		System.out.println("Please enter amount you like to send.");		
		try {
			sendingAmount = Double.parseDouble(sendingAmountInput.nextLine());
		}
		catch(NumberFormatException ex) {
			ex.printStackTrace();
		}
		
		if (sendingAccount == null || receivingAccount == null || sendingAmount <= 0.00
				|| sendingAccount.equals(receivingAccount)) {
			System.out.println("Send Money Input validation failed.");
			System.out.println("SendingAccount can not be null.");
			System.out.println("ReceivingAccount can not be null.");
			System.out.println("Sending and Receiving Account can not be the same.");
			System.out.println("SendingAmount has to be greater than 0.00.");
		} else {
			Transaction transaction = getTransactionInfo(sendingAccount.getAccountNumber().toString(),
					receivingAccount.getAccountNumber().toString(), sendingAmount);
			if (transaction == null) {
				System.out.println("Send Money Input validation failed.");
				System.out.println("Transaction can not be null.");
			} else {
				bankInterface.sendMoney(sendingAccount, sendingAmount, receivingAccount, transaction);
			}
		}
	}

	private void depositMoney() {
		Scanner depositMoneyInput = getScanner();
		System.out.println("Please provide info about deposit account.");
		Account receivingAccount = getAccountInfo();
		System.out.println("Please enter amount you like to deposit.");
		double depositAmount = Double.parseDouble(depositMoneyInput.nextLine());
		if (receivingAccount == null || depositAmount <= 0.00) {
			System.out.println("Deposit Money Input Validation failed.");
			System.out.println("ReceivingAccount can not be null.");
			System.out.println("DepositAmount has to be greater than 0.00.");
		} else {
			bankInterface.depositMoneyInCustomerAccount(receivingAccount, depositAmount);
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
			if (customersByState.size() == 0) {
				System.out.println("No Customers found in provided state.");
			} else {
				System.out.println(customersByState);
			}
		}
	}

	public BankBO getBankInterface() {
		return bankInterface;
	}

	public void setBankInterface(BankBO bankInterface) {
		this.bankInterface = bankInterface;
	}

	private Customer getCustomerInfo() {
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
		if ((firstName.length() == 0 || lastName.length() == 0) || (ssn.length() == 0 || street.length() == 0)
				|| (city.length() == 0 || state.length() == 0) || (!ssn.matches("[0-9]+") || ssn.length() != 9)
				|| (state.length() != 2 || state.matches(".*\\d.*"))) {
			return null;
		} else {
			return new Customer(firstName, lastName, ssn, new Address(street, city, state));
		}

	}

	private AccountType getAccountTypeInfo() {
		AccountType accountType = null;
		Scanner accountTypeInput = getScanner();
		System.out.println("Choose Account type: [Default is Checking Account]");
		System.out.println("1. Checking  2. Saving  3. Business Checking");
		switch (accountTypeInput.nextInt()) {
		case 1:
			accountType = AccountType.Checking;
			break;
		case 2:
			accountType = AccountType.Saving;
			break;
		case 3:
			accountType = AccountType.Business_Checking;
			break;
		default:
			accountType = AccountType.Checking;
			break;
		}
		return accountType;
	}

	private Account getAccountInfo() {
		Scanner accountInput = getScanner();
		System.out.println("Please enter account number.");
		String accountNumber = accountInput.nextLine();
		return bankInterface.getAccountInfo(accountNumber);
	}

	private Transaction getTransactionInfo(String sendingAccount, String receivingAccount, double sendingAmount) {
		Scanner transactionTypeInput = getScanner();
		System.out.println("Please choose the type of transaction you want to use to send money. Please enter");
		System.out.println("1.WireTransfer");
		System.out.println("2.ElectronicCheck");
		System.out.println("3.MoneyGram");
		int transactionType = transactionTypeInput.nextInt();
		switch (transactionType) {
		case 1:
			return getWireTransfer(sendingAccount, receivingAccount, sendingAmount);
		case 2:
			return getElectronicCheck(sendingAccount, receivingAccount, sendingAmount);
		case 3:
			return getMoneyGram(sendingAccount, receivingAccount, sendingAmount);
		default:
			break;
		}
		return null;
	}

	private WireTransfer getWireTransfer(String sendingAccount, String receivingAccount, double sendingAmount) {
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
		if (beneficiaryFirstName.length()==0 || beneficiaryLastName.length()==0 || intermediaryBankSWIFTCode.length()==0
				|| beneficiaryBankName.length()==0 || beneficiaryAccountNumber.length()==0) {
			return null;
		} else {
			return new WireTransfer(sendingAccount, receivingAccount, sendingAmount, beneficiaryFirstName,
					beneficiaryLastName, intermediaryBankSWIFTCode, beneficiaryBankName, beneficiaryAccountNumber);
		}
	}

	private ElectronicCheck getElectronicCheck(String sendingAccount, String receivingAccount, double sendingAmount) {
		Scanner checkInput = getScanner();
		int checkOption;
		System.out.println("Welcome to Electronic Check. Please provide below information");
		System.out.println("What type of check would you like to use.");
		System.out.println("1. PaperCheck  2. ECheck");
		checkOption = checkInput.nextInt();
		switch (checkOption) {
		case 1:
			return new ElectronicCheck(sendingAccount, receivingAccount, sendingAmount, CheckType.PaperCheck.getFee(),
					CheckType.PaperCheck);
		case 2:
			return new ElectronicCheck(sendingAccount, receivingAccount, sendingAmount, CheckType.ECheck.getFee(),
					CheckType.ECheck);
		default:
			System.out.println("Check Type does not exist");
			break;
		}
		return null;

	}

	private MoneyGram getMoneyGram(String sendingAccount, String receivingAccount, double sendingAmount) {
		Scanner moneyGramInput = getScanner();
		int deliveryOption;
		String destinationCountry;
		System.out.println("Welcome to Money. Please provide below information");
		System.out.println("Please enter the destination country: ");
		destinationCountry = moneyGramInput.nextLine();
		System.out.println("What type of delivery option would you like to use.");
		System.out.println("1. 10Minutes  2. 24Hrs");
		deliveryOption = moneyGramInput.nextInt();
		switch (deliveryOption) {
		case 1:
			return new MoneyGram(sendingAccount, receivingAccount, sendingAmount, DeliveryOption.TenMinutes.getFee(),
					DeliveryOption.TenMinutes, destinationCountry);
		case 2:
			return new MoneyGram(sendingAccount, receivingAccount, sendingAmount,
					DeliveryOption.TwentyFourHours.getFee(), DeliveryOption.TwentyFourHours, destinationCountry);
		default:
			System.out.println("Delivery Option does not exist");
			break;
		}
		return null;

	}

	private void displayCustomerInfoValidationMessage() {
		System.out.println("Customer Input validation failed.");
		System.out.println("Customer info can not be empty.");
		System.out.println("SSN has to be 9 digits.");
		System.out.println("State has to 2 characters.");
		System.out.println();
	}

}
