package com.cerotid.bank.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Account {
	
	public static int nextAccountNumber = 0;
	private AccountType accountType;
	private LocalDate accountOpenDate;
	private LocalDate accountCloseDate;
	private int accountNumber;
	//Should be using BigDecimal to represent money in Java
	private double amount;
	
	
	
	
	
	public Account(AccountType accountType) {
		this.accountType = accountType;
		this.accountOpenDate = LocalDate.now();
		this.accountCloseDate = null;
		this.accountNumber = ++nextAccountNumber;
		this.amount = 1000.0; //Account opening with $1000
	}


	public int getAccountNumber() {
		return accountNumber;
	}

	
	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	

	public LocalDate getAccountOpenDate() {
		return accountOpenDate;
	}


	public LocalDate getAccountCloseDate() {
		return accountCloseDate;
	}


	public void setAccountCloseDate(LocalDate accountCloseDate) {
		this.accountCloseDate = accountCloseDate;
	}


	public double getAmount() {
		return amount;
	}




	


	@Override
	public String toString() {
		return "Account [accountType=" + accountType + ", accountOpenDate=" + accountOpenDate + ", accountCloseDate="
				+ accountCloseDate + ", accountNumber=" + accountNumber + ", amount=" + amount + "]";
	}


	public void printAccountInfo() {
		System.out.println(this.toString());
	}
	
	public void sendMoney() {
		double sendingAmount;
		int selectedTransaction = -1;
		Scanner input = new Scanner (System.in);
		System.out.println("Please enter the amount you want to send: ");
		sendingAmount =Double.parseDouble(input.nextLine()); ;
		
		System.out.println("Please choose the type of transaction you want to use to send money. Please enter 1 for"
				+ "WireTransfer, 2 for ElectronicCheck and 3 for MoneyGram");
		selectedTransaction = Integer.parseInt(input.nextLine());
		
		if (selectedTransaction == 1){
			String beneficiaryFirstName, beneficiaryLastName, intermediaryBankSWIFTCode, beneficiaryBankName, beneficiaryAccountNumber;
			System.out.println("Welcome to WireTransfer. Please provide below information");
			System.out.println("Enter beneficiary firstName: ");
			beneficiaryFirstName = input.nextLine();
			System.out.println("Enter beneficiary lastName: ");
			beneficiaryLastName = input.nextLine();
			System.out.println("Enter intermediaryBankSWIFTCode: ");
			intermediaryBankSWIFTCode = input.nextLine();
			System.out.println("Enter beneficiaryBankName: ");
			beneficiaryBankName = input.nextLine();
			System.out.println("Enter beneficiaryAccountNumber: ");
			beneficiaryAccountNumber = input.nextLine();
			
			Transaction wireTransfer = new WireTransfer(this.accountNumber, sendingAmount, 10.00,"listedOnWireTransfer","listedOnWireTransfer",
					beneficiaryFirstName,beneficiaryLastName,intermediaryBankSWIFTCode,
					beneficiaryBankName,beneficiaryAccountNumber);
			wireTransfer.createTransaction();
			this.deductAccountBalance(sendingAmount+10.00);
			System.out.println("Final Amount Left in account: "+this.getAmount());

		}else if (selectedTransaction == 2){
			int checkOption;
			System.out.println("Welcome to Electronic Check. Please provide below information");
			System.out.println("What type of check would you like to use. Enter 1 for papercheck and 2 for eCheck: ");
			checkOption = input.nextInt();
			if (checkOption == 1) {
				Transaction electronicCheck = new ElectronicCheck(this.accountNumber, sendingAmount, CheckType.PaperCheck.getFee(),"listedOnCheck","listedOnCheck", CheckType.PaperCheck);
				electronicCheck.createTransaction();
				this.deductAccountBalance(sendingAmount + CheckType.PaperCheck.getFee());
				System.out.println("Final Amount Left in account: "+this.getAmount());
			}else if (checkOption == 2) {
				Transaction electronicCheck = new ElectronicCheck(this.accountNumber, sendingAmount, CheckType.ECheck.getFee(),"listedOnCheck","listedOnCheck", CheckType.ECheck);
				electronicCheck.createTransaction();
				this.deductAccountBalance(sendingAmount + CheckType.ECheck.getFee());
				System.out.println("Final Amount Left in account: "+this.getAmount());
			}else {
				System.out.println("Check Type does not exist. Try again.");
			}
			

		}else if (selectedTransaction == 3){
			int deliveryOption;
			String destinationCountry;
			System.out.println("Welcome to MoneyGram. Please provide below information");
			System.out.println("Please enter the destination country: ");
			destinationCountry = input.nextLine();
			System.out.println("Please choose delivery option. Enter 1 for 10Minute and 2 for 24HRS. ");
			deliveryOption = input.nextInt();
			if (deliveryOption == 1) {
				Transaction moneyGram = new MoneyGram(this.accountNumber, sendingAmount, DeliveryOption.TenMinutes.getFee(),"listedOnCheck",
						"listedOnCheck", DeliveryOption.TenMinutes, destinationCountry);
				moneyGram.createTransaction();
				this.deductAccountBalance(sendingAmount + DeliveryOption.TenMinutes.getFee());
				System.out.println("Final Amount Left in account: "+this.getAmount());
			}else if (deliveryOption == 2) {
				Transaction moneyGram = new MoneyGram(this.accountNumber, sendingAmount, DeliveryOption.TwentyFourHours.getFee(),"listedOnCheck",
						"listedOnCheck", DeliveryOption.TwentyFourHours,destinationCountry);
				moneyGram.createTransaction();
				this.deductAccountBalance(sendingAmount + DeliveryOption.TwentyFourHours.getFee());
				System.out.println("Final Amount Left in account: "+this.getAmount());
			}else {
				System.out.println("Delivery option does not exist. Try again.");
			}
		}else {
			System.out.println("Transfer Method does not exist. Try again.");

		}
		
		input.close();
		
	}
	
	private void deductAccountBalance(double deductionAmount) {
		this.amount -= deductionAmount;
	}
}
