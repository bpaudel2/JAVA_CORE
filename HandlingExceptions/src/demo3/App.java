package demo3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

// Exceptions can be thrown from one method to another
// Can be catched in different application
public class App {
	public static void main(String[] args) {
		// You can also throw an exception in application level or
		// use try catch here
		try{
			openFile();
		}catch(FileNotFoundException e) {
			System.out.println("Could not open file.");
		}
	}
	public static void openFile() throws FileNotFoundException {
		File file = new File("test.txt");
		FileReader fr = new FileReader(file);
	}
	
}
