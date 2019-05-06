package demo1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App {
	// Ctrl+Shift+o to import
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File ("test.txt");
		/*
		 * The following line throws an exception.
		 * You can throw an exceptions on method level
		 * or use try catch method. When exception is thrown in method level
		 * you get the stack trace of what error is.
		 * 
		 */
		FileReader fr = new FileReader(file);
		try {
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
