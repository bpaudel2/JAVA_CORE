package com.cerotid.bank.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.cerotid.bank.model.Customer;

public class ReaderWriter {

	private static File inputFile = new File(".\\src\\input/Customers.txt");
	private static File outputFile = new File(".\\src\\output/output.txt");
	private static List<Customer> customersList = new ArrayList<Customer>();
	
	public static void readWriteCustomerFile() {
		readCustomerFile();
		writeCustomerFile();
	}
	
	
	private static void readCustomerFile() {		
		try {
			FileInputStream fis = new FileInputStream(inputFile);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				String[] nameArray = line.split(",");
				Customer customerRetrieved = new Customer(nameArray[1], nameArray[0],"123456789");
				customersList.add(customerRetrieved);

			}

			br.close();
		} catch (FileNotFoundException e) {
			// File not found
			e.printStackTrace();
		} catch (IOException e) {
			// Error when reading the file
			e.printStackTrace();
		}
	}
	
	
	private static void writeCustomerFile() {
		customersList.sort(Comparator.comparing(Customer::getLastName));
		try {
			FileWriter fw = new FileWriter(outputFile);

			for (Customer customer : customersList) {
				fw.write(customer.getLastName() + ", " + customer.getFirstName() + "\n");
			}
			fw.close();
		} catch (FileNotFoundException e) {
			// File not found
			e.printStackTrace();
		} catch (IOException e) {
			// Error when writing to the file
			e.printStackTrace();
		}
	}
	
	
}
